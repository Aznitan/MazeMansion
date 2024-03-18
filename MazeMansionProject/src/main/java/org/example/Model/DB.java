package org.example.Model;
import java.sql.*;

/**
 * Class: DB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This class is to allow all the databases to connect to the program and be able to play the game.
 * 
 * Methods:
 * +queryDB(sql : String) : ResultSet : This queries all the tables.
 * +updateDB(SQL : String) : boolean : This updates the databases as the game is played.
 * +close() : void : This closes the database to keep it from data leaking.
 */
public class DB {

	protected String dbName = "MazeMansionData.db";
	protected String sJdbc = "org.sqlite.JDBC";
	protected String sDriveName = "jdbc:sqlite:";
	protected Connection conn;
	protected String sDbUrl;
	protected int timeout = 5;

	public DB() throws SQLException, ClassNotFoundException {
		initializeConnection();
	}

	public void initializeConnection() throws SQLException,ClassNotFoundException{
		try {
			Class.forName("org.sqlite.JDBC");
			sDbUrl = "org.sqlite.JDBC"+ dbName;
			conn = DriverManager.getConnection("jdbc:sqlite:MazeMansionData.db");
			System.out.println("Opened database successfully");
		}catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 
	 * @param sql
	 */
	public ResultSet queryDB(String sql) throws SQLException{
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}

	/**
	 * Method: updateDB
	 * Purpose: Updates the database
	 * @param sql
	 */
	public boolean updateDB(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql) >0;
	}

	/**
	 * Method: count
	 * Purpose: Gets the count of records in the specified table
	 * @param table
	 * @return int
	 */
	public int count(String table) throws SQLException {
		String countQuery = "SELECT COUNT(*) FROM " + table;
		ResultSet resultSet = queryDB(countQuery);
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
			return 0;
	}

	/**
	 * Method: getMaxValue
	 * Purpose: Gets max value for a particular field in a particular table
	 * @param columnName
	 * @param table
	 * @return int
	 */
	public int getMaxValue(String columnName, String table) throws SQLException {
		String maxQuery = "SELECT MAX(" + columnName + ") FROM " + table;
		ResultSet resultSet = queryDB(maxQuery);
		if (resultSet.next()) {
			return resultSet.getInt(1);
		}
		return 0;
	}

	public void close() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

}