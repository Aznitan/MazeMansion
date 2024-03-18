package org.example.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Class: UserDatabase
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  This is the database that creates the databases and connects the database to the game.
 * 
 * Methods:
 * +SQLiteDB() : This is the constructor of the SQLiteDB class.
 * +SQLiteDB(dbName : String) : This is the constructor that instantiates the class.
 */
public class SQLiteDB extends DB{
	private java.sql.Connection connection;
	/**
	 * Constructor: SQLiteDB
	 */
	public SQLiteDB() throws SQLException, ClassNotFoundException {
		super();
	}

	/**
	 * Constructor: SQLiteDB
	 * @param dbName
	 */
	public SQLiteDB(String dbName) throws java.sql.SQLException, ClassNotFoundException{
		super();
	}

}