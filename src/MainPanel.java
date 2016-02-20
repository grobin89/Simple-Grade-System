import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * A container for other sub main panels.
 * @author Greg Robinson
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	public MainPanel()
	{
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
	}
}
