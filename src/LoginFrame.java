
import javax.swing.JFrame;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	private LoginPanel plogin = new LoginPanel();
	
	public LoginFrame() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		
		this.add(plogin);
	}
	
	public LoginPanel getPanel() {
		return plogin;
	}
}
