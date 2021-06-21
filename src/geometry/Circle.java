package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	protected Point center;
	protected int r;
	private boolean filled;
	
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Circle() {
		
	}
	public Circle(Point center,int r) {
		this.center=center;
		this.r=r;
	}
	public Circle(Point center, int r,boolean selected) {
		this(center,r);
		this.selected=selected;
	}
	public String toString() {
		return "Center:"+center+"r"+r;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp=(Circle)obj;
			return center.equals(temp.center)&& temp.r==this.r;
		}
		return false;
	}
	public boolean contains(int x,int y) {
		return center.distance(x,y)<=r;
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(),p.getY());
	}
	public void setCenter(Point center) {
		this.center=center;
	}
	public Point getCenter() {
		return center;
	}
	public void setR(int r) throws Exception{
		if(r<0) {
			throw new Exception ("Radijus ne moze biti manji od nule!");
		}
		this.r=r;
	}
	public int getR() {
		return r;
	}
	public double area() {
		return r*r*Math.PI;
	}
	public double volume(){
		return 2*r*Math.PI;
	}
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r+r);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(center.getX()-r-2,center.getY()-2,4,4);
			g.drawRect(center.getX()+r-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()+2, center.getY()-r-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY()+r-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY()-2, 4, 4);
		}
		
	}
	
	


}
