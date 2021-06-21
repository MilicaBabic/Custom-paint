package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape{
	private Point upperLeft;
	private int width;
	private int height;
	private boolean filled;
	private Color colorInside;
	
	
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Color getColorInside() {
		return colorInside;
	}
	public void setColorInside(Color colorInside) {
		this.colorInside = colorInside;
	}
	public Rectangle() {
		
	}
	public Rectangle(Point upperLeft,int width,int height) {
		this.upperLeft=upperLeft;
		this.width=width;
		this.height=height;
	}
	public Rectangle(Point upperLeft,int width,int height,boolean selected) {
		this(upperLeft,width,height);
		this.selected=selected;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft=upperLeft;
	}
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return height;
	}
	public String toString() {
		return "Upper left point:"+upperLeft+" Width:"+width+" Heigth:"+height;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp=(Rectangle)obj;
			if(upperLeft.equals(temp.upperLeft)&& width==temp.width && height==temp.height)
				return true;
		}
		return false;
	}
	public boolean contains(int x,int y) {
		return (upperLeft.getX()<x && x<(upperLeft.getX()+width) && upperLeft.getY()<y && y<(upperLeft.getY()+height));
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	public int area() {
		return width*height;
	}
	public int volume () {
		return 2*height+2*width;
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);	
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);	
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeft.getX()-2, upperLeft.getY()-2, 4, 4);
			g.drawRect(upperLeft.getX()+width-2, upperLeft.getY()-2, 4, 4);
			g.drawRect(upperLeft.getX()-2, upperLeft.getY()+height-2, 4, 4);
			g.drawRect(upperLeft.getX()+width-2,upperLeft.getY()+height-2,4,4);
			
		}
		
	}
	

}
