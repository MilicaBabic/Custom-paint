package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	
	public Point() {
		
	}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public Point(int x,int y,boolean selected) {
		this(x,y);
		this.selected=selected;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp=(Point)obj;//eksplicitno kastovanje(downcast)
			if(x==temp.x && y==temp.y)
				return true;
		}
		return false;
	}
	public boolean contains(int x,int y) {
		return this.distance(x, y)<=2;//tolerancija 2 piksela
	}

	public double distance(int x,int y) {
		int dx=this.x-x;
		int dy=this.y-y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	@Override
	public void moveBy(int byX, int byY) {
		this.x=this.x+byX;
		this.y=this.y+byY;
		
	}
	@Override
	public void moveTo(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(x-2,y,x+2,y);//crtanje 2 linije duzine 2 piksela koje prave x 
		g.drawLine(x, y+2, x, y-2);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(x-2, y-2, 4, 4);
		}
		
	}

}
