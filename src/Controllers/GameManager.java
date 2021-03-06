/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import GUI.*;
import ij.ImagePlus;
import ij.IJ;

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
import ij.ImageStack;
import ij.gui.ImageWindow;
import ij.plugin.ChannelSplitter;
import ij.plugin.RGBStackMerge;
import ij.plugin.filter.RGBStackSplitter;
import ij.process.ColorProcessor;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Administrator
 */   

public class GameManager {
    private Hush hush;
    private DecoyPlay decoyPlay;
    private PlayPanel playPanel;
    private ScoreSummary scoreSummary;
    private JLabel stopLight1;
    private JLabel stopLight2;
    private JLabel displayLabel;
    private ScheduledExecutorService executor;
    private String colors[] = {"black", "blue", "green", "orange", "yellow", "red", "white"};
    private String randomColors[] = {"", "", "", "", "" , "", ""};
    private String randomShapes[] = {"circle", "square"};
    private boolean running;
    private int round;
    private int level;
    private boolean done;    
    private int livesDeduc;
    private boolean correct;
    private Vector colorResult;
    private Vector shapeResult;
    private Future gameTask;
    private SoundManager soundManager;
    private ScoreManager scoreManager;
    private CameraFeed camera;
    private BandsAnalyzer bandsAnalyzer;
    private CircleHT circleDetector;
    private final int NUMBER_OF_TRIES = 15;
    private int white_balance_config;
    private int maxRed;
    private int maxGreen;
    private int maxBlue;
    
