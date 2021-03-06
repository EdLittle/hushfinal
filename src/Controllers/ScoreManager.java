
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import GUI.Hush;
import GUI.PlayPanel;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author FREAK
 */
public class ScoreManager {
    private static int score = 0;
    private static int colorScore = 0;
    private static int shapeScore = 0;
    private static int netScore = 0;
    private static JLabel[] starSlots;
    private static String username;
    private static Vector rightColors = new Vector();
    private static Vector rightShapes = new Vector();
        
    //private static PlayPanel playPanel = Hush.hush.getPlayPanel();
    //private static ImageIcon coloredBadge = new ImageIcon("/med/badge-colored.png");
    
    // add string addScore(String item, int level)
    //public static void addScore() throws IOException{
    
    public ScoreManager(){
        
    }
    public static void addScore(String item, int level) throws IOException{
        
        giveStar(score);
        
         if (level==0) {
            System.out.println("Passing " + item + " on number " + colorScore);
            rightColors.add(item);
            colorScore++;
            
         }
         else {
            System.out.println("Passing " + item + " on number " + shapeScore);
            rightShapes.add(item);
            shapeScore++;
         }
         score++;
        System.out.println("Score is " + score);
    }
    
    /*
    //call after everything before displaying scorePanel
    public static int totalScore(){
        return netScore;
    */
    
    public static void saveScore(){
    //call databaseManager
    }

    public static int getScore(){
        return (colorScore + shapeScore);
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static int getColorScore(){
        return colorScore;
    }
    
    public static int getShapeScore(){
        return shapeScore;
    }
   
    public static Vector getRightColors(){
        return rightColors;
    }
    
    public static Vector getRightShapes(){
       return rightShapes;
    }
    
    public static int getCategory(int currScore){
     //  score = currScore;
       int category = 3;
       
       //Gold = categ 0
       if (currScore>=8){
           category = 0;
       }
       
       //Silver = categ 1
       else if ((currScore<8)&&(currScore>=6)){
           category = 1;
       }
       
       //Bronze = categ 2
       else if((currScore<6)&&(currScore>=4)){
           category = 2;
       }
       
       //Wood = categ 3
       else {
           category = 3;
       }
       return category;
    }
    
    public static void resetBadges(){        
        score = 0;
        starSlots[0].setIcon(new ImageIcon("src/med/badge.png"));
        starSlots[1].setIcon(new ImageIcon("src/med/badge.png"));
        for(int x=2; x<7; x++){            
         starSlots[x].setIcon(null);
        }
    }

    public static void giveStar(int slot) throws IOException{
        starSlots[slot].setIcon(new ImageIcon("src/med/badge-colored.png"));
    }
    
    public static void revokeStars(){
        int i = 0;
        netScore = netScore + score;
        score = 0;
        for(i = 0; i < 7; i++){
            starSlots[i].setIcon(new ImageIcon("src/med/badge.png"));
        }
    }
    
   public static void setSlots(JLabel jlabel1, JLabel jlabel2, JLabel jlabel3, JLabel jlabel4, JLabel jlabel5, JLabel jlabel6, JLabel jlabel7){
        starSlots = new JLabel[]{jlabel1, jlabel2, jlabel3, jlabel4, jlabel5, jlabel6, jlabel7};
    }
        
    /* clear slots after first round into only two stars/medals
    public static void clearSlots(){
    * starSlots
    * }
    */
    
    public static void setUsername(String name){
        username = name;
        System.out.println("User is " + username);
    }
    
    public static void reset(){
        score = 0;
        colorScore = 0;
        shapeScore = 0;
        netScore = 0;
        rightColors.clear();
        rightShapes.clear();
        revokeStars();
    }
} 
