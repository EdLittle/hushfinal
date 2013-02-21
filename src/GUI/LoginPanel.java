/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginPanel.java
 *
 * Created on Jan 16, 2012, 3:54:03 PM
 */
package GUI;

import Controllers.DatabaseManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author FREAK
 */
public class LoginPanel extends javax.swing.JPanel {
    static ArrayList<String> usersList;
    public static LoginPanel loginPanel;
    public JPanel[] panels;
    public static NamePanel[] namePanels;
    public FieldPanel[] fieldPanels;
    public Hush hush;
    public GUI.ControlPanel controlPanel;
    
    /** Creates new form LoginPanel */
    public LoginPanel() {
        initComponents();
        loginPanel = this;
    }
    
    public void updateControlPanel(){
        hush = Hush.getHush();                
        controlPanel = hush.getControlPanel();
        this.jPanel9.add(controlPanel);
    } 
    public void setNames(ArrayList users){
        usersList = new ArrayList<String>();
        this.usersList = users;
    }
    
    public void assemblePanels(){
        int counter = 0;
        int length = usersList.size();
        
        panels = new JPanel[]{nameHolder1, nameHolder2, nameHolder3, nameHolder4, nameHolder5, nameHolder6, nameHolder7, nameHolder8};
        namePanels = new NamePanel[]{namePanel1, namePanel2, namePanel3, namePanel4, namePanel5, namePanel6, namePanel7, namePanel8};
        fieldPanels = new FieldPanel[]{fieldPanel1, fieldPanel2, fieldPanel3, fieldPanel4, fieldPanel5, fieldPanel6, fieldPanel7, fieldPanel8};
        
        for(counter = 0; counter < 8; counter++){
            CardLayout cardLayout = (CardLayout) panels[counter].getLayout();
            
            if(counter < length){
                namePanels[counter].setDisplayName(usersList.get(counter));
                cardLayout.show(panels[counter], "card3");
            }
            else{
                cardLayout.show(panels[counter], "card2");
            }
        }
        NamePanel.setStaticFields(new JPanel[]{nameHolder1, nameHolder2, nameHolder3, nameHolder4, nameHolder5, nameHolder6, nameHolder7, nameHolder8});
        FieldPanel.setStaticFields(new JPanel[]{nameHolder1, nameHolder2, nameHolder3, nameHolder4, nameHolder5, nameHolder6, nameHolder7, nameHolder8});
    }
    
