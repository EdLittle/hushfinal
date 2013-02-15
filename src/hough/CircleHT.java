package hough;

import image.edge.ImageEdge;
import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;
import java.awt.*;
import ij.gui.*;
import image.edge.ImageEdge;
import java.awt.geom.Ellipse2D;
import java.lang.Object.*;

/**
*   This ImageJ plugin shows the Hough Transform Space and search for
*   circles in a binary image. The image must have been passed through
*   an edge detection module and have edges marked in white (background
*   must be in black).
*/
public class CircleHT implements PlugInFilter {

    public int radiusMin;  // Find circles with radius grater or equal radiusMin
    public int radiusMax;  // Find circles with radius less or equal radiusMax
    public int rMax_;  // Find circles with radius less or equal radiusMax
    public int radiusInc;  // Increment used to go from radiusMin to radiusMax
    public int maxCircles; // Numbers of circles to be found
    public int threshold = -1; // An alternative to maxCircles. All circles with
    // a value in the hough space greater then threshold are marked. Higher thresholds
    // results in fewer circles.
    byte imageValues[]; // Raw image (returned by ip.getPixels())
    double houghValues[][][]; // Hough Space Values
    public int width; // Hough Space width (depends on image width)
    public int height;  // Hough Space heigh (depends on image height)
    public int depth;  // Hough Space depth (depends on radius interval)
    public int offset; // Image Width
    public int offx;   // ROI x offset
    public int offy;   // ROI y offset
    Point centerPoint[]; // Center Points of the Circles Found.
    private int vectorMaxSize = 500;
    boolean useThreshold = false;
    int lut[][][]; // LookUp Table for rsin e rcos values
    
    public final double xmin= 0.0;
    public final double xmax= 450.0;
    public final double ymin= 0.0;
    public final double ymax= 450.0;

 
   // public StdDraw draw = new StdDraw();

    public CircleHT() {
    }


    public int setup(String arg, ImagePlus imp) {
        if (arg.equals("about")) {
     //       showAbout();
            return DONE;
        }
        return DOES_8G+DOES_STACKS+SUPPORTS_MASKING;
    }

    public void processImage(ImagePlus pic) {
        new ImageConverter(pic).convertToGray16();
        ImageProcessor ip = pic.getProcessor();
        ImageProcessor edges = ImageEdge.areaEdge(ip, (double) 5, (float).10, (float) 100, (float) 50);
        ip = ImageEdge.areaEdge(ip, 5, (float)1.0, 100, 50);
        run(ip);       
    }
    public void run(ImageProcessor ip) {

        imageValues = (byte[])ip.getPixels();
        Rectangle r = ip.getRoi();

        offx = r.x;
        offy = r.y;
        width = r.width;
        height = r.height;                           
        offset = ip.getWidth();

        radiusMin = 50;
        radiusMax = 200;
        radiusInc = 2;
        depth = ((radiusMax-radiusMin)/radiusInc)+1;
        maxCircles = 0;
        threshold = 95;
        useThreshold = true;
        
        houghTransform();
        getCenterPointsByThreshold(threshold);
     }
            
    private int buildLookUpTable() {

        int i = 0;
        int incDen = Math.round (8F * radiusMin);  // increment denominator

        lut = new int[2][incDen][depth];

        for(int radius = radiusMin;radius <= radiusMax;radius = radius+radiusInc) {
            i = 0;
            for(int incNun = 0; incNun < incDen; incNun++) {
                double angle = (2*Math.PI * (double)incNun) / (double)incDen;
                int indexR = (radius-radiusMin)/radiusInc;
                int rcos = (int)Math.round ((double)radius * Math.cos (angle));
                int rsin = (int)Math.round ((double)radius * Math.sin (angle));
                if((i == 0) | (rcos != lut[0][i][indexR]) & (rsin != lut[1][i][indexR])) {
                    lut[0][i][indexR] = rcos;
                    lut[1][i][indexR] = rsin;
                    i++;
                    
                }
            }
        }
                
        return i;
    }

