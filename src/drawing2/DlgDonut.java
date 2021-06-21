package drawing2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import geometry.Donut;
import geometry.Point;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtR1,txtR2;
	private int r1,r2;
	private Donut D=new Donut();
	public Color color=Color.BLACK;
	public Color colorInside=null;
	protected boolean isOk;
	public void setDonutC(int x,int y) {
		D.setCenter(new Point(x,y));
	}
	public Donut getD() {
		return D;
	}
	public JTextField getTxtR1() {
		return txtR1;
	}
	public void setTxtR1(JTextField txtR1) {
		this.txtR1=txtR1;	
	}
	public JTextField getTxtR2() {
		return txtR2;
	}

	public void setTxtR2(JTextField txtR2) {
		this.txtR2 = txtR2;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtR1 = new JTextField();
		txtR1.setColumns(10);
		
		txtR2 = new JTextField();
		txtR2.setColumns(10);
		
		JLabel lblRadius1 = new JLabel("Inner radius:");
		
		JLabel lblRadius2 = new JLabel("Radius :");
		
		JButton btnColor = new JButton("Line color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color=JColorChooser.showDialog(null, "Color", color);
			}
		});
		
		JButton btnColorInside = new JButton("Donut color");
		btnColorInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorInside=JColorChooser.showDialog(null, "Color", color);
			}
		});
		
		btnColorInside.setEnabled(false);
		JCheckBox checkBox = new JCheckBox("");
		checkBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				btnColorInside.setEnabled(checkBox.isSelected());
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRadius1)
								.addComponent(lblRadius2))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtR2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtR1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(btnColor)
							.addGap(36)
							.addComponent(btnColorInside)
							.addGap(18)
							.addComponent(checkBox)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(28)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtR1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRadius1))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtR2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRadius2))
						.addGap(42)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnColor)
							.addComponent(btnColorInside)
							.addComponent(checkBox))
						.addContainerGap(68, Short.MAX_VALUE))
			);
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(getTxtR1().getText().trim().isEmpty() || getTxtR2().getText().trim().isEmpty())
						{
							isOk=false;
							JOptionPane.showMessageDialog(null,"Fields not filled");
						}
						else
						{
							r1=Integer.parseInt(getTxtR1().getText().toString());
							r2=Integer.parseInt(getTxtR2().getText().toString());
							if(r1<r2) {
							D.setInnerR(r1);
							try {
								D.setR(r2);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
							D.setColor(color);
							
							if(colorInside!=null)
							{
								D.setFilled(true);
								D.setColorInside(colorInside);
							}
							setVisible(false);
							isOk=true;
							}
					  else
						{
								JOptionPane.showMessageDialog(null,"Inner radius can not be bigger!");
								dispose();
						}
					  }
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
