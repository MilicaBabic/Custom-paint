package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape  {
	private Point startPoint;
	private Point endPoint;

	
	public Line() {
		
	}
	public Line(Point startPoint,Point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	public Line(Point startPoint, Point endPoint,boolean selected) {
		this(startPoint,endPoint);
		this.selected=selected;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint=startPoint;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint=endPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public String toSrting() {
		return startPoint+"-->"+endPoint;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp=(Line)obj;
			if(startPoint.equals(temp.startPoint)&&endPoint.equals(temp.endPoint))
				return true;
		}
		return false;
	}
	public double lenght() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);	
	}
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y)+endPoint.distance(x, y)-lenght())<2;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY());
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getStartPoint().getX()-2,this.getStartPoint().getY()-2,4,4);
			g.drawRect(this.getEndPoint().getX()-2, this.getEndPoint().getY()-2, 4, 4);
		}
		
	}

}
