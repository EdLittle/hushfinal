/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Hush.java
 *
 * Created on Dec 5, 2011, 12:53:45 AM
 */
package GUI;

import Controllers.SoundManager;
import Controllers.DatabaseManager;
import Controllers.RoutesManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author FREAK
 */
public class Hush extends javax.swing.JFrame {

    public static Hush hush;
    public static SoundManager soundManager;
    private GUI.PlayPanel playPanel;
    private GUI.About aboutPanel;
    private GUI.PlayersStat playersStat;
    static ArrayList<String> usersList;
    static ArrayList<Integer> scoresList;
    private int[] scores;
    private GUI.LoginPanel loginPanel;
    private GUI.ScoreSummary scoreSummaryPanel;
    private HallOfUsers hallPanel;
    
    //public static CardLayout cardlayout;

    /** Creates new form Hush */
    public Hush() throws Exception{
        soundManager = new SoundManager();
        usersList = new ArrayList<String>();
        scoresList = new ArrayList<Integer>();
        RoutesManager.push("titleCard");
        System.out.println("State: " +  RoutesManager.currState());
        
        //Hush.soundManager.playBgmusic();
        initComponents();
        DatabaseManager databaseManager = new DatabaseManager();
        usersList = databaseManager.getNames();
        scoresList = databaseManager.getScores();
        
        addOtherCards();
        
        int length = usersList.size();
        for(int counter = 0 ; counter < length; counter++){
            System.out.println(counter + " " + usersList.get(counter));
        }
        
        loginPanel.setNames(usersList);
        loginPanel.assemblePanels();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePage = new GUI.TitlePage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hush");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(650, 550));
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(titlePage, "titleCard");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addOtherCards() throws Exception{
        loginPanel = new GUI.LoginPanel();
        getContentPane().add(loginPanel, "loginCard");
        
        aboutPanel = new GUI.About();
        getContentPane().add(aboutPanel, "aboutCard");
        
     //   playersStat = new GUI.PlayersStat();
     //   getContentPane().add(playersStat, "playersStatCard");
        
        playPanel = new GUI.PlayPanel();
        getContentPane().add(playPanel, "playCard");
        
        scoreSummaryPanel = new GUI.ScoreSummary();
        getContentPane().add(scoreSummaryPanel, "scoreCard");
        
        hallPanel = new GUI.HallOfUsers();
        getContentPane().add(hallPanel, "hallCard");
    }
    
    public static Hush getHush(){
        return hush;
    }
    
    public DecoyPlay getDecoyPlay(){
        return playPanel.getGamePanel();
    }
    public ScoreSummary getScoreSummary(){
        return scoreSummaryPanel;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hush.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hush.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hush.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hush.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        hush = new Hush();
        hush.setVisible(true);
        hush.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
            }
        });
    }
    
    public LayoutManager getCardLayout(){
        return getContentPane().getLayout();
    }
    
    public void navigate(String cardName){
       System.out.println("State: " +  RoutesManager.currState() + " to " + cardName);
       hush = Hush.getHush();
       CardLayout cardLayout = (CardLayout) hush.getCardLayout();
       cardLayout.show(hush.getContentPane(), cardName);
       RoutesManager.push(cardName);
       Hush.soundManager.playClickOff();
    
    }
    
    public HallOfUsers getHallOfUsers(){
    return hallPanel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.TitlePage titlePage;
    // End of variables declaration//GEN-END:variables
}
