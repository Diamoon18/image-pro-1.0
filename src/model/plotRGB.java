package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.imagesLoad;

public class plotRGB extends JFrame {
	
	private int [] red   = new int[256];
	private int [] green = new int[256];
	private int [] blue  = new int[256];
	
	public plotRGB(int[] red, int[] green, int[] blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void drawPlot() {
		JPanel jcp = new JPanel(new BorderLayout());
	    setContentPane(jcp);
	    setTitle("RGB graph");
	    setIconImage(imagesLoad.icon.getImage());
	    jcp.add(new DrawingComponent(red, green, blue), BorderLayout.CENTER);     
	    setSize(1500, 1500);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
}

class DrawingComponent extends JPanel {
	
	private int [] red   = new int[256];
	private int [] green = new int[256];
	private int [] blue  = new int[256];
	
	public DrawingComponent(int[] red, int[] green, int[] blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
    @Override
    protected void paintComponent(Graphics gh) {       
    	
      Graphics2D drp = (Graphics2D)gh;
      drp.setColor(Color.black);
      drp.fillRect(0, 0, 1500, 1500);
      
      drp.setColor(Color.white);
      drp.drawLine(0, 0, 300, 0);
      drp.drawLine(0, 0, 0, 1500);
      for(int i = 0; i < red.length; i++) {
    	  drp.setColor(Color.red);
    	  drp.drawLine(0+i, 0, 0+i, red[i]);
      }
      
      drp.setColor(Color.white);
      drp.drawLine(320, 0, 620, 0);
      drp.drawLine(320, 0, 320, 1500);
      for(int i = 0; i < green.length; i++) {
    	  drp.setColor(Color.green);
    	  drp.drawLine(320+i, 0, 320+i, green[i]);
      }
      
      drp.setColor(Color.white);
      drp.drawLine(630, 0, 930, 0);
      drp.drawLine(630, 0, 630, 1500);
      for(int i = 0; i < blue.length; i++) {
    	  drp.setColor(Color.blue);
    	  drp.drawLine(630+i, 0, 630+i, blue[i]);
      }
    }
}