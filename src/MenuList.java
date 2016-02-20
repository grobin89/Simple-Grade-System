import java.awt.Color;

import javax.swing.JList;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class MenuList extends JList<String> {
	public final static int INSERT = 0;
	public final static int SEARCH = 1;
	public final static int OVERVIEW = 2;
	public final static int SETTINGS = 3;
	
	private static String[] menuLabels = {"Insert","Search","Overview","Settings"};
	
	public MenuList() {
		super(menuLabels);
		
		this.setSelectedIndex(INSERT);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setSelectionBackground(Color.LIGHT_GRAY);
		this.setSelectionForeground(Color.DARK_GRAY);
		this.setFixedCellWidth(150);
		this.setFixedCellHeight(20);
	}
}
