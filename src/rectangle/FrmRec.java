package rectangle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class FrmRec extends JFrame {

	Stack<Rectangle> stack=new Stack<Rectangle>();
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	DefaultListModel<Rectangle> dls = new DefaultListModel<Rectangle>();
	
	ArrayList<Rectangle> arr=new ArrayList<Rectangle>();
	JList list;
	private JPanel contentPane;
	public boolean Print;
	public DefaultListModel<Rectangle> GET(){
		return dlm;	
	}
	/**
	 * Launch the application.
	 */
	public int i,b=0,n;
	public void stackPush(Rectangle R){
		stack.push(R);
	}
	public Rectangle stackPop(){
		return stack.pop();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRec frame = new FrmRec();
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
	public FrmRec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBtn = new JPanel();
		pnlBtn.setBorder(new EmptyBorder(20, 0, 0, 0));
		contentPane.add(pnlBtn, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Push");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				DlgRec dlg=new DlgRec();
				dlg.setModal(true);
				dlg.setVisible(true);
				
				if(dlg.isOk)
				{
					try {
				Rectangle R=new Rectangle(new Point(Integer.parseInt(dlg.getTxtX().getText().toString()),Integer.parseInt(dlg.getTxtY().getText().toString())),
						Integer.parseInt(dlg.getTxtW().getText().toString()),Integer.parseInt(dlg.getTxtH().getText().toString()));
				stackPush(R);
				System.out.println(R);
			
				Rectangle temp;
				
				
				temp=stack.pop();
				dlm.add(0,temp);   }
				catch(Exception e1){
					  e1.printStackTrace();
					 JOptionPane.showMessageDialog(null, "Error");
					}
				
				list.setModel(dlm);
				  
			   }
			}	
		});
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!dlm.isEmpty())
				{
					Rectangle R=dlm.get(0);
					DlgRec dlg=new DlgRec();
					dlg.setModal(true);
					dlg.getTxtX().setText(Integer.toString(R.getUpperLeft().getX()));
					dlg.getTxtY().setText(Integer.toString(R.getUpperLeft().getY()));
					dlg.getTxtH().setText(Integer.toString(R.getHeight()));
					dlg.getTxtW().setText(Integer.toString(R.getWidth()));
					dlg.getTxtH().setEditable(false);
					dlg.getTxtW().setEditable(false);
					dlg.getTxtX().setEditable(false);
					dlg.getTxtY().setEditable(false);
				
					dlg.setVisible(true);
					dlm.remove(0);
				    list.setModel(dlm);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No items selected!");
				}
			}
		});
		GroupLayout gl_pnlBtn = new GroupLayout(pnlBtn);
		gl_pnlBtn.setHorizontalGroup(
			gl_pnlBtn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBtn.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addGap(73)
					.addComponent(btnPop)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_pnlBtn.setVerticalGroup(
			gl_pnlBtn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBtn.createSequentialGroup()
					.addGroup(gl_pnlBtn.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnPop))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlBtn.setLayout(gl_pnlBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		list=new JList();
		scrollPane.setViewportView(list);
		
	}
	
}