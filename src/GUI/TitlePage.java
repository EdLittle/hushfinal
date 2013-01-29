/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TitlePage.java
 *
 * Created on Jan 12, 2012, 11:01:37 PM
 */
package GUI;

import Controllers.RoutesManager;
import Controllers.SoundManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 *
 * @author FREAK
 */
public class TitlePage extends javax.swing.JPanel {
    private static Color defaultFontColor = new Color(153, 153, 153);
    private Hush hush;
    private SoundManager soundManager;
    private ControlPanel controlPanel;
    
    /** Creates new form TitlePage */
    public TitlePage() {
        initComponents();
        controlPanel = new ControlPanel();   
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        playIcon = new javax.swing.JLabel();
        optionsIcon = new javax.swing.JLabel();
        aboutIcon = new javax.swing.JLabel();
        quitIcon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(650, 550));
        setLayout(new java.awt.GridBagLayout());

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Century Gothic", 1, 200)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Hush");
        title.setMaximumSize(new java.awt.Dimension(500, 400));
        title.setMinimumSize(new java.awt.Dimension(500, 400));
        title.setPreferredSize(new java.awt.Dimension(580, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(title, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel1, new java.awt.GridBagConstraints());

        jPanel2.setMaximumSize(new java.awt.Dimension(580, 125));
        jPanel2.setMinimumSize(new java.awt.Dimension(580, 125));
        jPanel2.setPreferredSize(new java.awt.Dimension(580, 125));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        playIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        playIcon.setForeground(new java.awt.Color(153, 153, 153));
        playIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/controls-alt-2.png"))); // NOI18N
        playIcon.setText("PLAY");
        playIcon.setToolTipText("New Game");
        playIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        playIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playIconMouseExited(evt);
            }
        });
        jPanel2.add(playIcon);

        optionsIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        optionsIcon.setForeground(new java.awt.Color(153, 153, 153));
        optionsIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/options.png"))); // NOI18N
        optionsIcon.setText("OPTIONS");
        optionsIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        optionsIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        optionsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                optionsIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                optionsIconMouseExited(evt);
            }
        });
        jPanel2.add(optionsIcon);

        aboutIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        aboutIcon.setForeground(new java.awt.Color(153, 153, 153));
        aboutIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/about.png"))); // NOI18N
        aboutIcon.setText("ABOUT");
        aboutIcon.setFocusable(false);
        aboutIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aboutIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aboutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutIconMouseExited(evt);
            }
        });
        jPanel2.add(aboutIcon);

        quitIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        quitIcon.setForeground(new java.awt.Color(153, 153, 153));
        quitIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/power-standby.png"))); // NOI18N
        quitIcon.setText("QUIT");
        quitIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        quitIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        quitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quitIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quitIconMouseExited(evt);
            }
        });
        jPanel2.add(quitIcon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void playIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playIconMouseEntered
// TODO add your handling code here:
    playIcon.setForeground(Color.black);
    playIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/controls-alt-2-hov.png")));
    //Hush.soundManager.playClick();
}//GEN-LAST:event_playIconMouseEntered

private void playIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playIconMouseExited
// TODO add your handling code here:
    playIcon.setForeground(defaultFontColor);
    playIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/controls-alt-2.png")));
}//GEN-LAST:event_playIconMouseExited

private void optionsIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsIconMouseEntered
// TODO add your handling code here:
    optionsIcon.setForeground(Color.black);
    optionsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/options-hov.png")));
    //Hush.soundManager.playClick();
}//GEN-LAST:event_optionsIconMouseEntered

private void optionsIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsIconMouseExited
// TODO add your handling code here:
    optionsIcon.setForeground(defaultFontColor);
    optionsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/options.png")));
}//GEN-LAST:event_optionsIconMouseExited

private void aboutIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutIconMouseEntered
// TODO add your handling code here:
    aboutIcon.setForeground(Color.black);
    aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/about-hov.png")));
    //Hush.soundManager.playClick();
}//GEN-LAST:event_aboutIconMouseEntered

private void aboutIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutIconMouseExited
// TODO add your handling code here:
    aboutIcon.setForeground(defaultFontColor);
    aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/about.png")));
}//GEN-LAST:event_aboutIconMouseExited

private void quitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitIconMouseClicked
// TODO add your handling code here:
    Hush.soundManager.playClickOff();
    System.exit(0);
}//GEN-LAST:event_quitIconMouseClicked

private void quitIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitIconMouseEntered
// TODO add your handling code here:
    quitIcon.setForeground(Color.black);
    quitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/power-standby-hov.png")));
    //Hush.soundManager.playClick();
}//GEN-LAST:event_quitIconMouseEntered

private void quitIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitIconMouseExited
// TODO add your handling code here:
    quitIcon.setForeground(defaultFontColor);
    quitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/power-standby.png")));
}//GEN-LAST:event_quitIconMouseExited

private void playIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playIconMouseClicked
// TODO add your handling code here:
    enterCard("loginCard");
}//GEN-LAST:event_playIconMouseClicked

private void aboutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutIconMouseClicked
// TODO add your handling code here:
    enterCard("aboutCard");
}//GEN-LAST:event_aboutIconMouseClicked

    private void optionsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsIconMouseClicked
        // TODO add your handling code here:
        enterCard("aboutCard");
    }//GEN-LAST:event_optionsIconMouseClicked

    private void enterCard(String cardName){
        hush = Hush.getHush();
        CardLayout cardLayout = (CardLayout) hush.getCardLayout();
        cardLayout.show(hush.getContentPane(), cardName);
        RoutesManager.push(cardName);
        System.out.println("State: " +  RoutesManager.currState() + " to" + cardName);
        Hush.soundManager.playClickOff();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel optionsIcon;
    private javax.swing.JLabel playIcon;
    private javax.swing.JLabel quitIcon;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
