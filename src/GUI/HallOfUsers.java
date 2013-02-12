/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Vector;

/**
 *
 * @author ed.escalante
 */
public class HallOfUsers extends javax.swing.JPanel {
    
    private Vector gold_scorers;
    private Vector silver_scorers;
    private Vector bronze_scorers;
    private Vector wood_scorers;
    
    /**
     * Creates new form HallOfUsers
     */
    public HallOfUsers() {
        initComponents();
        jPanel8.add(new GUI.ControlPanel());
        initVectors();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initVectors(){
        gold_scorers = new Vector();
        silver_scorers = new Vector();
        bronze_scorers = new Vector();
        wood_scorers = new Vector();
        
        //In real life:
        //gold = PlayerStat.getGold() ;
        //silver = PlayerStat.getSilver();
        //bronze = PlayerStat.getBronze();
        //wood = PlayerStat.getWood();
        gold_scorers.add("Beyonce");
        gold_scorers.add("Taylor");
        gold_scorers.add("Rih");
        silver_scorers.add("Chris");
        silver_scorers.add("Khaleesi");
        silver_scorers.add("Drogo");
        bronze_scorers.add("Harry");
        bronze_scorers.add("Qarth");
        bronze_scorers.add("Ron");
        wood_scorers.add("Hermione");
        wood_scorers.add("Lupin");
        wood_scorers.add("Romulus");
        
        
        for(Object name : gold_scorers){
            gold_list.add((String) name);
        }
        
        for(Object name : silver_scorers){
            silver_list.add((String) name);
        }
        
        for(Object name : bronze_scorers){
            bronze_list.add((String) name);
        }
        
        for(Object name : wood_scorers){
            wood_list.add((String) name);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        gold_list = new java.awt.List();
        jPanel11 = new javax.swing.JPanel();
        silver_list = new java.awt.List();
        jPanel12 = new javax.swing.JPanel();
        bronze_list = new java.awt.List();
        jPanel13 = new javax.swing.JPanel();
        wood_list = new java.awt.List();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(650, 550));
        setPreferredSize(new java.awt.Dimension(650, 550));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(75, 75));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        add(jPanel1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(500, 75));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(jPanel2, gridBagConstraints);

        jPanel3.setMinimumSize(new java.awt.Dimension(75, 75));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(jPanel3, gridBagConstraints);

        jPanel4.setMaximumSize(new java.awt.Dimension(75, 500));
        jPanel4.setMinimumSize(new java.awt.Dimension(75, 500));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 400));

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 500, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(jPanel4, gridBagConstraints);

        jPanel5.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(51, 0, 51));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(479, 354));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(479, 354));

        jPanel10.setBackground(new java.awt.Color(0, 0, 51));
        jPanel10.setLayout(new java.awt.GridLayout());

        gold_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gold_listActionPerformed(evt);
            }
        });
        jPanel10.add(gold_list);

        jTabbedPane1.addTab("Gold", jPanel10);

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));
        jPanel11.setLayout(new java.awt.GridLayout(1, 1));

        silver_list.setMinimumSize(new java.awt.Dimension(479, 354));
        silver_list.setPreferredSize(new java.awt.Dimension(479, 354));
        jPanel11.add(silver_list);

        jTabbedPane1.addTab("Silver", jPanel11);

        jPanel12.setBackground(new java.awt.Color(51, 0, 0));
        jPanel12.setLayout(new java.awt.GridLayout());

        bronze_list.setMinimumSize(new java.awt.Dimension(479, 354));
        bronze_list.setPreferredSize(new java.awt.Dimension(479, 354));
        jPanel12.add(bronze_list);

        jTabbedPane1.addTab("Bronze", jPanel12);

        jPanel13.setBackground(new java.awt.Color(51, 0, 51));
        jPanel13.setLayout(new java.awt.GridLayout());

        wood_list.setMinimumSize(new java.awt.Dimension(479, 354));
        wood_list.setPreferredSize(new java.awt.Dimension(479, 354));
        jPanel13.add(wood_list);

        jTabbedPane1.addTab("Wood", jPanel13);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(jPanel5, gridBagConstraints);

        jPanel6.setMinimumSize(new java.awt.Dimension(75, 400));

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(jPanel6, gridBagConstraints);

        jPanel7.setSize(new java.awt.Dimension(75, 75));

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(jPanel7, gridBagConstraints);

        jPanel8.setMinimumSize(new java.awt.Dimension(500, 75));
        jPanel8.setSize(new java.awt.Dimension(75, 75));
        jPanel8.setLayout(new java.awt.GridLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(jPanel8, gridBagConstraints);

        jPanel9.setMinimumSize(new java.awt.Dimension(75, 75));

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 75, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(jPanel9, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void gold_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gold_listActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_gold_listActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List bronze_list;
    private java.awt.List gold_list;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.List silver_list;
    private java.awt.List wood_list;
    // End of variables declaration//GEN-END:variables
}