    public GameManager() throws FileNotFoundException{
        hush = Hush.hush;
        decoyPlay = hush.getDecoyPlay();
        playPanel = hush.getPlayPanel();
        scoreSummary = hush.getScoreSummary();
        stopLight1 = decoyPlay.getStopLight1();
        stopLight2 = decoyPlay.getStopLight2();
        displayLabel = decoyPlay.getJLabel1();        
        running = false;
        round = 0;
        level = 0;
        done = false;
        livesDeduc = 0;
        correct = false;
        bandsAnalyzer = new BandsAnalyzer();
        scoreManager = new ScoreManager();       
        camera = decoyPlay.getCamera();
        white_balance_config = hush.getWBConfig();
        setRandomColors();
        setWhiteBalanceRGBs();
        try {
            soundManager = new SoundManager();
        } catch (IOException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startGame() throws InterruptedException{
        int i, j, k;
        running = true;
        
        //for level        
        executor = Executors.newScheduledThreadPool(15);
        for(k = 0; k < 1; k++){
            if ((done==true)&&(correct==false)){
                livesDeduc++;
                
                if(livesDeduc < 3){
                    playPanel.mistake(livesDeduc);
                }
                System.out.println("Lives deducted: " + livesDeduc);
                if (livesDeduc==10){
                    try {      
                        System.out.println("G A M E O V E R");
                        gameOver();
                    } catch (Exception ex) {
                        Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            done = false;
            correct = false;
            round++;
         
             
                       System.out.println("Round #: " + round);
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
            
            
             executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/5.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/5.png")));                
                }
            
            }, 10, TimeUnit.SECONDS);
             
             executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/4.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/4.png")));                
                }
            
            }, 11, TimeUnit.SECONDS);
                         
             executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));                
                }
            
            }, 13, TimeUnit.SECONDS);
            
            executor.schedule(new Runnable(){

                @Override
                public void run() {
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
                }
            
            }, 14, TimeUnit.SECONDS);
            executor.schedule(new Runnable(){
                
                @Override
                public void run() {                      
                    done = true;
                    stopLight1.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));
                    stopLight2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));
                    done = true;
                }
            
            }, 15, TimeUnit.SECONDS);
            
            //ASK FOR COLORS OR SHAPES
            if(level == 0){   
            try {
              
                    Hush.soundManager.playItem(randomColors[round-1]);
           } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                executor.schedule(new Runnable(){
                    public void run(){
                        displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/" + randomColors[round-1] + ".png")));
                        System.out.println("Asking for " + randomColors[round-1]);
                    }
                }, 4, TimeUnit.SECONDS);
            }
            else if(level == 1){
                 try {
              
                    Hush.soundManager.playItem(randomShapes[round-1]);
           } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
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
                            
                            //Insert stuff here
                            image = whiteBalance(image);
                            
                            String detectedColor = bandsAnalyzer.analyzeImage(image);
                            
                            System.out.println(detectedColor + " against hush's " + randomColors[round-1]);
                            correct = detectedColor.equals(randomColors[round-1]);
                            
                            if(correct) {                                
                                getFuture().cancel(true);
                                //if (Hush.soundManager.isActiveBgmusic()){
                                    soundManager.playCorrectAns();
                                //}
                                scoreManager.addScore(detectedColor, level);
                            }

                            if((correct) || (tries == NUMBER_OF_TRIES)){
                                getFuture().cancel(true);
                                if(round < 7){
                                    startGame();
                                } 
                                else if (round == 7){
                                    System.out.println("Next level!");   
                                    
                                    colorResult = scoreManager.getRightColors();
                                    Enumeration e = colorResult.elements();
                                    
                                    //enumerate correct answers; give score
                                    if (colorResult.size()==0){
                                        System.out.print("You can do better next time!");
                                    }
                                    else {                                        
                                        System.out.println("Right color/s: ");
                                        while(e.hasMoreElements()){
                                            System.out.println(" " + e.nextElement());
                                        }
                                    }                                   
                                    scoreManager.resetBadges();
                                    System.out.println("Total Color Score: " + colorResult.size());
                                    round = 0;
                                    level++;
                                    done = false;
                                    displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/nextlevel.png")));
                                    startGame();
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
            
            
            else if(level == 1){
            gameTask = executor.scheduleAtFixedRate(new Runnable(){
                    int tries = 1;
                    int random;
                    
                    @Override
                    public void run(){
                        try {
                            random = (int) (Math.random() * 100) % 5;
                            BufferedImage image = camera.grabImage();
                            
                            if(tries < NUMBER_OF_TRIES){
                                done = false;
                            }
                            System.out.println("Detecting for...." + randomShapes[round-1] + " at " + tries);
                            
                            correct = false;   
                            
                            //CIRCLE
                            //pic.show();
                            
                            System.out.println("round: " + round + ", done: " + done);
                            if ((round == 1) && (done == false)) {
                                
                                ImagePlus pic = new ImagePlus(null, camera.grabImage());                                
                                circleDetector = new CircleHT();
                                circleDetector.processImage(pic);
                                correct = circleDetector.isDetected();
                                System.out.println("Circling");
                                done = false;

                            }
                            
                            //SQUARE
                            //pic.show();
                            
                            else if ((round == 2) && (done == false)) {

                                DetectQuadrilateral detector = new DetectQuadrilateral();
                                ImagePlus pic = new ImagePlus(null, camera.grabImage());
                                detector.processImagePlus(pic);                              
                                detector.processLines();
                                correct = detector.isQuadPresent();
                                
                            }
                            
                            if(correct) {
                                System.out.println("Correct " + randomShapes[round-1]);                                               
                                getFuture().cancel(true);
                                
                                //if (Hush.soundManager.isActiveBgmusic()){
                                    soundManager.playCorrectAns();
                                //}
                                scoreManager.addScore(randomShapes[round-1], level);
                            }

                            if((correct) || (tries == NUMBER_OF_TRIES)){
                                getFuture().cancel(true);

                                if(round < 2){                                
                                    startGame();
                                    done = false;
                                }
                                else if (round == 2){
                                    System.out.println("DONE!");
                                    
                                    shapeResult = scoreManager.getRightShapes();
                                    Enumeration e = shapeResult.elements();
                                    
                                    //enumerate correct answers; give score
                                    if (shapeResult.size()==0){
                                        System.out.print("You can do better next time!");
                                    }
                                    else {                                        
                                        System.out.println("Right shape/s: ");
                                        while(e.hasMoreElements()){
                                            System.out.println(" " + e.nextElement());
                                        }
                                    }                                   
                                    System.out.println("Total Shape Score: " + shapeResult.size());
                                    done = true;
                                    gameOver();
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
    
    private void gameOver() throws Exception{
        getFuture().cancel(true);                              
        CardLayout cardLayout = (CardLayout) hush.getCardLayout();
        cardLayout.show(hush.getContentPane(), "scoreCard");
        round = 8;
        level = 2;
                                    
        hush.getScoreSummary().updateControlPanel();
        scoreSummary.setMessage();
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
                break;
            }
            Thread.sleep(1000);
            
        }
        
        //roundFinished = true;;
    }
    
    public boolean isRunning(){
        return running;
    }
    
    public void restartGame(){
        //shut down game
        if (running)
            executor.shutdownNow();
        //score back to zero
        //right vectors should empty
        ScoreManager.reset();
        System.out.println("New game!!!!!");
        
        //level goes back to zero
        level = 0;         
        JLabel jLabel1 = Hush.getHush().getDecoyPlay().getJLabel1();
        JLabel stopLight1 = Hush.getHush().getDecoyPlay().getStopLight1();
        JLabel stopLight2 = Hush.getHush().getDecoyPlay().getStopLight2();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/start.png"))); // NOI18N
        stopLight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight.png"))); // NOI18N
        stopLight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight.png"))); // NOI18
    }
    
    private void setRandomColors(){
        Vector randomPermutation = getRandomPermutation();
        Integer[] order = {10,10,10,10,10,10,10};
        
        order = (Integer[])randomPermutation.toArray(new Integer[0]);
        for (int i = 0; i < 7; i++){
            randomColors[i] = colors[(int)order[i]];       
        }
    }
    
    private BufferedImage whiteBalance(BufferedImage pre_processed){
        BufferedImage processed;
        //maxRed = 140;
        //maxGreen = 140;
        //maxBlue = 140;
        
        ImagePlus ip = new ImagePlus(null, pre_processed);
        //IJ.run(null);
        //IJ.run(ip, "Color Balance...", null);
        //IJ.run(ip,"Make Composite", null);
        IJ.run(ip, "Split Channels", null);
        //ColorProcessor cp = new ColorProcessor(ip.getImage());
        ImageStack redStack = ChannelSplitter.getChannel(ip, 1);
        ImagePlus redIP = new ImagePlus(null, redStack);
        IJ.setMinAndMax(redIP, 0, maxRed);
        redStack = redIP.getStack();
        
        ImageStack greenStack = ChannelSplitter.getChannel(ip, 2);
        ImagePlus greenIP = new ImagePlus(null, greenStack);
        IJ.setMinAndMax(greenIP, 0, maxGreen);
        greenStack = greenIP.getStack();
        
        ImageStack blueStack = ChannelSplitter.getChannel(ip, 3);
        ImagePlus blueIP = new ImagePlus(null, blueStack);
        IJ.setMinAndMax(blueIP, 0, maxBlue);
        blueStack = blueIP.getStack();
        
        ImageStack newImageStack = RGBStackMerge.mergeStacks(redStack, greenStack, blueStack, true);
        //RGBStackSplitter splitter2;
        ImagePlus processed_image = new ImagePlus(null, newImageStack);
        /*
         1. split channels
         * 2. apply min and max according to channel
         * 3. merge
         */
        //IJ.Stack.setChannel(1);
        //IJ.run(ip, "run(\"Make Composite\");Stack.setChannel(1);setMinAndMax(0," + maxRed + ");call(\"ij.ImagePlus.setDefault16bitRange\", 0);Stack.setChannel(2);setMinAndMax(0, " + maxGreen +");call(\"ij.ImagePlus.setDefault16bitRange\", 0);Stack.setChannel(3);setMinAndMax(0," +  maxBlue + ");call(\"ij.ImagePlus.setDefault16bitRange\", 0);", null);
        //IJ.run(ip, "Stack.setChannel(1)", null);
        //IJ.setMinAndMax(ip, 0, maxRed);
        //IJ.setMinAndMax(ip, 0, 140);
        //IJ.
        //IJ.setMinAndMax(0, maxRed, 1);
        //ip.show("Original");
        //processed_image.show("Filtered");
        
        //System.out.println("Warg: " + maxRed + ", " + maxGreen + ", " + maxBlue);
        //IJ.runMacro("run(\"Make Composite\");Stack.setChannel(1);setMinAndMax(0," + maxRed + ");call(\"ij.ImagePlus.setDefault16bitRange\", 0);Stack.setChannel(2);setMinAndMax(0, " + maxGreen +");call(\"ij.ImagePlus.setDefault16bitRange\", 0);Stack.setChannel(3);setMinAndMax(0," +  maxBlue + ");call(\"ij.ImagePlus.setDefault16bitRange\", 0);");
        
        //ImageStack stack = ip.getStack();
        //IJ.
        //stack.s
        //stack.setChannel(1);
        processed = processed_image.getBufferedImage();
        return processed;
    }
    
    private void setWhiteBalanceRGBs(){
        switch(white_balance_config){
            case 1:
                maxRed = 255;
                maxGreen = 136;
                maxBlue = 18;
                break;
            //case 2: //Tungsten
                //maxRed = ;
                //maxGreen = ;
                //maxBlue = ;
                //break;
            case 3: //sunrise/sunset
                maxRed = 255;
                maxGreen = 209;
                maxBlue = 163;
                break;
            case 4: //Flourescent
                maxRed = 255;
                maxGreen = 228;
                maxBlue = 206;
                break;
            //case 5: //Flash
                //maxRed = ;
                //maxGreen = ;
                //maxBlue = ;
                //break;
            case 6: //Daylight
                maxRed = 255;
                maxGreen = 249;
                maxBlue = 246;
                break;
            //case 7: //Cloudy
                //maxRed = ;
                //maxGreen = ;
                //maxBlue = ;
                //break;
            case 8: //Overcast
                maxRed = 204;
                maxGreen = 219;
                maxBlue = 255;
                break;
            default:
                maxRed = 255;
                maxGreen = 255;
                maxBlue = 255;
                break;
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
        }
        
        return randomPermutation;
    }
    
}
