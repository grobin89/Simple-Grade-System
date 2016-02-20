import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class MessageArea extends JTextArea {
	
	public MessageArea() {
		super();
		this.setEditable(false);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
	}
	
	public MessageArea(int c,int r) {
		super(c,r);
		this.setEditable(false);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
	}
	
}
