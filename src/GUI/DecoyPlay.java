/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DecoyPlay.java
 *
 * Created on Feb 24, 2012, 1:19:07 PM
 */
package GUI;

import Controllers.CameraFeed;
import Controllers.GameManager;
import Controllers.RoutesManager;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author FREAK
 */
public class DecoyPlay extends javax.swing.JPanel {
    //public GameplayManager gameplayManager;
    public GameManager gameManager;
    private CameraFeed camera;    
    private Hush hush;
    
    /** Creates new form DecoyPlay */
    public DecoyPlay() throws Exception{
        initComponents();
        camera = new CameraFeed();
        jPanel2.add(camera);
    }    
    public CameraFeed getCamera(){
        return camera;
    }
        
    public JLabel getStopLight1(){
        return stopLight1;
    }
    
    public JLabel getStopLight2(){
        return stopLight2;
    }
    
    public JLabel getJLabel1(){
        return jLabel1;
    }
    
    public void startGame() throws FileNotFoundException{
        gameManager = new GameManager();
    }
    
    public GameManager getGameManager(){
        return gameManager;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        stopLight2 = new javax.swing.JLabel();
        stopLight1 = new javax.swing.JLabel();
        jPanel2 = new JPanel(){
      public void paint(Graphics g) {
     g.drawRect (80, 80,  350, 200);  
   }
 };

        setBackground(new java.awt.Color(204, 255, 255));
        setMaximumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/start.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        stopLight2.setBackground(new java.awt.Color(204, 255, 255));
        stopLight2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stopLight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight.png"))); // NOI18N
        stopLight2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(stopLight2, java.awt.BorderLayout.LINE_END);

        stopLight1.setBackground(new java.awt.Color(255, 255, 255));
        stopLight1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stopLight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/trafficlight.png"))); // NOI18N
        stopLight1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(stopLight1, java.awt.BorderLayout.LINE_START);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 1));
        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(!gameManager.isRunning()){
            try {
                hush = Hush.getHush();
                Hush.soundManager.playClickOff();                                  
                
                gameManager.startGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(DecoyPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel stopLight1;
    private javax.swing.JLabel stopLight2;
    // End of variables declaration//GEN-END:variables
}
