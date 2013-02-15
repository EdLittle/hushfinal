/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NamePanel.java
 *
 * Created on Jan 27, 2012, 1:38:33 AM
 */
package GUI;

import Controllers.ScoreManager;
import Controllers.DatabaseManager;
import Controllers.RoutesManager;
import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author FREAK
 */
public class NamePanel extends javax.swing.JPanel {
    private Hush hush;
    int number;
    static ArrayList<String> usersList = new ArrayList<String>();
    static JPanel[] panels;
    
    
    /** Creates new form NamePanel */
    public NamePanel() {
        initComponents();
    }
    
    public NamePanel(int number){
        initComponents();
        this.number = number;
        
    }
    
    public void setDisplayName(String name){
        this.name.setText(name);
    }
    
    public static void setStaticFields(JPanel[] userPanels){
        NamePanel.panels = userPanels;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        button = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(250, 115));
        setMinimumSize(new java.awt.Dimension(250, 115));
        setPreferredSize(new java.awt.Dimension(250, 115));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setAutoscrolls(true);
        name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 2, 10))); // NOI18N
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 45));

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/delete.png"))); // NOI18N
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMouseClicked(evt);
            }
        });
        add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseClicked
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) panels[this.number].getLayout();
        cardLayout.show(panels[number], "card2");
               
    }//GEN-LAST:event_buttonMouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        try {
            // TODO add your handling code here:
            usersList = DatabaseManager.getUsersList();
            DatabaseManager.storeNames(usersList);
        } catch (Exception ex) {
            Logger.getLogger(NamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        hush = Hush.getHush();
        hush.navigate("playCard");   
 
        try {
            hush.getDecoyPlay().startGame();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        hush.getDecoyPlay().getCamera().startFeed();
        ScoreManager.setUsername(this.name.getText());
    }//GEN-LAST:event_nameMouseClicked
    
    public void displayName(){
        System.out.println(this.name.getText());
    }
    
    public String getUsername(){
        return this.name.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
