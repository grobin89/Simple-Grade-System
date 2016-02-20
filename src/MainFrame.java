import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	
	private Database db;
	
	private Dimension dim = new Dimension(800,600);
	private MenuList menu = new MenuList();
	private MainPanel main = new MainPanel();
	private SearchPanel search = new SearchPanel();
	private InsertPanel insert = new InsertPanel();
	private SettingsPanel settings = new SettingsPanel();
	private OverviewPanel overview = new OverviewPanel();
	
	@SuppressWarnings("deprecation")
	public MainFrame() throws ClassNotFoundException {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(dim);
		this.setLocationRelativeTo(null);
		
		this.db = new Database();

		this.addPanels();
		this.hideAll();
		this.insert.show();
		this.addListeners();
		
		this.add(main, BorderLayout.CENTER);
		this.add(menu, BorderLayout.WEST);
		
	}
	
	private void addListeners() {
		this.menu.addListSelectionListener(new SelectPanel());
		this.insert.getInsertButton().addActionListener(new InsertRecord());
		this.search.getSearchButton().addActionListener(new SearchRecord());
		this.settings.getApplyButton().addActionListener(new ApplySettings());
	}
	
	private void addPanels() {
		main.add(search);
		main.add(insert);
		main.add(settings);
		main.add(overview);
	}
	
	@SuppressWarnings("deprecation")
	private void hideAll() {
		insert.hide();
		search.hide();
		settings.hide();
		overview.hide();
	}
	
	
	
	
	
	public boolean setDatabase(String server,String database,String user,String password)
	{		
		if(server == null || server == "") return false;
		if(database == null || database == "") return false;
		if(user == null || user == "") return false;
		if(password == null || password == "") return false;
		
		db.setAddress(server, database);
		db.setLogin(user, password);
		return db.connect();
	}
	
	/**
	 * A listener to action inserting a record
	 * @author Greg
	 *
	 */
	class InsertRecord implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(db.exec(insert.getFields())) insert.addMessage("Record inserted...");
			else insert.addMessage("Record insert failed...");
		}
	}
	
	/**
	 * A listener to action searching records in the database.
	 * @author Greg
	 *
	 */
	class SearchRecord implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = "";
			if(db.query(search.getSearch()))
			{
				try
				{
					while(db.rs.next())
					{
						msg += "Name\t\t" + db.rs.getString(2) + "\n";
						msg += "Assignment 1\t\t" + db.rs.getString(3) + "\n";
						msg += "Assignment 2\t\t" + db.rs.getString(4) + "\n";
						msg += "Assignment 3\t\t" + db.rs.getString(5) + "\n";
						msg += "Final Exam\t\t" + db.rs.getString(6)+ "\n";
						
						double finalScore = ( 0.1 * db.rs.getInt(3) ) + ( 0.2 * db.rs.getInt(4) ) + ( 0.2 * db.rs.getInt(5) ) + ( 0.5 * db.rs.getInt(6) );
						
						msg += "Final Score\t\t" + finalScore;
					}
				}
				catch (SQLException e1) { msg = "Issue with result set..."; e1.printStackTrace(); }
			}
			else msg = "Search failed...";
			search.setResults(msg);
		}	
	}
	
	/**
	 * A listener for interchange panels
	 * @author Greg
	 *
	 */
	class SelectPanel implements ListSelectionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int index = menu.getSelectedIndex();
			hideAll();
			switch (index)
			{
				case MenuList.INSERT:
					insert.show();
					break;
				
				case MenuList.SEARCH:
					search.show();
					break;
					
				case MenuList.SETTINGS:
					settings.show();
					break;
					
				case MenuList.OVERVIEW:
					overview.setMessage(getTable());
					overview.show();
					break;
				
				default:
					insert.show();
					break;
					
			}
			main.repaint();
		}
	}
	
	class ApplySettings implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(settings.isCreate())
			{
				if(db.create()) settings.setMessage("Table created...");
				else settings.setMessage("Table already exists...");
			}
			if(settings.isDelete())
			{
				if(db.drop()) settings.setMessage("Table deleted...");
				else settings.setMessage("There is no table to delete...");
			}
		}
	}
	
	private String getTable()
	{
		String msg = "Name\tAssignment 1\tAssignment 2\tAssignment 3\tFinal Exam\n";
		
		if(db.allRecords())
		{
			try
			{
				while(db.rs.next())
				{
					for(int i = 2 ; i < 7 ; i++) { msg += db.rs.getString(i) + "\t"; }
					msg += "\n";
				}
				return msg;
			}
			catch (SQLException e) {  e.printStackTrace(); return "Failed to retrieve records..."; }
		}
		else return "Failed to retrieve records...";
	}
}