    private void houghTransform () {
        int lutSize = buildLookUpTable();

        houghValues = new double[width][height][depth];

        int k = width - 1;
        int l = height - 1;

        for(int y = 1; y < l; y++) {
            for(int x = 1; x < k; x++) {
                for(int radius = radiusMin;radius <= radiusMax;radius = radius+radiusInc) {
                    if( imageValues[(x+offx)+(y+offy)*offset] != 0 )  {// Edge pixel found
                        int indexR=(radius-radiusMin)/radiusInc;
                        for(int i = 0; i < lutSize; i++) {

                            int a = x + lut[1][i][indexR]; 
                            int b = y + lut[0][i][indexR]; 
                            if((b >= 0) & (b < height) & (a >= 0) & (a < width)) {
                                houghValues[a][b][indexR] += 1;
                            }
                        }
                    }
                }
            }
        }
    }


    /** Search circles having values in the hough space higher than a threshold
    @param threshold The threshold used to select the higher point of Hough Space
    */
    private void getCenterPointsByThreshold (int threshold) {

        centerPoint = new Point[vectorMaxSize];
        int xMax = 0;
        int yMax = 0;
        int countCircles = 0;

        detectCircle:
        for(int radius = radiusMin;radius <= radiusMax;radius = radius+radiusInc) {
            int indexR = (radius-radiusMin)/radiusInc;
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    if(houghValues[x][y][indexR] > threshold) {
                        if(countCircles < vectorMaxSize) {
                            centerPoint[countCircles] = new Point (x, y);                      
                           // clearNeighbours(xMax,yMax,radius);
                            ++countCircles;
                             System.out.println("Found circle!!");
                             break detectCircle;       
                        } else
                            break;
                    }
                }
            }
        }
        maxCircles = countCircles;
        System.out.println("circle! " + countCircles);
                             
    }

    public boolean isDetected() {
        if (maxCircles>0)
                return true;
        else    
                return false;
    }
   
} /*
     * Clear, from the Hough Space, all the counter that are near (radius/2) a previously found circle C.
        
    @param x The x coordinate of the circle C found.
    @param x The y coordinate of the circle C found.
    @param x The radius of the circle C found.
    
    private void clearNeighbours(int x,int y, int radius) {

        // The following code just clean the points around the center of the circle found.

        double halfRadius = radius / 2.0F;
	double halfSquared = halfRadius*halfRadius;

        int y1 = (int)Math.floor ((double)y - halfRadius);
        int y2 = (int)Math.ceil ((double)y + halfRadius) + 1;
        int x1 = (int)Math.floor ((double)x - halfRadius);
        int x2 = (int)Math.ceil ((double)x + halfRadius) + 1;

        if(y1 < 0)
            y1 = 0;
        if(y2 > height)
            y2 = height;
        if(x1 < 0)
            x1 = 0;
        if(x2 > width)
            x2 = width;

        for(int r = radiusMin;r <= radiusMax;r = r+radiusInc) {
            int indexR = (r-radiusMin)/radiusInc;
            for(int i = y1; i < y2; i++) {
                for(int j = x1; j < x2; j++) {	      	     
                    if(Math.pow (j - x, 2D) + Math.pow (i - y, 2D) < halfSquared) {
                        houghValues[j][i][indexR] = 0.0D;
                    }
                }
            }
        }
    }
    
}*/


            /* Create image View for Hough Transform.
            ImageProcessor newip = new ByteProcessor(width, height);
            byte[] newpixels = (byte[])newip.getPixels();
            createHoughPixels(newpixels);

            // Create image View for Marked Circles.
        //    ImageProcessor circlesip = new ByteProcessor(width, height);
          //  byte[] circlespixels = (byte[])circlesip.getPixels();

            // Mark the center of the found circles in a new image
         //   if(useThreshold)
                

     //   }
    }
    */

   
    /*
	// Draw the circles found in the original image.
	public void drawCircles(byte[] circlespixels) {
		
		// Copy original input pixels into output
		// circle location display image and
		// combine with saturation at 100
		int roiaddr=0;
		for( int y = offy; y < offy+height; y++) {
			for(int x = offx; x < offx+width; x++) {
				// Copy;
				circlespixels[roiaddr] = imageValues[x+offset*y];
				// Saturate
				if(circlespixels[roiaddr] != 0 )
					circlespixels[roiaddr] = 100;
				else
					circlespixels[roiaddr] = 0;
				roiaddr++;
			}
		}
		// Copy original image to the circlespixels image.
		// Changing pixels values to 100, so that the marked
		// circles appears more clear. Must be improved in
		// the future to show the resuls in a colored image.
		for(int i = 0; i < width*height ;++i ) {
                    if(imageValues[i] != 0 )
                        if(circlespixels[i] != 0 )
                            circlespixels[i] = 100;
                        else
                           circlespixels[i] = 0;
                }
		
                if(centerPoint == null) {
			if(useThreshold)
                            getCenterPointsByThreshold(threshold);
			else
                            getCenterPoints(maxCircles);
		}
		byte cor = -1;
		// Redefine these so refer to ROI coordinates exclusively
		int offset = width;
		int offx=0;
		int offy=0;        
         
		for(int l = 0; l < maxCircles; l++) {
			int i = centerPoint[l].x;
			int j = centerPoint[l].y;
			// Draw a gray cross marking the center of each circle.
			for( int k = -20 ; k <= 20 ; ++k ) {
				int p = (j+k+offy)*offset + (i+offx);
				if(!outOfBounds(j+k+offy,i+offx))
					circlespixels[(j+k+offy)*offset + (i+offx)] = cor;
				if(!outOfBounds(j+offy,i+k+offx))
					circlespixels[(j+offy)*offset   + (i+k+offx)] = cor;
			}
			for( int k = -2 ; k <= 2 ; ++k ) {
				if(!outOfBounds(j-2+offy,i+k+offx))
					circlespixels[(j-2+offy)*offset + (i+k+offx)] = cor;
				if(!outOfBounds(j+2+offy,i+k+offx))
					circlespixels[(j+2+offy)*offset + (i+k+offx)] = cor;
				if(!outOfBounds(j+k+offy,i-2+offx))
					circlespixels[(j+k+offy)*offset + (i-2+offx)] = cor;
				if(!outOfBounds(j+k+offy,i+2+offx))
					circlespixels[(j+k+offy)*offset + (i+2+offx)] = cor;
			}
		}
	}
    private boolean outOfBounds(int y,int x) {
        if(x >= width)
            return(true);
        if(x <= 0)
            return(true);
        if(y >= height)
            return(true);
        if(y <= 0)
            return(true);
        return(false);
    }

*/


