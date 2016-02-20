
@SuppressWarnings("serial")
public class OverviewPanel extends SubMainPanel {

	private MessageArea msg = new MessageArea(30,30);
	
	public OverviewPanel()
	{
		this.add(msg,gbc);
	}
	
	public void setMessage(String msg)
	{
		this.msg.setText(msg);
	}
}
