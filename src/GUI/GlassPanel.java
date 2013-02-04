/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * 
 * @author Coenos 2010 www.coenos.com
 *
 */
public class GlassPanel extends JPanel implements MouseMotionListener, MouseListener {

    /**
     * 
     */
    private static final long serialVersionUID = 3162577207753229521L;

    public GlassPanel() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    private Point oldPoint;
    private Point newPoint;
    private List< Line2D> lines = new ArrayList< Line2D>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(50, 50, 500, 500);

        g.setColor(Color.WHITE);
        for (Line2D line : lines) {
            g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line
                    .getX2(), (int) line.getY2());
        }
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    
        newPoint = e.getPoint();

        if (oldPoint == null) {
            oldPoint = newPoint;
        }

        lines.add(new Line2D.Double(oldPoint.getX(), oldPoint.getY(), newPoint
                .getX(), newPoint.getY()));

        oldPoint = newPoint;

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
        // set new starting Point
        oldPoint = e.getPoint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {        
        // set new starting Point
        oldPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {        
        oldPoint = null;
        newPoint = null;
    }

}