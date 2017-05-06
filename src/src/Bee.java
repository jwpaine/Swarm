package src;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bee {

	double x;
	double y;
	double r;
	public Color color;
	
	public Bee(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		color = Color.WHITE;
	}
	
	/* we use parematric equations for assigning (x,y) positional coordinate on a circle with rotation alpha, radius, and current position as the origin */
	public void move(double radius, double theta) {
		
		/* for current position x, y, new position for rotation theta in degrees and rarius r, will be x + r*cos(alhpa) where alpha = theta*PI / 180 */
	this.setX(this.getX() + radius*Math.cos(theta*Math.PI / 180));
	this.setY(this.getY() + radius*Math.sin(theta*Math.PI / 180));
		
		
		
		
		
		
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getRadius() {
		return r;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
}