/**
    boolean readParameters() {

        radiusMin = 50;
        radiusMax = 200;
        radiusInc = 2;
        depth = ((radiusMax-radiusMin)/radiusInc)+1;
        maxCircles = 0;
        threshold = 95;
        useThreshold = true;
        return(true);
    }

     The parametric equation for a circle centered at (a,b) with
        radius r is:

    a = x - r*cos(theta)
    b = y - r*sin(theta)

    In order to speed calculations, we first construct a lookup
    table (lut) containing the rcos(theta) and rsin(theta) values, for
    theta varying from 0 to 2*PI with increments equal to
    1/8*r. As of now, a fixed increment is being used for all
    different radius (1/8*radiusMin). This should be corrected in
    the future.

    Return value = Number of angles for each radius
       
    */


    /* Convert Values in Hough Space to an 8-Bit Image Space.
    private void createHoughPixels (byte houghPixels[]) {
        double d = -1D;
        for(int j = 0; j < height; j++) {
            for(int k = 0; k < width; k++)
                if(houghValues[k][j][0] > d) {
                    d = houghValues[k][j][0];
                }
        }

        for(int l = 0; l < height; l++) {
            for(int i = 0; i < width; i++) {
                houghPixels[i + l * width] = (byte) Math.round ((houghValues[i][l][0] * 255D) / d);
            }
        }
    }
    * 
    */