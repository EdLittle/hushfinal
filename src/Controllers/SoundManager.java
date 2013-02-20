/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import GUI.Hush;
import GUI.ControlPanel;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author FREAK
 */

public class SoundManager {
    public Hush hush;
    public ControlPanel controlPanel;
    
    public InputStream in;
    public AudioStream as;
    
    public AudioInputStream correctAns;
    public AudioInputStream clickOff;
    public AudioInputStream bgmusic;    
    
    public Clip clickOffClip;
    public Clip correctAnsClip;
    public Clip bgmusicClip;
    
    public SoundManager() throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException{
         clickOff = AudioSystem.getAudioInputStream(new File("sounds/click off.wav").getAbsoluteFile());
         correctAns = AudioSystem.getAudioInputStream(new File("sounds/correctAns.wav").getAbsoluteFile());
         bgmusic = AudioSystem.getAudioInputStream(new File("sounds/bgmusic.wav").getAbsoluteFile());
        
        correctAnsClip = AudioSystem.getClip();
        correctAnsClip.open(correctAns);
        
        clickOffClip = AudioSystem.getClip();
        clickOffClip.open(clickOff);
        
        bgmusicClip = AudioSystem.getClip();
        bgmusicClip.open(bgmusic);
    }
    
    public void playCorrectAns(){
        correctAnsClip.start();
        correctAnsClip.setFramePosition(0);
    }
    
    public void playClickOff(){
        clickOffClip.start();
        clickOffClip.setFramePosition(0);
    } 
    
    public void playBgmusic(){
        bgmusicClip.start();
        bgmusicClip.setFramePosition(0);
        bgmusicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
       
    public void stopBgmusic(){
       bgmusicClip.stop();
    }
    
    public boolean isActiveBgmusic(){
        
       /* 
        hush = Hush.getHush();
        *System.out.println("-------------isActiveBgmusic?" + bgmusicClip.isActive() );     
          System.out.println("-------------Active sounds: " + Hush.soundManager.isActiveBgmusic());
         if (bgmusicClip.isActive()){
              System.out.println("-------------ACTIVE!");
              
         else{   
            System.out.println("-------------NOT ACTIVE!");
            sounds.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/med/MD-volume-0.png"))); // NOI18N
         } */
        return bgmusicClip.isActive();
    }
    
}
