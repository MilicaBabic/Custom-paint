package drawing2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;

import geometry.Line;
import geometry.Point;
import geometry.Shape;

public class PnlDrawing2 extends JPanel{
	public ArrayList<Shape> shapes=new ArrayList<Shape>();
	public ArrayList<Point> points=new ArrayList<Point>();
	public ArrayList<Color> colors=new ArrayList<Color>();
	public Color color1,color2;
	private FrmPaint2 frame;
	
	public JTextField text;
	public Shape S,E,T;
	public int i=-1;
	boolean del,sel,Lin,mmm;
	public Point P,K;
	
	public ArrayList<Shape> getShapes(){
		return this.shapes;
	}
	public int getI(){
		return i;
	}
	public Shape getT(){
		return T;
	}
	public void setI(int i){
		this.i=i;
	}
	
	public PnlDrawing2(FrmPaint2 frame) {
		setBackground(Color.WHITE);
		this.frame=frame;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				S=null;
				if(frame.getOk())
				{
					DlgCircle dlgc=new DlgCircle();
					dlgc.setModal(true);
					dlgc.setCircleC(e.getX(),e.getY());
					dlgc.setVisible(true);
				  if(dlgc.isOk) {
					  
					S=dlgc.getCircle();
					
					shapes.add(S);
					repaint();
				  }
				  frame.setOk(false);
				}
				else if(frame.getOkR())
				{
					DlgRectangle dlgr=new DlgRectangle();
					dlgr.setModal(true);
					dlgr.setR(e.getX(), e.getY());
					dlgr.setVisible(true);
					if(dlgr.isOk) {
					S=dlgr.getR();
					shapes.add(S);
					i++;
					repaint();
					}
					frame.setOkR(false);
				}
				else if(frame.getOkL())
				{
					
					Lin=true;
					P=new Point(e.getX(),e.getY());
					points.add(0,P);
					repaint();
					frame.setOkL(false);
				}
				else if(frame.getOkD())
				{
					DlgDonut dlgd=new DlgDonut();
					dlgd.setModal(true);
					dlgd.setDonutC(e.getX(), e.getY());
					dlgd.setVisible(true);
					if(dlgd.isOk){
						S=dlgd.getD();
						shapes.add(S);
					}
					repaint();
					frame.setOkD(false);	
				}
				else 
				{
					if (Lin==false) {	
					Iterator<Shape> it=shapes.iterator();
					while (it.hasNext())
					{
						 T=it.next();
						 T.setSelected(false);
						 if(T.contains(e.getX(), e.getY()))
						{	
							T.setSelected(true);
							System.out.println(T);
							frame.setO(T);
							sel=true;
						}
						repaint();
					 }
					} 
					if(sel==false )
					{
						P=new Point(e.getX(),e.getY());
						if(Lin)
						 {
							Point temp=points.get(0);
							Line L=new Line(temp,P);
							shapes.add(L);
							repaint();
						}
						else
						{
							shapes.add(P);
						}
							i++;
							repaint();
							T=null;
							frame.setO(T);
					 }
					Lin=false;
					repaint();
					sel=false;
					frame.setOkB(false);
					}
			  }	
		});

	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Iterator<Shape> it=shapes.iterator();
		while(it.hasNext())
		{
			Shape temp=it.next();
			 temp.draw(g);
		}
	}

}
