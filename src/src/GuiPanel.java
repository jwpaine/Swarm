package src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;

import javax.swing.JPanel;

public class GuiPanel extends JPanel {

	private Field plane;
	
	public GuiPanel(Field p) {
		// TODO Auto-generated constructor stub
		plane = p;
		
	}
	
	public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        /* for each object on the plane, draw it */
        for (int i = 0; i < plane.getObjects().size(); i++) {
        	Bee s = plane.getObjects().get(i);
        	g2.setColor(s.color);
        	g2.fillOval((int) s.getX(), (int) s.getY(), (int) s.getRadius(), (int) s.getRadius());
        }
        
       super.repaint();
       
     }

}
