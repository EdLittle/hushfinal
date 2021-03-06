package hough;

import hough.LinearHT;
import hough.LinearHT.HoughLine;
import hough.Plugin_Hough_Linear_Ovlay;
import ij.IJ;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import image.edge.ImageEdge;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ed.escalante
 */
public class DetectQuadrilateral {
    ImagePlus imagePlus;
    ImageProcessor ip;
    List<HoughLine> lines;
    List<int[]> pairs;
    List<int[]> perpendicularPairs;
    boolean quad;
    
    public DetectQuadrilateral(){
    }
    public void processImagePlus(String image_name){
        ImagePlus pic = new ImagePlus(image_name);
        processImagePlus(pic);
    }
    
    public void processImagePlus(ImagePlus image_plus){
        ImagePlus pic = image_plus;
        new ImageConverter(pic).convertToGray16();
        ImageProcessor ip = pic.getProcessor();
        
        //set cropped image for detection (same size)
        //ip.setRoi(260, 172, 569, 390);
        //220, 25, 350, 250
        ip.setRoi(Roi.previousRoi);
        ImageProcessor ip2 = ip.crop();
        
        String title = pic.getTitle() + "cropped";
        ImagePlus imp2 = new ImagePlus(title, ip2);
        
        IJ.run(pic, "Enhance Contrast", "saturated=1.0");
        
        ImageProcessor edges = ImageEdge.areaEdge(ip2, (double) 5, (float).10, (float) 100, (float) 50);
        ip2 = ImageEdge.areaEdge(ip2, 5, (float)0.5, 100, 50);
        LinearHT linearHT = new LinearHT(ip2, 256, 180);
        lines = linearHT.getMaxLines(10, 125);
        System.out.println("Lines on get Max lines: " + lines.size());
        
        //show green lines
        Plugin_Hough_Linear_Ovlay ovlay = new Plugin_Hough_Linear_Ovlay();
        ovlay.setup(null, pic);
        ovlay.run(ip2);
        
        //show grayscale image
        imp2.show();
        
        
    }
    
    public void processLines(){

        double angle_threshold = 5.0;
        pairs = getParallelPairs(lines);
        quadriPresent(pairs);
    }
    
    public boolean isQuadPresent(){
        return quad;
    }
    
    public void quadriPresent(List<int[]> pairs){
        perpendicularPairs = new ArrayList();
        for(int i = 0; i < pairs.size() - 2; i++){
            for(int j = i + 1; j < pairs.size() - 1; j++){
                int[] pair1 = pairs.get(i);
                int[] pair2 = pairs.get(j);
                double right_angle = Math.PI/2;
                double angle_threshold = 0.05;
                
                HoughLine line1 = lines.get(pair1[0]);
                HoughLine line2 = lines.get(pair2[1]);
                
                double angle1 = line1.getAngle();
                double angle2 = line2.getAngle();
                
                double angle3 = Math.abs(angle1 - angle2);
                 
                ///System.out.println("QUADRI---right_angle: " + right_angle + " angle3: " + angle3);
                   
                if (Math.abs(right_angle - angle3) < 0.04){
                    //System.out.println("Perpendicular! Pairs " + pair1[0] + " " + pair1[1] + " and " + pair2[0] + " " +pair2[1]);
                    perpendicularPairs.add(new int[]{i, j});
                }
            }
        }
        
        if(perpendicularPairs.isEmpty())
            quad = false;
        else
            quad = true;
        
        if ((!quad) && (lines.size() >= 3)){
            checkForThreeSides();
        }
    }
    
    private void checkForThreeSides(){
        System.out.println("Checking for three sides!");
        
        System.out.println("Number of lines: " + this.lines.size());
        List<HoughLine> pair = new ArrayList();
        int i, j, k;
        int size = lines.size();
        double angle_threshold = 0.05;
        HoughLine line1, line2, line3;
        double angle1, angle2, angle3, angle4, angle5;
        double right_angle = Math.PI/2;
        
        outer_loop:
        for(i = 0; i < size; i++){
            for(j = 0; j < size; j++){
                if(i != j){
                    line1 = lines.get(i);
                    line2 = lines.get(j);
                    angle1 = line1.getAngle();
                    angle2 = line2.getAngle();
                    
                    angle3 = Math.abs(angle1 - angle2);
                    
                    if (angle3 < angle_threshold){
                        for(k = 0; k < size; k++ ){
                            if((i != j) && (j != k)){
                                line3 = lines.get(k);
                                angle4 = line3.getAngle();
                                
                                if(Math.abs(right_angle - angle3) < 0.04){
                                    quad = true;
                                    break outer_loop;
                                }
                            }
                        }
                    }
                }
                else{
                    quad = false;
                }
            }
        }
        
    }
    private static List<int[]> getParallelPairs(List<HoughLine> lines){
        double angle_threshold = 0.05;
        List<int[]> parallelPairs = new ArrayList<int[]>();
               
        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.size(); j++){
                if(i != j){
                    HoughLine line1 = lines.get(i);
                    HoughLine line2 = lines.get(j);
                    double angle1 = line1.getAngle();
                    double angle2 = line2.getAngle();
                    
                    double angle3 = Math.abs(angle1 - angle2);
                      
                //System.out.println("parallel---angle_threshold: " + angle_threshold + " angle3: " + angle3);
              
                    if (angle3 < angle_threshold){
                        int[] pair = {0, 0};
                        
                        if(i < j){
                            pair[0] = i;
                            pair[1] = j;
                        }
                        else{
                            pair[0] = j;
                            pair[1] = i;
                        }
                        
                        if(!pairExists(pair, parallelPairs)){
                            parallelPairs.add(pair);
                        }
                    }   
                }
            }
        }
        
        return parallelPairs;
    }
    
    private static boolean pairExists(int[] pair, List<int[]> parallelPairs){
        int i = pair[0];
        int j = pair[1];
        
        for(int[] parallelPair: parallelPairs){
            if((parallelPair[0] == i) && (parallelPair[1] == j)){
                return true;
            }
        }
        return false;
    }
}