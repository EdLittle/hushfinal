/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hough;

/**
 *
 * @author ed.escalante
 */
/**
 * This sample code is made available as part of the book "Digital Image
 * Processing - An Algorithmic Introduction using Java" by Wilhelm Burger
 * and Mark J. Burge, Copyright (C) 2005-2008 Springer-Verlag Berlin, 
 * Heidelberg, New York.
 * Note that this code comes with absolutely no warranty of any kind.
 * See http://www.imagingbook.com for details and licensing conditions.
 * 
 * Date: 2010/01/27
 */

import hough.LinearHT;
import hough.LinearHT.HoughLine;
import ij.IJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.gui.ImageCanvas;
import ij.plugin.filter.PlugInFilter;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.util.List;

/** 
 * This plugin implements a simple Hough Transform for straight lines.
 * It expects an 8-bit binary (edge) image, with background = 0 and
 * edge pixels > 0.
 * Draws the resulting lines as a non-destructive vector overlay.
 * Last update: 2010-01-27
*/

public class Plugin_Hough_Linear_Ovlay implements PlugInFilter {
	
	static int N_ANGLE = 256;			// resolution of angle
	static int N_RADIUS = 256;			// resolution of radius
	static int MAX_LINES = 10;			// max. number of lines to be detected
	static int MIN_PNTSONLINE = 150;	// min. number of points on each line
	static boolean SHOW_ACCUMULATOR = false;
	static boolean SHOW_LOCALMAXIMA = false;
	static boolean LIST_LINES = false;
	static boolean DRAW_LINES = true;

	ImagePlus imp = null;		// input image

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_8G + DOES_16 + NO_CHANGES;
	}
	
	boolean askForParameters() {
                N_ANGLE = 256;			// resolution of angle
                N_RADIUS = 256;			// resolution of radius
                MAX_LINES = 10;			// max. number of lines to be detected
                MIN_PNTSONLINE = 150;
                
                SHOW_ACCUMULATOR = false;
                SHOW_LOCALMAXIMA = false;
                LIST_LINES = false;
                DRAW_LINES = true;
		return true;
	}

	public void run(ImageProcessor ip) {
		// ip is supposed to be an edge image with background = 0
		
		//if (askForParameters() == false) return;

		//compute the Hough Transform
		LinearHT ht = new LinearHT(ip, N_ANGLE, N_RADIUS);
		List<HoughLine> lines = ht.getMaxLines(MAX_LINES, MIN_PNTSONLINE);

		// show the Hough accumulator
		if (SHOW_ACCUMULATOR) {
			FloatProcessor accIp = ht.getAccumulatorImage();
			accIp.flipHorizontal(); //flip because angle runs reverse (negative y)
			ImagePlus accImg = new ImagePlus("HT of " + imp.getTitle(), accIp);
			accImg.show();
		}
		
		// show the local maxima of the Hough accumulator
		if (SHOW_LOCALMAXIMA) {
			FloatProcessor maxIp = ht.getLocalMaxImage();
			maxIp.flipHorizontal(); //flip because angle runs reverse (negative y)
			ImagePlus maxIm = new ImagePlus("Local maxima of " + imp.getTitle(), maxIp);
			maxIm.show();
		}
		
		// list the line parameters on the console
		if (LIST_LINES) {
			printLines(lines);
		}
		
		// plot the lines in a new image with vector overlay
		if (DRAW_LINES) {
			ImageProcessor resultIp = ip.duplicate();
			ImagePlus resultIm = new ImagePlus("Lines of " + imp.getTitle(), resultIp);
			resultIm.show(); // image must be displayed to have a canvas != null
			drawLines(lines, resultIm);
			resultIm.updateAndDraw();
                        printLines(lines);
		}
	}

	void printLines(List<HoughLine> lines) {
		int i = 0;
		for (HoughLine hl : lines){
			i = i+1;
			IJ.log(i - 1 + ": " + hl.toString());
		}
	}
	
	void drawLines(List<HoughLine> lines, ImagePlus resultIm) {
		ImageCanvas ic = resultIm.getCanvas();
		if (ic == null) return;
		GeneralPath path = new GeneralPath();
		for (HoughLine hl : lines){
			path.append(hl.makeLine2D(), false);
		}
                
		ic.setDisplayList(path, Color.GREEN, new BasicStroke(3));
	}

}