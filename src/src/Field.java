package src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Field extends JFrame {
  
	private ArrayList<Bee> swarm;
	private Random rand;
	private Timer timer;
	private JFrame jf;
    private JPanel jp;
    
    private boolean mousePress;
    private int mouseX;
    private int mouseY;
     
    public Field() throws InterruptedException {
    	  
        jf = new JFrame();
        jp = new GuiPanel(this);
        jp.setBackground(Color.black);
        jp.setPreferredSize(new Dimension(500,500));// changed it to preferredSize, Thanks!
        jf.getContentPane().add( jp );// adding to content pane will work here. Please read the comment bellow.
        jf.pack();
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible( true );
        
        swarm = new ArrayList();
        timer = new Timer();
        mousePress = false;
    }
    
    public void addSphere(Bee s) {
    	swarm.add(s);
    }
    
    public void run() throws InterruptedException {
    	
    	 /* setup mouse listener for click/release events */
        jp.addMouseListener(new MouseAdapter() {// provides empty implementation of all
           
			public void mousePressed(MouseEvent e) {
        	//	System.out.println(e.getX() + "," + e.getY());
				mousePress = true;
				mouseX = e.getX();
				mouseY = e.getY();
        	}
        	
        	public void mouseReleased(MouseEvent e) {
        		System.out.println("Released" + e.getX() + "," + e.getY());
        		mousePress = false;
        	}
        	
		});
    	
    	TimerTask task = new TimerTask()
    	{
    	     public void run() {
    	    	 
    	    	
    	    	/* for each sphere, call move with radius 10 and a random rotation less than 40 degrees */
    	    	 for (int i = 0; i < swarm.size(); i++) {
    	    		 
    	    		 if (mousePress) {
    	    			 
    	    			 /* get mouse coordinates, and angle from each bee to mouse coordinates */
    	    			 double delta_x = mouseX - swarm.get(i).getX();
    	    			 double delta_y = mouseY - swarm.get(i).getY();
    	    			 double theta = Math.atan2(delta_y, delta_x)*180/Math.PI;
    	    			 
    	    			 /* speed of bee dependent on distance */
    	    			 double distance = Math.sqrt(Math.pow(delta_x - swarm.get(i).getX(), 2) + Math.pow(delta_y - swarm.get(i).getY(), 2) );
    	    			 swarm.get(i).move(0.001*distance, ThreadLocalRandom.current().nextInt((int)theta-90, (int)theta+90));
    	    			 
    	    			 swarm.get(i).move(0.75, ThreadLocalRandom.current().nextInt(0, 360));
    	    		 } else {
    	    			 swarm.get(i).move(0.5, ThreadLocalRandom.current().nextInt(0, 360));
    	    		 }
    	    		 
    	    	 }
    	    	 Bee s2 = new Bee(250,250,2);  // x,y,r
    	    	 if (swarm.size() < 500)  swarm.add(s2);
    	     }
    	};
    	
    	timer.scheduleAtFixedRate(task, 100, 1);
    	
    }
    
	public ArrayList<Bee> getObjects() {
		return swarm;
	}
    
    
   
}