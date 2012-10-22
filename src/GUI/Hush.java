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
import Controllers.RoutesManager;
import Controllers.DatabaseManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JFrame;

/**
 *
 * @author FREAK
 */
public class Hush extends javax.swing.JFrame {

    //public static String mainMenuCard = "Main Menu";
    //public static String loginCard = "Login";
    public static Hush hush;
    public static SoundManager soundManager;
    private GUI.PlayPanel playPanel;
    private GUI.About aboutPanel;
    private String[] users;
    private GUI.LoginPanel loginPanel;
    
    //public static CardLayout cardlayout;

    /** Creates new form Hush */
    public Hush() throws Exception{
        //soundManager = new SoundManager();
        DatabaseManager databaseManager = new DatabaseManager();
        //databaseManager.storeNames(new String[]{"Nicki Minaj", "Katy Perry", "Jessie J", "Infinite", "MBLAQ"});
        //databaseManager.storeNames(new String[]{"Sung Gyu", "Dong Woo", "Woo Hyun", "Hoya", "Sung Yeol" , "L","SungJong"});
        users = databaseManager.getNames();
        
        int length = users.length;
        for(int counter = 0 ; counter < length; counter++){
            System.out.println(counter + " " + users[counter]);
        }
        //databaseManager.storeNames(new String[]{"Nicki Minaj", "Katy Perry", "Jessie J", "Infinite", "MBLAQ"});
        initComponents();
        addOtherCards();
        loginPanel.setNames(users);
        loginPanel.assemblePanels();
        RoutesManager.push("titleCard");
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
        
        playPanel = new GUI.PlayPanel();
        getContentPane().add(playPanel, "playCard");
        
        
    }
    
    public static Hush getHush(){
        return hush;
    }
    
    public DecoyPlay getDecoyPlay(){
        return playPanel.getGamePanel();
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.TitlePage titlePage;
    // End of variables declaration//GEN-END:variables
}
