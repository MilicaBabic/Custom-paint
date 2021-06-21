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

import geometry.Point;
import geometry.Rectangle;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	boolean isOk;
	private Rectangle R=new Rectangle();
	private JTextField txtWidth;
	private JTextField txtHeight;
	public Color color=Color.black;
	public Color colorInside=null;
	private int height,width;
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) throws Exception {
		if(height<0) {
			throw new Exception();
		}
		else
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) throws Exception{
		if(width<0) {
			throw new Exception();
		}
		else
		this.width = width;
	}
	public void setR(int x,int y) {
		R.setUpperLeft(new Point(x,y));
	}
	public JTextField getW() {
		return txtWidth;
	}
	public JTextField getH() {
		return txtHeight;
	}
	public Rectangle getR() {
		return R;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblWidth = new JLabel("Width:");
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		JLabel lblHeight = new JLabel("Height:");
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		
		JButton btnLineColor = new JButton("Line color");
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color=JColorChooser.showDialog(null, "Color", color);
			}
		});
		
		JButton btnColorInside = new JButton("Color inside");
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
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnLineColor)
							.addGap(30)
							.addComponent(btnColorInside)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(checkBox))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblHeight)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWidth)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(40)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblWidth)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHeight)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLineColor)
							.addComponent(btnColorInside)
							.addComponent(checkBox))
						.addContainerGap(62, Short.MAX_VALUE))
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
						if(getW().getText().trim().isEmpty()&&getH().getText().trim().isEmpty())
						{
							isOk=false;
							JOptionPane.showMessageDialog(null, "Fields not filled!");
						}
						else
						{
							try {
								
							setWidth(Integer.parseInt(getW().getText().toString()));
							setHeight(Integer.parseInt(getH().getText().toString()));
							
							R.setHeight(height);
							R.setWidth(width);
							R.setColor(color);
							if(colorInside!=null)
							{
								R.setFilled(true);
								R.setColorInside(colorInside);
							}
							isOk=true;
							setVisible(false);
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
								JOptionPane.showMessageDialog(null, "Number below 0!");
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
	