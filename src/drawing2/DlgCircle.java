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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import geometry.Circle;
import geometry.Point;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField radius;
	public boolean isOk;
	public boolean has;
	protected int rad;
	public Color color=Color.black;
	public Color colorInside=null;
	private Circle c=new Circle();
	
	public Color getColor() {
		return color;
	}
	public void setCircleC(int x,int y) {
		c.setCenter(new Point(x,y));
	}
	public Circle getCircle() {
		return c;
	}
	public JTextField getRadius() {
		return radius;
	}
	public boolean getIsOk() {
		return isOk;
	}
	public int getRad() {
		return rad;
	}
	public void setRad(int rad) {
		this.rad = rad;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblRadius=new JLabel("Radius");
		radius=new JTextField();
		radius.setColumns(10);
		
		JButton btnLineColor=new JButton("Line colour : ");
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color=JColorChooser.showDialog(null, "Color:", color);
			}
		});
		
		JButton btnColorInside = new JButton("Color inside");
		btnColorInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				colorInside =JColorChooser.showDialog(null, "Boja?", color);
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
							.addContainerGap()
							.addComponent(lblRadius)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(btnLineColor)
							.addGap(56)
							.addComponent(btnColorInside)
							.addGap(18)
							.addComponent(checkBox)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(86)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblRadius)
							.addComponent(radius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(31)
								.addComponent(btnLineColor))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(32)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnColorInside)
									.addComponent(checkBox))))
						.addContainerGap(58, Short.MAX_VALUE))
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
						if(getRadius().getText().trim().isEmpty())
						{
							isOk=false;
							JOptionPane.showMessageDialog(null,"Nije popunjeno nista");
						}
						else
						{
							
							rad=Integer.parseInt(getRadius().getText().toString());
							try {
								c.setR(rad);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							c.setColor(color);
							if(colorInside!=null)
							{
								c.setFilled(true);
								c.setColorInside(colorInside);
							}
							isOk=true;
							
							setVisible(false);
							
							
							
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
	
		 
	

