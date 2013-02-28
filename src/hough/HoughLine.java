/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hough;

//package ac.essex.ooechs.imaging.commons.edge.hough; 
 
import java.awt.FlowLayout;
import java.awt.image.BufferedImage; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** 
 * Represents a linear line as detected by the hough transform. 
 * This line is represented by an angle theta and a radius from the centre. 
 * 
 * @author Olly Oechsle, University of Essex, Date: 13-Mar-2008 
 * @version 1.0 
 */ 
public class HoughLine { 
 
    protected double theta; 
    protected double r; 
    private BufferedImage image;
 
    /** 
     * Initialises the hough line 
     */ 
    public HoughLine(double theta, double r) { 
        this.theta = theta; 
        this.r = r; 
    } 
 
    /** 
     * Draws the line on the image of your choice with the RGB colour of your choice. 
     */ 
    public void draw(BufferedImage bi, int color) { 
        this.image = bi;
        int height = image.getHeight(); 
        int width = image.getWidth(); 
 
        // During processing h_h is doubled so that -ve r values 
        int houghHeight = (int) (Math.sqrt(2) * Math.max(height, width)) / 2; 
 
        // Find edge points and vote in array 
        float centerX = width / 2; 
        float centerY = height / 2; 
 
        // Draw edges in output array 
        double tsin = Math.sin(theta); 
        double tcos = Math.cos(theta); 
 
        if (theta < Math.PI * 0.25 || theta > Math.PI * 0.75) { 
            // Draw vertical-ish lines 
            for (int y = 0; y < height; y++) { 
                int x = (int) ((((r - houghHeight) - ((y - centerY) * tsin)) / tcos) + centerX); 
                if (x < width && x >= 0) { 
                    image.setRGB(x, y, color); 
                } 
            } 
        } else { 
            // Draw horizontal-sh lines 
            for (int x = 0; x < width; x++) { 
                int y = (int) ((((r - houghHeight) - ((x - centerX) * tcos)) / tsin) + centerY); 
                if (y < height && y >= 0) { 
                    image.setRGB(x, y, color); 
                } 
            } 
        } 
    } 
    
    public void show(){
        
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
} 