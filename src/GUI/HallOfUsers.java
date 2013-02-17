/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controllers.DatabaseManager;
import Controllers.ScoreManager;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ed.escalante
 */
public class HallOfUsers extends javax.swing.JPanel {
    
    static ArrayList<String> users = new ArrayList<String>();
    static ArrayList<Integer> scores = new ArrayList<Integer>();

    //private DatabaseManager databaseManager;
    private Vector gold_scorers = new Vector();
    private Vector silver_scorers = new Vector();
    private Vector bronze_scorers = new Vector();
    private Vector wood_scorers = new Vector();
    private Hush hush;
    /**
     * Creates new form HallOfUsers
     */
    public HallOfUsers() throws Exception {
        initComponents();
        hush = Hush.getHush();
        jPanel8.add(new GUI.ControlPanel());
        initVectors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initVectors() throws Exception{
        jPanel10.remove(gold_list);
        users = DatabaseManager.getUsersList();
        scores = DatabaseManager.getScoresList();

        gold_scorers.clear();
        silver_scorers.clear();
        bronze_scorers.clear();
        wood_scorers.clear();
        //DatabaseManager.categorizeScores();
        DatabaseManager.categorizeScores();
        
        gold_scorers = DatabaseManager.getGoldScorers();
        silver_scorers = DatabaseManager.getSilverScorers();
        bronze_scorers = DatabaseManager.getBronzeScorers();
        wood_scorers = DatabaseManager.getWoodScorers();
        
        displayAll();
        for(int x=0; x<gold_scorers.size(); x++){
            System.out.println("index of: " + gold_scorers.indexOf("Beyonce"));
        }

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
        jPanel10.add(gold_list, BorderLayout.CENTER);
    }
    
    public void displayAll(){
        
       System.out.println("Gold: " + gold_scorers.toString());
       System.out.println("Silver: " + silver_scorers.toString());
       System.out.println("Bronze: " + bronze_scorers.toString());
       System.out.println("Wood: " + wood_scorers.toString());
    }
    
     public void updateStat()throws Exception{
             
        users = DatabaseManager.getUsersList();
        scores = DatabaseManager.getScoresList();
        gold_scorers.clear();
        silver_scorers.clear();
        bronze_scorers.clear();
        wood_scorers.clear();
              
        //System.out.println("ScoreSize: " + users.size() + " " + scores.size());
        DatabaseManager.categorizeScores();
        
        gold_scorers = DatabaseManager.getGoldScorers();
        silver_scorers = DatabaseManager.getSilverScorers();
        bronze_scorers = DatabaseManager.getBronzeScorers();
        wood_scorers = DatabaseManager.getWoodScorers();
        
        for (int x=0; x<scores.size(); x++){
           if (ScoreManager.getCategory(scores.get(x)) == 0){
               gold_scorers.add(users.get(x));               
           }
           else if (ScoreManager.getCategory(scores.get(x)) == 1){
               silver_scorers.add(users.get(x));               
           }
           else if (ScoreManager.getCategory(scores.get(x)) == 2){
               bronze_scorers.add(users.get(x));               
           }
           else {
               wood_scorers.add(users.get(x));               
           }
       }
       //displayAll();  
    }
    
    public Vector getGold(){
        return gold_scorers;
    }
    
    public Vector getSilver(){
        return silver_scorers;
    }
    
    public Vector getBronze(){
        return bronze_scorers;
    }
    
    public Vector getWood(){
        return wood_scorers;
    }
    
    public static void gameOver() throws Exception{
       DatabaseManager.storeScores(ScoreManager.getUsername(), ScoreManager.getScore());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        gold_list = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        silver_list = new java.awt.List();
        label2 = new java.awt.Label();
        jPanel12 = new javax.swing.JPanel();
        bronze_list = new java.awt.List();
        label3 = new java.awt.Label();
        jPanel13 = new javax.swing.JPanel();
        wood_list = new java.awt.List();
        label4 = new java.awt.Label();
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
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        label1.setText("HALL OF SCORES");
        jPanel2.add(label1);

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

        jPanel10.setLayout(new java.awt.BorderLayout());

        gold_list.setBackground(new java.awt.Color(238, 238, 238));
        gold_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gold_listActionPerformed(evt);
            }
        });
        jPanel10.add(gold_list, java.awt.BorderLayout.CENTER);

        jLabel1.setText("People who garnered 8 stars and up");
        jPanel10.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Gold", jPanel10);

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));
        jPanel11.setLayout(new java.awt.BorderLayout());

        silver_list.setBackground(new java.awt.Color(238, 238, 238));
        jPanel11.add(silver_list, java.awt.BorderLayout.CENTER);

        label2.setBackground(new java.awt.Color(238, 238, 238));
        label2.setText("People who garnered 6-7 stars");
        jPanel11.add(label2, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Silver", jPanel11);

        jPanel12.setBackground(new java.awt.Color(51, 0, 0));
        jPanel12.setLayout(new java.awt.BorderLayout());

        bronze_list.setBackground(new java.awt.Color(238, 238, 238));
        jPanel12.add(bronze_list, java.awt.BorderLayout.CENTER);

        label3.setBackground(new java.awt.Color(238, 238, 238));
        label3.setText("People who garnered 4-6 stars");
        jPanel12.add(label3, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Bronze", jPanel12);

        jPanel13.setBackground(new java.awt.Color(51, 0, 51));
        jPanel13.setLayout(new java.awt.BorderLayout());

        wood_list.setBackground(new java.awt.Color(238, 238, 238));
        jPanel13.add(wood_list, java.awt.BorderLayout.CENTER);

        label4.setBackground(new java.awt.Color(238, 238, 238));
        label4.setText("People who garnered less than 4 stars");
        jPanel13.add(label4, java.awt.BorderLayout.PAGE_START);

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
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));
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
    private static java.awt.List bronze_list;
    private static java.awt.List gold_list;
    private javax.swing.JLabel jLabel1;
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
    private static javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private static java.awt.List silver_list;
    private static java.awt.List wood_list;
    // End of variables declaration//GEN-END:variables
}
