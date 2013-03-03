/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScoreSummary.java
 *
 * Created on Dec 28, 2012, 4:35:11 PM
 */
package GUI;

import Controllers.ScoreManager;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;

/**
 *
 * @author FREAK
 */
public class ScoreSummary extends javax.swing.JPanel {
    private String username = "Friend";
    private String greeting = "Hi";
    private String categ = "Water";
    private int score = 0;
    private Vector rightColors = new Vector();
    private Vector rightShapes = new Vector();
    private String[] msgGreeting = {"Excellent work", "Good job", "Nice playing", "Hi"};
    private String[] starCategories = {"GOLD", "SILVER", "BRONZE", "WOOD"};
    private JLabel[] list;// = {"red", "orange", "yellow", "green", "blue", "white", "black", "circle", "square"};
    private Hush hush;
    private GUI.ControlPanel controlPanel;
    /**
     * Enumerate all right colors and shapes after
     * under the star.
     * 
     * /
     * 
    /** Creates new form ScoreSummary */
    public ScoreSummary() {
        initComponents();
    }

    public void setMessage () throws Exception{
        this.rightColors = ScoreManager.getRightColors();
        this.rightShapes = ScoreManager.getRightShapes();
        this.username = ScoreManager.getUsername();
        this.score = ScoreManager.getScore();
        this.greeting = msgGreeting[ScoreManager.getCategory(score)];
        this.categ = starCategories[ScoreManager.getCategory(score)];
        
        if(this.categ == "GOLD") {
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/coin.png")));
        }
        else if (this.categ == "SILVER"){
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/coins.png")));
        }
        else if(this.categ == "BRONZE"){
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/gold bars.png")));
        }
        else{
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/diamond.png")));
        }
        
        correctAns();
        
        this.msg.setText(greeting + ", " + username + "!"); 
        this.msg2.setText("You now have " + categ + " badge.");

        this.repaint();
        HallOfUsers.gameOver();
    }
    
    public void correctAns(){
            if (rightColors.contains("red")){
                red.setForeground(Color.RED);
                red.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("orange")){
                orange.setForeground(Color.ORANGE);
                orange.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("yellow")){
                yellow.setForeground(Color.YELLOW);
                yellow.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("green")){
                green.setForeground(Color.GREEN);
                green.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("blue")){
                blue.setForeground(Color.BLUE);
                blue.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("white")){
                white.setForeground(Color.WHITE);
                white.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightColors.contains("black")){
                black.setForeground(Color.BLACK);
                black.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightShapes.contains("circle")){
                circle.setForeground(Color.MAGENTA);
                circle.setFont(new java.awt.Font("Century Gothic", 1, 18));
            }
            if (rightShapes.contains("square")){
                square.setForeground(Color.MAGENTA);
                square.setFont(new java.awt.Font("Century Gothic", 1, 18));
            } 
    }
       
    public void clearList(){
      for(int i=2; i<jPanel11.getComponentCount(); i++){
            Component label = jPanel11.getComponent(i);     
            System.out.println("CLEARING: " + label.getName());
            System.out.println(" " + label.toString());
            if(i!=9){     
                label.setFont(new java.awt.Font("Century Gothic", 0, 18));
                label.setForeground(new java.awt.Color(204, 204, 204));
            }
        }
    }
    public void updateControlPanel(){
        hush = Hush.getHush();                
        controlPanel = hush.getControlPanel();
        this.jPanel8.add(controlPanel);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        msg = new java.awt.Label();
        msg2 = new java.awt.Label();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        listOfCorrAns = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        red = new javax.swing.JLabel();
        orange = new javax.swing.JLabel();
        green = new javax.swing.JLabel();
        yellow = new javax.swing.JLabel();
        blue = new javax.swing.JLabel();
        black = new javax.swing.JLabel();
        white = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        square = new javax.swing.JLabel();
        circle = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(650, 550));
        setMinimumSize(new java.awt.Dimension(650, 550));
        setPreferredSize(new java.awt.Dimension(650, 550));
        setLayout(new java.awt.GridBagLayout());

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

        jPanel4.setMinimumSize(new java.awt.Dimension(75, 500));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 400));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(jPanel4, gridBagConstraints);

        jPanel5.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med/star.png"))); // NOI18N

        msg.setFont(new java.awt.Font("Kristen ITC", 0, 14)); // NOI18N
        msg.setText(greeting + ", " + username + "!");

        msg2.setFont(new java.awt.Font("Kristen ITC", 0, 14)); // NOI18N
        msg2.setText("You now have " + categ + " badge");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel14.setText("Game Over");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel13))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(75, 75, 75)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        jPanel11.setLayout(new java.awt.GridLayout(12, 1));

        listOfCorrAns.setFont(new java.awt.Font("Century Gothic", 0, 11));
        listOfCorrAns.setForeground(new java.awt.Color(0, 0, 0));
        listOfCorrAns.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listOfCorrAns.setText("You got the ff. right:");
        jPanel11.add(listOfCorrAns);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Colors");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jLabel1);

        red.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        red.setForeground(new java.awt.Color(204, 204, 204));
        red.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        red.setText("Red");
        jPanel11.add(red);

        orange.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        orange.setForeground(new java.awt.Color(204, 204, 204));
        orange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orange.setText("Orange");
        jPanel11.add(orange);

        green.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        green.setForeground(new java.awt.Color(204, 204, 204));
        green.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green.setText("Green");
        jPanel11.add(green);

        yellow.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        yellow.setForeground(new java.awt.Color(204, 204, 204));
        yellow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yellow.setText("Yellow");
        jPanel11.add(yellow);

        blue.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        blue.setForeground(new java.awt.Color(204, 204, 204));
        blue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blue.setText("Blue");
        jPanel11.add(blue);

        black.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        black.setForeground(new java.awt.Color(204, 204, 204));
        black.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        black.setText("Black");
        jPanel11.add(black);

        white.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        white.setForeground(new java.awt.Color(204, 204, 204));
        white.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        white.setText("White");
        jPanel11.add(white);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Shapes");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jLabel10);

        square.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        square.setForeground(new java.awt.Color(204, 204, 204));
        square.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square.setText("Square");
        jPanel11.add(square);

        circle.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        circle.setForeground(new java.awt.Color(204, 204, 204));
        circle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        circle.setText("Circle");
        jPanel11.add(circle);

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 130, 400));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(jPanel5, gridBagConstraints);

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

        jPanel8.setPreferredSize(new java.awt.Dimension(500, 75));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(jPanel8, gridBagConstraints);

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
    private javax.swing.JLabel black;
    private javax.swing.JLabel blue;
    private javax.swing.JLabel circle;
    private javax.swing.JLabel green;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel listOfCorrAns;
    private java.awt.Label msg;
    private java.awt.Label msg2;
    private javax.swing.JLabel orange;
    private javax.swing.JLabel red;
    private javax.swing.JLabel square;
    private javax.swing.JLabel white;
    private javax.swing.JLabel yellow;
    // End of variables declaration//GEN-END:variables
}

