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
import javax.swing.Icon;
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
    private Icon coinIcon;
    private Icon coinsIcon;
    private Icon goldBarIcon;
    private Icon diamondIcon;
    private Icon red_s;
    private Icon red_g;
    private Icon orange_s;
    private Icon orange_g;
    private Icon yellow_s;
    private Icon yellow_g;
    private Icon green_s;
    private Icon green_g;
    private Icon blue_s;
    private Icon blue_g;
    private Icon white_s;
    private Icon white_g;
    private Icon black_s;
    private Icon black_g;
    private Icon square_s;
    private Icon square_g;
    private Icon circle_s;
    private Icon circle_g;
    
    /**
     * Enumerate all right colors and shapes after
     * under the star.
     * 
     * /
     * 
    /** Creates new form ScoreSummary */
    public ScoreSummary() {
        createImageAssets();
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
            jLabel13.setIcon(diamondIcon);
        }
        else if (this.categ == "SILVER"){
            jLabel13.setIcon(goldBarIcon);
        }
        else if(this.categ == "BRONZE"){
            jLabel13.setIcon(coinsIcon);
        }
        else{
            System.out.println("Britt");
            jLabel13.setIcon(coinIcon);
        }
        
        correctAns();
        
        this.msg.setText(greeting + ", " + username + "!"); 
        this.msg2.setText("You now have " + categ + " badge.");

        this.repaint();
        HallOfUsers.gameOver();
    }
    
    public void correctAns(){
            if (rightColors.contains("red")){
                red.setIcon(red_s);                
            }
            if (rightColors.contains("orange")){
                orange.setIcon(orange_s);
            }
            if (rightColors.contains("yellow")){
                yellow.setIcon(yellow_s);
            }
            if (rightColors.contains("green")){
                green.setIcon(green_s);
            }
            if (rightColors.contains("blue")){
                blue.setIcon(blue_s);
            }
            if (rightColors.contains("white")){
                white.setIcon(white_s);
            }
            if (rightColors.contains("black")){
                black.setIcon(black_s);
            }
            if (rightShapes.contains("circle")){
                circle.setIcon(circle_s);
            }
            if (rightShapes.contains("square")){
                square.setIcon(square_s);
            } 
    }
       
    public void clearList(){
        red.setIcon(red_g);
        orange.setIcon(orange_g);
        yellow.setIcon(yellow_g);
        green.setIcon(green_g);
        blue.setIcon(blue_g);
        black.setIcon(black_g);
        white.setIcon(white_g);
        square.setIcon(square_g);
        circle.setIcon(circle_g);
        /*
      for(int i=2; i<jPanel11.getComponentCount(); i++){
            Component label = jPanel11.getComponent(i);     
            System.out.println("CLEARING: " + label.getName());
            System.out.println(" " + label.toString());
            if(i!=9){     
                label.setFont(new java.awt.Font("Century Gothic", 0, 18));
                label.setForeground(new java.awt.Color(204, 204, 204));
            }
        }*/
    }
    public void updateControlPanel(){
        hush = Hush.getHush();                
        controlPanel = hush.getControlPanel();
        this.jPanel8.add(controlPanel);
    } 
    
    private void createImageAssets(){
        coinIcon = new javax.swing.ImageIcon(getClass().getResource("/med/coin.png"));
        coinsIcon = new javax.swing.ImageIcon(getClass().getResource("/med/coins.png"));
        goldBarIcon = new javax.swing.ImageIcon(getClass().getResource("/med/gold bars.png"));
        diamondIcon = new javax.swing.ImageIcon(getClass().getResource("/med/diamond.png"));
        red_s = new javax.swing.ImageIcon(getClass().getResource("/med/red-s.png"));
        red_g = new javax.swing.ImageIcon(getClass().getResource("/med/red-g.png"));
        orange_s = new javax.swing.ImageIcon(getClass().getResource("/med/orange-s.png"));
        orange_g = new javax.swing.ImageIcon(getClass().getResource("/med/orange-g.png"));
        yellow_s = new javax.swing.ImageIcon(getClass().getResource("/med/yellow-s.png"));
        yellow_g = new javax.swing.ImageIcon(getClass().getResource("/med/yellow-g.png"));
        green_s = new javax.swing.ImageIcon(getClass().getResource("/med/green-s.png"));
        green_g = new javax.swing.ImageIcon(getClass().getResource("/med/green-g.png"));
        blue_s = new javax.swing.ImageIcon(getClass().getResource("/med/blue-s.png"));
        blue_g = new javax.swing.ImageIcon(getClass().getResource("/med/blue-g.png"));
        white_s = new javax.swing.ImageIcon(getClass().getResource("/med/white-s.png"));
        white_g = new javax.swing.ImageIcon(getClass().getResource("/med/white-g.png"));
        black_s = new javax.swing.ImageIcon(getClass().getResource("/med/black-s.png"));
        black_g = new javax.swing.ImageIcon(getClass().getResource("/med/black-g.png"));
        square_s = new javax.swing.ImageIcon(getClass().getResource("/med/square-s.png"));
        square_g = new javax.swing.ImageIcon(getClass().getResource("/med/square-g.png"));
        circle_s = new javax.swing.ImageIcon(getClass().getResource("/med/circle-s.png"));
        circle_g = new javax.swing.ImageIcon(getClass().getResource("/med/circle-g.png"));
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

        msg.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        msg.setText(greeting + ", " + username + "!");

        msg2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        msg2.setText("You now have " + categ + " badge");

        jLabel14.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("Game Over");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(136, 136, 136))
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
                .addContainerGap(124, Short.MAX_VALUE))
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
        red.setIcon(red_g);
        jPanel11.add(red);

        orange.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        orange.setForeground(new java.awt.Color(204, 204, 204));
        orange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orange.setIcon(orange_g);
        jPanel11.add(orange);

        green.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        green.setForeground(new java.awt.Color(204, 204, 204));
        green.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        green.setIcon(green_g);
        jPanel11.add(green);

        yellow.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        yellow.setForeground(new java.awt.Color(204, 204, 204));
        yellow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yellow.setIcon(yellow_g);
        jPanel11.add(yellow);

        blue.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        blue.setForeground(new java.awt.Color(204, 204, 204));
        blue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blue.setIcon(blue_g);
        jPanel11.add(blue);

        black.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        black.setForeground(new java.awt.Color(204, 204, 204));
        black.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        black.setIcon(black_g);
        jPanel11.add(black);

        white.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        white.setForeground(new java.awt.Color(204, 204, 204));
        white.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        white.setIcon(white_g);
        jPanel11.add(white);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Shapes");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jLabel10);

        square.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        square.setForeground(new java.awt.Color(204, 204, 204));
        square.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square.setIcon(square_g);
        jPanel11.add(square);

        circle.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        circle.setForeground(new java.awt.Color(204, 204, 204));
        circle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        circle.setIcon(circle_g);
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

