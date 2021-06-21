package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable{
	protected boolean selected;
	protected Color color;
	private Color colorInside;
	
	public Color getColorInside() {
		return colorInside;
	}
	public void setColorInside(Color colorInside) {
		this.colorInside = colorInside;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Shape() {
		
	}
	public Shape(boolean selected) {
		this.selected=selected;
	}
	public abstract boolean contains(int x,int y);
	public abstract void draw(Graphics g);
	
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	public boolean isSelected() {
		return this.selected;
	}

}
