import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SubMainPanel extends JPanel {
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public SubMainPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new GridBagLayout());
	}
	
}