package org.example.Model;
import org.example.Controller.Exit;
import org.example.Controller.GameException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class: ExitDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This is the database of the exits and stores all the exits of each room.
 * 
 * Methods:
 * +getExits(roomID : int) : ArrayList<Exit> : This gets the exits from the arraylist that is in the database.
 */
public class ExitDB {

	private SQLiteDB sdb = null;

	public ExitDB(){
		try{
			sdb = new SQLiteDB("MazeMansionData.db");
		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param roomID
	 */
	public ArrayList<Exit> getExits(int roomID) throws GameException {
		ArrayList<Exit> exits = new ArrayList<>();
		try {
			String query = "SELECT * FROM Exits WHERE roomID = " + roomID;
			ResultSet resultSet =sdb.queryDB(query);
			while (resultSet.next()) {
				int exitID = resultSet.getInt("exitID");
				char direction = resultSet.getString("direction").charAt(0);
				int destinationRoomID = resultSet.getInt("destination");

				Exit exit = new Exit(exitID,direction,destinationRoomID);
				exits.add(exit);
			}
		} catch (SQLException e) {
			 throw new GameException("Error getting exits from room: "+ e.getMessage());
		}

		return exits;
	}

}