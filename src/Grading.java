import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main application
 * @author Greg Robinson
 *
 */
public class Grading
{
	static LoginFrame fmeLogin;
	static MainFrame fmeMain;

	public static void main(String[] args) throws ClassNotFoundException
	{
		Grading grading = new Grading();
		
		fmeLogin = new LoginFrame();
		fmeMain = new MainFrame(); 
		
		fmeLogin.getPanel().getConnectionButton().addActionListener(grading.new EnterMain());
		fmeLogin.setVisible(true);
	}
	
	/**
	 * Switches between the login frame and main frame. The database is setup.
	 * @author Greg Robinson
	 *
	 */
	class EnterMain implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
				if ( fmeMain.setDatabase( fmeLogin.getPanel().getServer() , fmeLogin.getPanel().getDatabase() , fmeLogin.getPanel().getUser() , fmeLogin.getPanel().getPassword() ) )
				{
					fmeLogin.setVisible(false);
					fmeMain.setVisible(true);
				}
				else { fmeLogin.getPanel().msg.setText("Connection failed... "); }
		}
	}
	
	
	
	
	
	
	
}
