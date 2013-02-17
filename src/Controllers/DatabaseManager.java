/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.ScoreManager;
import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FREAK
 */
public class DatabaseManager {
    static File usersFile;
    static File scoresFile;
    

    static ArrayList<String> usersList = new ArrayList<String>();
    static ArrayList<Integer> scoresList = new ArrayList<Integer>();
    static String[] usernames = null;
    static String[] scoresString = null;
    static Hashtable<String, Integer> scoresTable = new Hashtable<String, Integer>();
    static Vector gold_scorers;
    static Vector silver_scorers;
    static Vector bronze_scorers;
    static Vector wood_scorers;
    
    public DatabaseManager() throws Exception{
        usersFile = new File("data/usernames.txt");
        scoresFile = new File("data/scores.txt");
        gold_scorers = new Vector();
        silver_scorers = new Vector();
        bronze_scorers = new Vector();
        wood_scorers = new Vector();
        
        if((!usersFile.exists())&&(!scoresFile.exists())){
            try {
                usersFile.createNewFile();
                scoresFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static BufferedReader readFile(String filename) throws Exception{
        FileInputStream fiStream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fiStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        return br;
    }
    
    public static void updateUsername(String usernameInput) throws Exception{
        if (!usersList.contains(usernameInput)){
    //        System.out.println("New player: " + usernameInput + " at " + usernames[usernames.length]);
            System.out.println("New player: " + usernameInput + " at " + (usersList.size()));
            System.out.println("New score: 0 at " + (scoresList.size()));
            usersList.add(usernameInput);
            scoresList.add(0);
             System.out.println("useres size: " + usersList.size() + " scoresList size: " + scoresList.size());
           
            BufferedWriter bw = new BufferedWriter(new FileWriter(usersFile, true));

                bw.write(usersList.get(usersList.size()-1));
                bw.newLine();
                bw.flush();
                bw.close();
            storeScores(usernameInput, 0);
        }
    }
    
    public static void categorizeScores(){
        
        for (int x=0; x < scoresList.size(); x++){
           if (ScoreManager.getCategory(scoresList.get(x)) == 0){  
                System.out.println("Gold: " + usersList.get(x));
                gold_scorers.add(usersList.get(x));        
           }
           else if (ScoreManager.getCategory(scoresList.get(x)) == 1){
                System.out.println("sILVER: " + usersList.get(x));
                silver_scorers.add(usersList.get(x));               
           }
           else if (ScoreManager.getCategory(scoresList.get(x)) == 2){
                System.out.println("BRO: " + usersList.get(x));
                bronze_scorers.add(usersList.get(x));               
           }
           else {    
                System.out.println("WOOD: " + usersList.get(x));
                wood_scorers.add(usersList.get(x));               
           }
        }
    }
    
    public static ArrayList getNames() throws Exception{
        BufferedReader br = readFile("data/usernames.txt");
        String line = "";
        String names = "";
        while((line = br.readLine()) != null){            
            names = names + line + "\n";            
        }
        usernames = names.split("\n");
                
        System.out.println("get names: " + usernames.length) ;
        //convert usernames to ArrayList????
        for (int x=0; x<usernames.length; x++){  
            usersList.add(x, usernames[x]);
          //  scoresTable.put(usernames[x], scoresList[x]);
        }
        return usersList;
    }
    
    public static ArrayList getScores() throws Exception{
        BufferedReader br = readFile("data/scores.txt");
        String line = "";
        String scores = "";
        
        while((line = br.readLine()) != null){            
            scores = scores + line + "\n";            
        }
        scoresString = scores.split("\n");
                 
        System.out.println("get Scores: " + scoresString.length) ;
        
        //convert read scores(in char) to list of integers and copy it to scoresTable
        for (int x=0; x<scoresString.length; x++){  
       // System.out.println("get Scores---: " + scoresString[x]) ;
            scoresList.add(x, Integer.parseInt(scoresString[x]));
           
        }
        return scoresList;
    }
    
    public static ArrayList getUsersList() throws Exception{
        
        System.out.println("get list: " + usersList.size() + " get unames: " + usernames.length) ;
        System.out.println("usersList: " + usersList.toString()) ;
        System.out.println("unames: " + usernames.toString()) ;
      /*  
        if(usernames.length!=usersList.size()){
            for (int x=usersList.size(); x<usernames.length; x++){
                System.out.println("Add " + usernames[x] + " to " + usersList.size());
                usersList.add(usernames[x]);
            }
        }
        * */
        return usersList;
    }
    public static ArrayList getScoresList() throws Exception{
        
        System.out.println("get scores: " + scoresList.size()) ;
        return scoresList;
    }
    
    public static void storeNames(ArrayList username) throws FileNotFoundException, IOException{
        
        if (usersList.isEmpty()){
             System.out.println("----------Store Names " + usersList.size());
            int counter = 0;
            int length = usersList.size();
            BufferedWriter bw = new BufferedWriter(new FileWriter(usersFile, true));

            for(counter = 0 ; counter < length; counter++){
                bw.write(usersList.get(counter));
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }
       
    }    
    
    
    
    public static void storeScores(String user, int score) throws FileNotFoundException, IOException{
        int counter = 0;
        int length = scoresList.size();
       
         ScoreManager scoreManager = new ScoreManager();
               
         counter = usersList.indexOf(user);
       
        System.out.println("User: " + user);
        System.out.println("prevScore: " + scoresList.get(counter));
        System.out.println("currScore: " + score);
        System.out.println("index: " + counter);
       
       if(score>scoresList.get(counter))
            scoresList.set(counter, score);
        System.out.println("ScoreString size: " + scoresString.length);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(scoresFile, false));
  
        for(counter = 0 ; counter < length; counter++){
            bw.write(String.valueOf(scoresList.get(counter)));   
            System.out.println("Copy score: " + String.valueOf(scoresList.get(counter)));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        
            System.out.println("scoresTable: " + scoresTable.toString());
    }
      public static Hashtable getTable(){
          return scoresTable;
      }
    
    
    public static void setUsernames(ArrayList usernames) throws FileNotFoundException, IOException{
        System.out.println("set userNames") ;
        for(int i = 0; i < usernames.size(); i++){
            System.out.println(usernames.get(i));
        }
    }
    
    public static Vector getGoldScorers(){
        return gold_scorers;
    }
    
    public static Vector getSilverScorers(){
        return silver_scorers;
    }
    
    public static Vector getBronzeScorers(){
        return bronze_scorers;
    }
    
    public static Vector getWoodScorers(){
        return wood_scorers;
    }
}
