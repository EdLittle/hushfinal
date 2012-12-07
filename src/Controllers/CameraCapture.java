/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author FREAK
 */

import GUI.ImagePanel;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Calendar;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JButton;
import javax.swing.JComponent;

public class CameraCapture extends Panel implements ActionListener{
    public static Player player=null;
    public CaptureDeviceInfo di=null;
    public MediaLocator ml=null;
    public JButton capture=null;
    public Buffer buf=null;
    public Image img=null;
    public VideoFormat vf=null;
    public BufferToImage btoi=null;
    public ImagePanel imgpanel=null;
    public int capturenumber=0;

    public CameraCapture(){
        setLayout(new BorderLayout());
        setSize(320,550);
        //imgpanel=new ImagePanel();
        //capture= new JButton("Capture");
        //capture.addActionListener(this);
        String str = "vfw:Microsoft WDM Image Capture (Win32):0";
        //System.out.println("Together Alone");
        di=CaptureDeviceManager.getDevice(str);
        ml = new MediaLocator(str);
        Graphics g;
        
        //System.out.println("Together Alone");
        try{
            player = Manager.createRealizedPlayer(ml);
            player.start();
            Component comp;
            if((comp = player.getVisualComponent())!=null){
                add(comp,BorderLayout.NORTH);
            }
            
            //add(capture,BorderLayout.CENTER);
            //add(imgpanel,BorderLayout.SOUTH);
        }
        catch(Exception ex){
            //System.out.println("Together Alone3");
            ex.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        Frame f=new Frame("Take picture");
        System.out.println("Happy Valentine's");
        CameraCapture cf = new CameraCapture();
        System.out.println("Together Alone");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                playerclose();
                System.exit(0);
            }
        });
        f.add(cf);
        f.pack();
        f.setSize(320, 550);
        f.setVisible(true);
    }
    * 
    */

    public static void playerclose(){
        player.close();
        player.deallocate();
    }

    public void actionPerformed(ActionEvent e) {
        JComponent c = (JComponent) e.getSource();
        if(c==capture){
            FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
            buf = fgc.grabFrame();
            btoi= new BufferToImage((VideoFormat)buf.getFormat());
            img = btoi.createImage(buf);
            imgpanel.setImage((BufferedImage)img);
            Calendar cal= Calendar.getInstance();
            @SuppressWarnings("static-access")
            int data = (cal.getTime().getYear()+1900)*10000+ (cal.getTime().getMonth()+1)*100+cal.getTime().getDate();
            saveJPG(img,"D:\\"+ data +capturenumber+".jpg");
            capturenumber++;
        }
    }
    
    public BufferedImage grabImage(){
        FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
        buf = fgc.grabFrame();
        btoi= new BufferToImage((VideoFormat)buf.getFormat());
        img = btoi.createImage(buf);
        BufferedImage bf = (BufferedImage)img;
        bf = bf.getSubimage(80, 80, 350, 200);
        return bf;
    }

    private void saveJPG(Image img, String s) {
        BufferedImage bi= new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=bi.createGraphics();
        g2.drawImage(img, null, null);
        FileOutputStream out=null;
        try{
            out = new FileOutputStream(s);
        }
        catch(java.io.FileNotFoundException ex){
            ex.printStackTrace();
        }
        JPEGImageEncoder encoder= JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param= encoder.getDefaultJPEGEncodeParam(bi);
        param.setQuality(0.5f, false);
        encoder.setJPEGEncodeParam(param);
        try{
            encoder.encode(bi);
            out.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Saving the image");
    }

}

