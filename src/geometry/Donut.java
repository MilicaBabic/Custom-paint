package geometry;
import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerR;
	private boolean filled;
	
	
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Donut() {
		
	}
	public Donut(Point center,int r, int innerR) {
		super(center,r);
		this.innerR=innerR;
	}
	public Donut(Point center,int r,int innerR,boolean selected) {
		this(center,r,innerR);
		this.selected=selected;
	}
	public void setInnerR(int innerR) {
		this.innerR=innerR;
	}
	public int getInnerR() {
		return innerR;
	}
	public double area() {
		return super.area()-innerR*innerR*Math.PI;
	}
	public boolean contains(int x,int y) {
		return super.contains(x, y)&& center.distance(x, y)>=innerR;
				
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	public String toString() {
		return super.toString()+",innerR= "+innerR;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(center.getX()-innerR, center.getY()-innerR, 2*innerR, 2*innerR);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX()-innerR-2, this.getCenter().getY()-2, 4, 4);
			g.drawRect(this.getCenter().getX()+innerR-2, this.getCenter().getY()-2, 4, 4);
			g.drawRect(this.getCenter().getX()-2, this.getCenter().getY()-2-innerR, 4, 4);
			g.drawRect(this.getCenter().getX()-2, this.getCenter().getY()-2+innerR, 4, 4);
		}
		
	}

}
