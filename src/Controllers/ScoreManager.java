
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
    
    
    public void ScoreManager(){
    }
    //private static PlayPanel playPanel = Hush.hush.getPlayPanel();
    //private static ImageIcon coloredBadge = new ImageIcon("/med/badge-colored.png");
    
    // add string addScore(String item, int level)
    //public static void addScore() throws IOException{
    public static void addScore(String item, int level) throws IOException{
        
        giveStar(score);
        
         if (level==0) {
            System.out.println("Passing " + item + " on number " + colorScore);
            rightColors.add(item);
            colorScore++;
            
         }
         else {
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
        return score;
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
    
    public static String getCategory(){
       String category = "";
       if (score>=8){
           category = "Gold";
       }
       else if ((score<8)||(score>=6)){
           category = "Silver";
       }
       else if((score<6)||(score>=4)){
           category = "Bronze";
       }
       else {
           category = "Wood";
       }
       return category;
    }

    public static void giveStar(int slot) throws IOException{
        //JLabel label = playPanel.getJLabel(slot);
        starSlots[slot].setIcon(new ImageIcon("src/med/badge-colored.png"));
        //label.setIcon(new ImageIcon("src/med/badge-colored.png"));
    }
    
    public static void revokeStars(){
        int i = 0;
        netScore = netScore + score;
        score = 0;
        for(i = 0; i < 7; i++){
            starSlots[i].setIcon(new ImageIcon("src/med/badge.png"));
        }
    }
    
    public static void resetScore(){
        score = 0;
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
    
    public static void resetAll(){
        score = 0;
        colorScore = 0;
        shapeScore = 0;
        netScore = 0;
        rightColors.clear();
        rightShapes.clear();
    }
} 
