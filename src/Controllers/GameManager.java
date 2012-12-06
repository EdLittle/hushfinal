/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import GUI.DecoyPlay;
import GUI.Hush;
import GUI.ImagePanel;
import ij.ImagePlus;
import java.awt.image.BufferedImage;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hough.CircleHT;
import hough.DetectQuadrilateral;
import ij.ImagePlus;
import ij.gui.ImageWindow;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Administrator
 */   

public class GameManager {
    private Hush hush;
    private DecoyPlay decoyPlay;
    private JLabel stopLight1;
    private JLabel stopLight2;
    private JLabel displayLabel;
    private ScheduledExecutorService executor;
    private String colors[] = {"black", "blue", "green", "orange", "yellow", "red", "white"};
    //private String colors[] = {"black", "black", "black", "black", "black", "white", "white"};
 //   private String shapes[] = {"circle", "square"};
    private String randomColors[] = {"", "", "", "", "" , "", ""};
    private String randomShapes[] = {"circle", "square"};
    private boolean running;
    private int round;
    private int level;
    //private boolean roundFinished;
    private Future gameTask;
    //private CameraCapture camera;
    private CameraFeed camera;
    private BandsAnalyzer bandsAnalyzer;
    private CircleHT circleDetector;
    private final int NUMBER_OF_TRIES = 15;
    
    public GameManager(){
        hush = Hush.hush;
        decoyPlay = hush.getDecoyPlay();
        stopLight1 = decoyPlay.getStopLight1();
        stopLight2 = decoyPlay.getStopLight2();
        displayLabel = decoyPlay.getJLabel1();
        executor = Executors.newScheduledThreadPool(15);
        running = false;
        round = 0;
        level = 1;
        bandsAnalyzer = new BandsAnalyzer();
        camera = decoyPlay.getCamera();
        setRandomColors();
    }
    
    public void startGame() throws InterruptedException{
        int i, j, k;
        running = true;
        
        //for level
        for(k = 0; k < 1; k++){
        
            round++;
            executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));
                    displayLabel.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/ready.png")));
                }
            }, 1, TimeUnit.SECONDS);
            
            executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
                    displayLabel.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/get set.png")));
                }
                
            }, 2, TimeUnit.SECONDS);
            
            executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));
                    displayLabel.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/go.png")));
                
                }
            
            }, 3, TimeUnit.SECONDS);
            
            
            //ASK FOR COLORS OR SHAPES
            if(level == 0){
                executor.schedule(new Runnable(){
                    public void run(){
                        displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/" + randomColors[round-1] + ".png")));
                        System.out.println("Asking for " + randomColors[round-1]);
                    }
                }, 4, TimeUnit.SECONDS);
            }
            else if(level == 1){
                executor.schedule(new Runnable(){
                    public void run(){displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/" + randomShapes[round-1] + ".png")));
                        System.out.println("Asking for " + randomShapes[round-1]);
                    }
                }, 4, TimeUnit.SECONDS);
            }
            
            if(level == 0){
                gameTask = executor.scheduleAtFixedRate(new Runnable(){
                    int tries = 1;
                    int random;
                    @Override
                    public void run(){
                        try {
                            
                            BufferedImage image = camera.grabImage();
                            String detectedColor = bandsAnalyzer.analyzeImage(image);
                            
                            System.out.println(detectedColor + " against hush's " + randomColors[round-1]);
                            boolean correct = detectedColor.equals(randomColors[round-1]);
                            
                            if(correct)
                                ScoreManager.addScore();
                            

                            if((correct) || (tries == NUMBER_OF_TRIES)){
                                getFuture().cancel(true);

                                if(round < 7){
                                    startGame();
                                }
                                else if (round == 7){
                                    System.out.println("Next level!");
                                    round = 0;
                                    level++;
                                    startGame();
                                }
                                //roundFinished = true;
                            }
                            else{
                                tries++;
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }, 5, 1, TimeUnit.SECONDS);
            }
            
            
            else if(level == 1){
            gameTask = executor.scheduleAtFixedRate(new Runnable(){
                    int tries = 1;
                    int random;
                    @Override
                    public void run(){
                        try {
                            random = (int) (Math.random() * 100) % 5;
                            BufferedImage image = camera.grabImage();
                            
                            System.out.println("Detecting for...." + randomShapes[round-1]);
                            
                            boolean correct = false;
                            //CIRCLE
                            if (round==1) {
                                //ImagePlus pic = new ImagePlus(null, Toolkit.getDefaultToolkit().createImage(image.getSource()));
                                ImagePlus pic = new ImagePlus(null, camera.grabImage());
                                //System.out.println("Height: " + pic.getHeight());
                                //System.out.println("Width: " + pic.getWidth());
                                pic.show();
                                circleDetector = new CircleHT();
                                circleDetector.processImage(pic);
                                correct = circleDetector.isDetected();
                            }
                            
                            //SQUARE
                            else if (round==2) {
                                DetectQuadrilateral detector = new DetectQuadrilateral();
                              //  detector.processImagePlus("quad6.jpg");
                                //detector.processImagePlus(new ImagePlus(null, Toolkit.getDefaultToolkit().createImage(image.getSource())));
                                ImagePlus pic = new ImagePlus(null, camera.grabImage());
                                pic.show();
                                detector.processLines();
                                correct = detector.isQuadPresent();
                            }
                            
                            
                            if(correct)
                                System.out.println("Correct!");


                            if((correct) || (tries == NUMBER_OF_TRIES)){
                                ScoreManager.addScore();
                                getFuture().cancel(true);

                                if(round < 2){                                
                                    startGame();
                                }
                                else if (round == 2){
                                    System.out.println("DONE!");
                                    round = 0;
                                    level = 0;
                                }
                            }
                            else{
                                tries++;
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }, 5, 1, TimeUnit.SECONDS);
            }
        }
        
    }
    
    private Future<?> getFuture(){
        return gameTask;
    }
    
    private void colorRound() throws InterruptedException{
        int i;
        int random;
        for(i = 0; i < 15; i++){
            random = (int)( Math.random() * 100 ) % 5;
            System.out.println("random " + random);
            if(random == 0){
                System.out.println("Correct!");
                //roundFinished = true;
                break;
            }
            Thread.sleep(1000);
            
        }
        
        //roundFinished = true;;
    }
    
    public boolean isRunning(){
        return running;
    }
    
    private void setRandomColors(){
        Vector randomPermutation = getRandomPermutation();
        Integer[] order = {10,10,10,10,10,10,10};
        
        order = (Integer[])randomPermutation.toArray(new Integer[0]);
        for (int i = 0; i < 7; i++){
            randomColors[i] = colors[(int)order[i]];            
            //randomColors[i] = colors[randomPermutation.elementAt(i)];
            //System.out.println(randomColors[i]);
        }
    }
    
    private Vector getRandomPermutation(){
        Vector randomPermutation = new Vector();
        int i = 0;
        int rand;
        
        for(i = 0; i < 7; i++){
            do{
                rand = (int)(Math.random()*100) % 7;
            }while(randomPermutation.contains(rand));
            randomPermutation.add((int)rand);
            //System.out.println("Random Number " + rand);
        }
        
        return randomPermutation;
    }
}
