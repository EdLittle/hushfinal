package Controllers;

import hough.DetectQuadrilateral;
import hough.LinearHT;
import hough.LinearHT.HoughLine;
import hough.Plugin_Hough_Linear_Ovlay;
import ij.IJ;
import ij.ImagePlus;
import ij.gui.ImageWindow;
import ij.plugin.frame.ContrastAdjuster;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ed.escalante
 */
public class Main {
    
    public static void main(String[] ags) throws InterruptedException{
        DetectQuadrilateral detector = new DetectQuadrilateral();
        boolean quad;
        
        for(int i = 7; i < 16; i++){
            detector =  new DetectQuadrilateral();
            detector.processImagePlus("med/quad" + i + ".jpg");
            detector.processLines();
            quad = detector.isQuadPresent();
            System.out.print(i + ": ");
            
            if (quad){
                System.out.println("There is a square/rectangle\n");
            }else{
                System.out.println("No\n");
            }
            Thread.sleep(1000);
        }
    }
}
