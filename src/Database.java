import java.sql.*;

import javax.swing.JTextField;

public class Database {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String SQLCMD_CTABLE = "create table ITC313 (id char(3),name varchar(32),score1 integer,score2 integer,score3 integer,score4 integer,primary key (id));";
	private final String SQLCMD_DTABLE = "drop table ITC313;";
	private final String SQLCMD_GTABLE = "select * from ITC313";
	
	private Connection con;
	private Statement stm;
	public ResultSet rs;
	private String address;
	private String user;
	private String password;
	
	public Database() {
		try { Class.forName(DRIVER); }
		catch (ClassNotFoundException e){ System.out.println("JDBC driver is missing. Exiting..."); System.exit(0); }
	}
	
	public Database(String address,String user,String password)
	{
		try { Class.forName(DRIVER); }
		catch (ClassNotFoundException e){ System.out.println("JDBC driver is missing. Exiting..."); System.exit(0); }
		
		this.address = address;
		this.user = user;
		this.password = password;
		
		try { this.con = DriverManager.getConnection(address,user,password); this.stm = con.createStatement(); }
		catch (SQLException e) { System.out.println("Cannot connect to database... Exiting"); System.exit(1); }
	}
	
	/**
	 * Sets and stores the address for the database.
	 * @param server
	 * The server name where the database is hosted.
	 * @param database
	 * The database name.
	 */
	public void setAddress(String server,String database)
	{
		this.address = "jdbc:mysql://" + server + "/" + database;
	}
	
	/**
	 * Sets and stores database credentials.
	 * @param user
	 * Database user name.
	 * @param password
	 * Database user password.
	 */
	public void setLogin(String user,String password)
	{
		this.user = user;
		this.password = password;
	}
	
	/**
	 * Establishes a connection with database and sets the statement object.
	 * @return
	 * Returns true if connection was successful.
	 */
	public boolean connect()
	{
		
		if(this.address == null || this.address == "") return false;
		if(this.user == null || this.user == "") return false;
		if(this.password == null || this.password == "") return false;
		
		try
		{
			this.con = DriverManager.getConnection(this.address,this.user,this.password);
			this.stm = con.createStatement();
			return true;
		}
		catch (SQLException e) { System.out.println(e.getSQLState()); return false; }
	}
	
	/**
	 * Inserts a record into table.
	 * @param field
	 * The set of data to be inserted.
	 * @return
	 * Return true if data was inserted successfully.
	 */
	public boolean exec(JTextField field[])
	{
		String cmd = "insert into ITC313 (id,name,score1,score2,score3,score4) values (";
		for(int i = 0 ; i < 6 ; i++){
			if(i >= 0 && i < 2) cmd += "'";
			cmd += field[i].getText();
			if(i >= 0 && i < 2) cmd += "'";
			if(i != 5) cmd += ",";
		}
		cmd += ");";
		
		try { stm.executeUpdate(cmd); return true; }
		catch (SQLException e) { return false; }
	}
	
	/**
	 * Searches for a record that matches 'id'. Results are added to result set
	 * @param id
	 * The ID that is to be searched for.
	 * @return
	 * Returns true if no SQL exception occurs.
	 */
	public boolean query(String id)
	{
		try { rs = stm.executeQuery("select * from ITC313 where id = '" + id + "';"); return true; } 
		catch (SQLException e) { return false; }
	}
	
	/**
	 * Deletes table if it exists.
	 * @return
	 * Returns true if the table was deleted successfully.
	 */
	public boolean drop()
	{
		try { stm.executeUpdate(SQLCMD_DTABLE); return true; }
		catch (SQLException e) { return false; }
	}
	
	/**
	 * Deletes table if it doesn't exists.
	 * @return
	 * Returns true if the table was created successfully.
	 */
	public boolean create()
	{
		try { stm.executeUpdate(SQLCMD_CTABLE); return true; }
		catch (SQLException e) { return false; }
	}
	
	/**
	 * Gets all the records in the table. The results are captured in the result set.
	 * @return
	 * Returns true if no SQL exception occurs.
	 */
	public boolean allRecords()
	{
		try { rs = stm.executeQuery(SQLCMD_GTABLE); return true; }
		catch (SQLException e) { return false; }
	}
}
