import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Holds all the components that are used to insert a record into the database.
 * @author Greg Robinson
 *
 */
@SuppressWarnings("serial")
public class InsertPanel extends SubMainPanel
{
	JLabel[] label = { new JLabel("ID:"), new JLabel("Name:"), new JLabel("Assignment 1:"), new JLabel("Assignment 2:"), new JLabel("Assignment 3:"), new JLabel("Final Exam:") };
	JTextField[] field = { new JTextField(10), new JTextField(10), new JTextField(10), new JTextField(10), new JTextField(10), new JTextField(10) };
	JButton insertButton = new JButton("Insert");
	JButton clearButton = new JButton("Clear");
	MessageArea msg = new MessageArea(2,30);
	
	public InsertPanel()
	{
		gbc.gridx = 0;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.LINE_END;
		for( int i = 0 ; i < 6 ; i++ ){ gbc.gridy = i; this.add(label[i],gbc); }
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5,5,5,5);
		for( int i = 0 ; i < 6 ; i++ ){ gbc.gridy = i; this.add(field[i],gbc); }
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		this.add(clearButton,gbc);
		
		gbc.gridx = 2;
		this.add(insertButton,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		this.add(msg,gbc);
		
		this.addListeners();
	}
	
	/**
	 * Adds listeners to components and/or sub components of this panel.
	 */
	private void addListeners()
	{
		this.clearButton.addActionListener(new ClearFields());
	}
	
	/**
	 * Gets all fields except password.
	 * @return
	 * A set of fields
	 */
	public JTextField[] getFields()
	{
		return this.field;
	}
	
	/**
	 * 
	 * @return
	 */
	public JButton getInsertButton()
	{
		return this.insertButton;
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void addMessage(String msg)
	{
		this.msg.setText(msg);
	}
	
	class ClearFields implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e){
			for(int i = 0 ; i < 6 ; i ++)
			{
				field[i].setText("");
			}
			msg.setText("Form cleared...");
		}
	}
	
}
