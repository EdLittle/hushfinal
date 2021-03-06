/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import GUI.DecoyPlay;
import GUI.Hush;
import GUI.ImagePanel;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class GameplayManager implements Runnable{
    static int difficultyLevel;
    String colors[] = {"black.png", "blue.png", "green.png", "orange.png", "yellow.png", "red.png", "white.png"};    
    String randomColors[] = {"", "", "", "", "" , "", ""};
    JLabel stopLight1;
    JLabel stopLight2;
    JLabel displayLabel;
    DecoyPlay decoyPlay;
    ImagePanel imagePanel;
    Hush hush;
    JMFCapture camera;
    ScheduledExecutorService executor;
    ScheduledFuture scheduledFuture;
    GameTask guiTask;
    GameTask playTask1, playTask2;
    boolean running;
    int round;
    int level;
    
    public GameplayManager(int difficulty){
        hush = Hush.getHush();
        decoyPlay = hush.getDecoyPlay();
        stopLight1 = decoyPlay.getStopLight1();
        stopLight2 = decoyPlay.getStopLight2();
        displayLabel = decoyPlay.getJLabel1();
        
        //imagePanel = decoyPlay.getImagePanel1();
        
        //camera = new JMFCapture();
        difficultyLevel = difficulty;
        executor = Executors.newScheduledThreadPool(15);
        setRandomColors();
        guiTask = new GameTask("Red", randomColors);
        playTask1 = new GameTask("Color Level");
        playTask2 = new GameTask("Shape Level");
        round = 0;
        level = 0;
    }

    public void startGame() throws InterruptedException{
        running = true;
        int round;
        
        for(int i = 0; i < 7; i++){         
            long startTime = System.currentTimeMillis();
            System.out.println("TIME IS" + startTime);
        }
        running = false;
    }
    
    
    private void singleRound() throws InterruptedException{
        
        executor.schedule(guiTask, 1, TimeUnit.SECONDS);
        //guiTask.setTaskType("Yellow");
        executor.schedule(guiTask, 2, TimeUnit.SECONDS);
        //guiTask.setTaskType("Green");
        executor.schedule(guiTask, 3, TimeUnit.SECONDS);
        executor.schedule(guiTask, 4, TimeUnit.SECONDS);
        executor.schedule(playTask1, 4, TimeUnit.SECONDS);
        
    }
    
    private void setRandomColors(){
        Vector randomPermutation = getRandomPermutation();
        Integer[] order = {10,10,10,10,10,10,10};
        
        order = (Integer[])randomPermutation.toArray(new Integer[0]);
        for (int i = 0; i < 7; i++){
            randomColors[i] = colors[(int)order[i]];
        }
    }
    
    public boolean isRunning(){
        return running;
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
    
    @Override
    public void run() {
        
    }
    
    private void colorLevel(){
        
    }
    
    private void setReady(){
        displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/ready.png")));
        stopLight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));
        stopLight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-red.png")));

    }
    
    private void setGetSet(){
        displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/get set.png")));
        stopLight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
        stopLight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-orange.png")));
            
    }
    
    private void setGo(){
        displayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/go.png")));
        stopLight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));
        stopLight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight-green.png")));

    }
}
