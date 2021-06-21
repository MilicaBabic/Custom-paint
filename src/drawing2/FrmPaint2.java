package drawing2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmPaint2 extends JFrame {

	private JPanel contentPane;
	public int b;
	public boolean isOk;
	public boolean isOkL;
	public boolean isOkR;
	public boolean isOkB;
	public boolean isOkD;
	public Point drawStart;
    public ArrayList<Shape> shapes=new ArrayList<Shape>();
    public ArrayList<Point> points=new ArrayList<Point>();
    private PnlDrawing2 panel=new PnlDrawing2(this);
    
    private final JButton btnCircle = new JButton("Circle");
    private final JButton btnRectangle = new JButton("Rectangle");
    private final JButton btnDelete = new JButton("Delete");
    private final JButton btnLine = new JButton("Line");
    public Shape O,S;
    private final JButton btnModify = new JButton("Modify");
	/**
	 * Launch the application.
	 */
    public void setO(Shape O)
    {
    	this.O=O;
    }
    public Shape getO()
    {
    	return O;
    }
    public boolean getOk()
    {
    	return isOk;
    }
    public void setOk(boolean set)
    {
    	isOk=set;
    }
    public boolean getOkL()
    {
    	return isOkL;
    }
    public void setOkL(boolean set)
    {
    	isOkL=set;
    }
    public boolean getOkR()
    {
    	return isOkR;
    }
    public void setOkR(boolean set)
    {
    	isOkR=set;
    }
    public boolean getOkB()
    {
    	return isOkB;
    }
    public void setOkB(boolean set)
    {
    	isOkB=set;
    }
    public boolean getOkD()
    {
    	return isOkD;
    }
    public void setOkD(boolean set)
    {
    	isOkD=set;
    }
    public void False()
    {
    	isOk=false;
    	 isOkL=false;
    	 isOkR=false;
    	 isOkB=false;
    	 isOkD=false;
    }
    public void delete()
    {
    	if(O!=null)
    	{
    	System.out.println("Delete "+panel.getT());
    		panel.getShapes().remove(O);
        	panel.repaint();
    	}
    	else
    	{
    		
    		JOptionPane.showMessageDialog(null,"No items selected!");
    	}
       O=null;
    
    }
   
    public void modify()
    {
    	if(O!=null)
    	{
    	if (O instanceof Circle)
    	  {
    		if (O instanceof Donut)
    		{
    			DlgDonut dlgk=new DlgDonut();
    			dlgk.setModal(true);
    			Donut temp=(Donut) O;
    			dlgk.setDonutC(temp.getCenter().getX(), temp.getCenter().getY());
    			dlgk.getTxtR1().setText(Integer.toString(temp.getInnerR()));
    			dlgk.getTxtR2().setText(Integer.toString(temp.getR()));
    			dlgk.setVisible(true);
    			S=dlgk.getD();
    			panel.getShapes().remove(O);
    			panel.getShapes().add(S);
    	
    			repaint();
    		}
    		else {
    		DlgCircle dlgc=new DlgCircle();
			dlgc.setModal(true);
			Circle temp=(Circle) O;
			dlgc.setCircleC(temp.getCenter().getX(), temp.getCenter().getY());
			dlgc.getRadius().setText(Integer.toString(temp.getR()));
			dlgc.setVisible(true);
		
			S=dlgc.getCircle();
			panel.getShapes().remove(O);
			panel.getShapes().add(S);
			
			System.out.println("Circle");
			repaint();
			S=null;
    		}

    	  }
    	else if(O instanceof Rectangle)
    	  {
    		
    		DlgRectangle dlgr=new DlgRectangle();
			dlgr.setModal(true);
			Rectangle temp=(Rectangle) O;
			dlgr.setR(temp.getUpperLeft().getX(), temp.getUpperLeft().getY());
			dlgr.getW().setText(Integer.toString(temp.getWidth()));
			dlgr.getH().setText(Integer.toString(temp.getHeight()));
			
			dlgr.setVisible(true);
			
			S=dlgr.getR();
			
			panel.getShapes().remove(O);
			panel.getShapes().add(S);
	
			repaint();
    		
    		S=null;
    	   }
    	
    	else if(O instanceof Line)
    	   {
    		DlgLine dlgl=new DlgLine();
			dlgl.setModal(true);
			Line temp=(Line) O;
			dlgl.getTxtX1().setText(Integer.toString(temp.getStartPoint().getX()));
			dlgl.getTxtY1().setText(Integer.toString(temp.getStartPoint().getY()));
			dlgl.getTxtX2().setText(Integer.toString(temp.getEndPoint().getX()));
			dlgl.getTxtY2().setText(Integer.toString(temp.getEndPoint().getY()));
			dlgl.setVisible(true);
			if(dlgl.isOk) {
			S=dlgl.getL();
			
			panel.getShapes().remove(O);
			panel.getShapes().add(S);
	
			repaint();
			}
				
			}
    	else if(O instanceof Point)
		{
			DlgPoint dlgp=new DlgPoint();
			dlgp.setModal(true);
			Point tem=(Point) O;
			dlgp.getTxtX().setText(Integer.toString(tem.getX()));
			dlgp.getTxtY().setText(Integer.toString(tem.getY()));
			dlgp.setVisible(true);
			if(dlgp.isOk)
			{
				S=dlgp.getP();
				panel.getShapes().remove(O);
				panel.getShapes().add(S);
				repaint();
			}
			
    	   }
    	}
    	else 
    	{
    		JOptionPane.showMessageDialog(null,"No items selected!");	
    	}
    	
    	O=null;
    	
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPaint2 frame = new FrmPaint2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public FrmPaint2() {	
		initialize();	
	}
	
	public void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isOkB=true;	
			}
		});
		
		contentPane.add(panel,BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		buttons.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(buttons, BorderLayout.SOUTH);
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();
				isOkD=true;
			}
		});
		GroupLayout gl_buttons = new GroupLayout(buttons);
		gl_buttons.setHorizontalGroup(
			gl_buttons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttons.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDonut)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addContainerGap())
		);
		gl_buttons.setVerticalGroup(
			gl_buttons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttons.createSequentialGroup()
					.addGroup(gl_buttons.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCircle)
						.addComponent(btnDelete)
						.addComponent(btnRectangle)
						.addComponent(btnDonut)
						.addComponent(btnLine)
						.addComponent(btnModify))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttons.setLayout(gl_buttons);
		
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();
				isOk=true;
				
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();
				isOkR=true;
				
			}
		});
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();
				modify();
			}
		});
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();
				isOkL=true;
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				False();				
				delete();
			}
		});
}
}