    public static void setUsername(String newUsername, int number){
        namePanels[number].setDisplayName(newUsername);
        try {
            DatabaseManager.updateUsername(newUsername);
        } catch (Exception ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LoginPanel getLoginPanel(){
        return loginPanel;
    }
    
    /*
    public void addControlPanel(){
        hush = Hush.getHush();
        controlPanel = hush.getControlPanel();
        jPanel8.add(controlPanel);
    }
    /*
    public static void gatherNames(){
        String[] names = {"", "", "", "", "", "", "", ""};
        
        int counter =0;
        for(counter = 0; counter < 8; counter++){
            names[counter] = namePanels[counter].getUsername();
        }
        
        for(counter = 0; counter < 8; counter++){
            System.out.println(names[counter]);
        }
    }
    */
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        nameHolder1 = new javax.swing.JPanel();
        fieldPanel1 = new FieldPanel(0);
        namePanel1 = new GUI.NamePanel(0);
        nameHolder2 = new javax.swing.JPanel();
        fieldPanel2 = new FieldPanel(1);
        namePanel2 = new GUI.NamePanel(1);
        nameHolder3 = new javax.swing.JPanel();
        fieldPanel3 = new FieldPanel(2);
        namePanel3 = new GUI.NamePanel(2);
        nameHolder4 = new javax.swing.JPanel();
        fieldPanel4 = new FieldPanel(3);
        namePanel4 = new GUI.NamePanel(3);
        nameHolder5 = new javax.swing.JPanel();
        fieldPanel5 = new FieldPanel(4);
        namePanel5 = new GUI.NamePanel(4);
        nameHolder6 = new javax.swing.JPanel();
        fieldPanel6 = new FieldPanel(5);
        namePanel6 = new GUI.NamePanel(5);
        nameHolder7 = new javax.swing.JPanel();
        fieldPanel7 = new FieldPanel(6);
        namePanel7 = new GUI.NamePanel(6);
        nameHolder8 = new javax.swing.JPanel();
        fieldPanel8 = new FieldPanel(7);
        namePanel8 = new GUI.NamePanel(7);
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(650, 550));
        setMinimumSize(new java.awt.Dimension(650, 550));
        setPreferredSize(new java.awt.Dimension(650, 550));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(75, 75));
        jPanel1.setMinimumSize(new java.awt.Dimension(75, 75));
        jPanel1.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jPanel1, gridBagConstraints);

        jPanel2.setMaximumSize(new java.awt.Dimension(500, 75));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 75));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(jPanel2, gridBagConstraints);

        jPanel3.setMaximumSize(new java.awt.Dimension(75, 75));
        jPanel3.setMinimumSize(new java.awt.Dimension(75, 75));
        jPanel3.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(jPanel3, gridBagConstraints);

        jPanel4.setMaximumSize(new java.awt.Dimension(75, 400));
        jPanel4.setMinimumSize(new java.awt.Dimension(75, 400));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 400));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(jPanel4, gridBagConstraints);

        jPanel5.setMaximumSize(new java.awt.Dimension(500, 400));
        jPanel5.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 2, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("What's your name?");
        jLabel1.setFocusable(false);
        jPanel5.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel10.setLayout(new java.awt.GridLayout(4, 2));

        nameHolder1.setLayout(new java.awt.CardLayout());
        nameHolder1.add(fieldPanel1, "card2");
        nameHolder1.add(namePanel1, "card3");

        jPanel10.add(nameHolder1);

        nameHolder2.setLayout(new java.awt.CardLayout());
        nameHolder2.add(fieldPanel2, "card2");
        nameHolder2.add(namePanel2, "card3");

        jPanel10.add(nameHolder2);

        nameHolder3.setLayout(new java.awt.CardLayout());
        nameHolder3.add(fieldPanel3, "card2");
        nameHolder3.add(namePanel3, "card3");

        jPanel10.add(nameHolder3);

        nameHolder4.setLayout(new java.awt.CardLayout());
        nameHolder4.add(fieldPanel4, "card2");
        nameHolder4.add(namePanel4, "card3");

        jPanel10.add(nameHolder4);

        nameHolder5.setLayout(new java.awt.CardLayout());
        nameHolder5.add(fieldPanel5, "card2");
        nameHolder5.add(namePanel5, "card3");

        jPanel10.add(nameHolder5);

        nameHolder6.setLayout(new java.awt.CardLayout());
        nameHolder6.add(fieldPanel6, "card2");
        nameHolder6.add(namePanel6, "card3");

        jPanel10.add(nameHolder6);

        nameHolder7.setLayout(new java.awt.CardLayout());
        nameHolder7.add(fieldPanel7, "card2");
        nameHolder7.add(namePanel7, "card3");

        jPanel10.add(nameHolder7);

        nameHolder8.setLayout(new java.awt.CardLayout());
        nameHolder8.add(fieldPanel8, "card2");
        nameHolder8.add(namePanel8, "card3");

        jPanel10.add(nameHolder8);

        jPanel5.add(jPanel10, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(jPanel5, gridBagConstraints);

        jPanel6.setMaximumSize(new java.awt.Dimension(75, 400));
        jPanel6.setMinimumSize(new java.awt.Dimension(75, 400));
        jPanel6.setPreferredSize(new java.awt.Dimension(75, 400));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(jPanel6, gridBagConstraints);

        jPanel7.setMaximumSize(new java.awt.Dimension(75, 75));
        jPanel7.setMinimumSize(new java.awt.Dimension(75, 75));
        jPanel7.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(jPanel7, gridBagConstraints);

        jPanel8.setMaximumSize(new java.awt.Dimension(500, 75));
        jPanel8.setMinimumSize(new java.awt.Dimension(500, 75));
        jPanel8.setPreferredSize(new java.awt.Dimension(500, 75));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(jPanel8, gridBagConstraints);

        jPanel9.setMaximumSize(new java.awt.Dimension(75, 75));
        jPanel9.setMinimumSize(new java.awt.Dimension(75, 75));
        jPanel9.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(jPanel9, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.FieldPanel fieldPanel1;
    private GUI.FieldPanel fieldPanel2;
    private GUI.FieldPanel fieldPanel3;
    private GUI.FieldPanel fieldPanel4;
    private GUI.FieldPanel fieldPanel5;
    private GUI.FieldPanel fieldPanel6;
    private GUI.FieldPanel fieldPanel7;
    private GUI.FieldPanel fieldPanel8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel nameHolder1;
    private javax.swing.JPanel nameHolder2;
    private javax.swing.JPanel nameHolder3;
    private javax.swing.JPanel nameHolder4;
    private javax.swing.JPanel nameHolder5;
    private javax.swing.JPanel nameHolder6;
    private javax.swing.JPanel nameHolder7;
    private javax.swing.JPanel nameHolder8;
    private GUI.NamePanel namePanel1;
    private GUI.NamePanel namePanel2;
    private GUI.NamePanel namePanel3;
    private GUI.NamePanel namePanel4;
    private GUI.NamePanel namePanel5;
    private GUI.NamePanel namePanel6;
    private GUI.NamePanel namePanel7;
    private GUI.NamePanel namePanel8;
    // End of variables declaration//GEN-END:variables
}
