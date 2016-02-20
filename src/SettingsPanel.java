import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class SettingsPanel extends SubMainPanel {
	
	JRadioButton createTable = new JRadioButton("Create table");
	JRadioButton dropTable = new JRadioButton("Delete table");
	ButtonGroup group = new ButtonGroup();
	JButton apply = new JButton("Apply");
	MessageArea msg = new MessageArea(2,25);
	
	public SettingsPanel() {
		
		createTable.setBackground(Color.LIGHT_GRAY);
		dropTable.setBackground(Color.LIGHT_GRAY);
		
		group.add(createTable);
		group.add(dropTable);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(createTable,gbc);
		
		gbc.gridy = 1;
		this.add(dropTable,gbc);
		
		gbc.gridy = 2;
		this.add(apply,gbc);
		
		gbc.gridy = 3;
		this.add(msg,gbc);
	
	}
	
	public boolean isCreate()
	{
		return createTable.isSelected();
	}
	
	public boolean isDelete()
	{
		return dropTable.isSelected();
	}
	
	public void setMessage(String msg)
	{
		this.msg.setText(msg);
	}
	
	public JButton getApplyButton()
	{
		return apply;
	}
}
