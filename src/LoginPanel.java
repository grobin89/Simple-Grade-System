import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login panel collects details to connect to database and load the main frame.
 * @author greg
 *
 */
@SuppressWarnings("serial")
public class LoginPanel extends SubMainPanel 
{
	private final String DEF_SERVER = "localhost";
	private final String DEF_DB = "ST11450512";
	private final String DEF_USER = "root";
	private final String DEF_PASS = "abc123";
	
	JLabel[] label = { new JLabel("Server:") , new JLabel("Database:") , new JLabel("User:") , new JLabel("Password:") };
	JTextField[] field = { new JTextField(15) , new JTextField(15) , new JTextField(15) };
	JPasswordField passField = new JPasswordField(15);
	JButton connButton = new JButton("Connect");
	JCheckBox defaults = new JCheckBox("load defaults");
	public MessageArea msg = new MessageArea(3,20);
	
	public LoginPanel() {
		this.setLayout(new GridBagLayout());
		
		defaults.setBackground(Color.LIGHT_GRAY);
		
		gbc.gridx = 0;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.LINE_END;
		for( int i = 0 ; i < 4 ; i++ ){ gbc.gridy = i; this.add(label[i],gbc); }
		
		gbc.gridy = 4;
		this.add(defaults,gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5,5,5,5);
		for( int i = 0 ; i < 3 ; i++ ){ gbc.gridy = i; this.add(field[i],gbc); }
		
		gbc.gridy = 3;
		this.add(passField,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;	
		this.add(connButton,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		this.add(msg,gbc);
		
		this.addListeners();
	}
	
	/**
	 * Adds all listeners to components and sub components of this panel.
	 */
	private void addListeners() {
		this.defaults.addActionListener(new LoadDefaults());
	}
	
	/**
	 * Gets the connection button. Used to make component visible to parent frame.
	 * @return connButton
	 */
	public JButton getConnectionButton() {
		return connButton;
	}
	
	/**
	 * Gets the text that is entered into the server field.
	 * @return server field text
	 */
	public String getServer() {
		return field[0].getText();
	}
	
	/**
	 * Gets the text that is entered into the database field.
	 * @return database field text
	 */
	public String getDatabase() {
		return field[1].getText();
	}
	
	/**
	 * Gets the text that is entered into the user field.
	 * @return user field text
	 */
	public String getUser() {
		return field[2].getText();
	}
	
	/**
	 * Gets the text that is entered into the password field.
	 * @return password field text
	 */
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passField.getText();
	}
	
	/**
	 * Loads the default settings into the fields
	 * @author greg
	 *
	 */
	class LoadDefaults implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			field[0].setText(DEF_SERVER);
			field[1].setText(DEF_DB);
			field[2].setText(DEF_USER);
			passField.setText(DEF_PASS);
			
		}
		
	}
	
}
