package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 0, 0, 0));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlg=new DlgSort();
				dlg.setModal(true);
				
				dlg.setVisible(true);
				try {
					if (dlg.isOk=true) {
					Rectangle temp=new Rectangle(new Point(Integer.parseInt(dlg.getTxtX().getText().toString()),Integer.parseInt(dlg.getTxtY().getText().toString())),
							Integer.parseInt(dlg.getTxtW().getText().toString()),Integer.parseInt(dlg.getTxtH().getText().toString()));
			
				
					dlm.addElement(temp);
					    }
					}
					catch(Exception e1){
						  e1.printStackTrace();
						 JOptionPane.showMessageDialog(null, "Error");
						}
				
				
			}
		});
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=dlm.getSize();
				Rectangle P=new Rectangle();
				Rectangle temp;
				for(int i=0;i<n-1;i++) {
					//P=dlm.get(i);
					for(int j=i+1;j<n;j++) {
						if(((dlm.get(j).getHeight())*(dlm.get(j).getWidth()))<((dlm.get(i).getHeight())*(dlm.get(i).getWidth())))
								{
									temp=dlm.get(j);
									dlm.set(j, dlm.get(i));
									dlm.set(i,temp);
						
								}
					}
				
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSort)
					.addContainerGap(264, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnSort)))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
          
		list=new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}

}