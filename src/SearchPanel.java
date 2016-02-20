import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SearchPanel extends SubMainPanel {
	JTextField searchField = new JTextField(30);
	JButton searchButton = new JButton("search");
	MessageArea searchArea = new MessageArea(6,30);
	
	public SearchPanel() {
		
		this.searchArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		this.searchField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(searchField,gbc);
		
		gbc.gridx = 1;
		this.add(searchButton,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(searchArea,gbc);
		
	}
	
	public String getSearch() {
		return searchField.getText();
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	
	public void setResults(String msg) {
		searchArea.setText(msg);
	}
	
}
