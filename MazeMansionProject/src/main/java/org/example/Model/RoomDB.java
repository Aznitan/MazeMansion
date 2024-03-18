package org.example.Model;
import org.example.Controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class: RoomDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This holds the information of each room in the database.
 * 
 * Methods:
 * +getRoomID(roomID : int) : Room : This retrieves the room id from the database.
 * +getItem(roomID : int) : ArrayList<Item> : This gets the item that is in the room based on the room id in the database.
 * +updateRoom(room : Room) : void : This updates the room database when either a puzzle is solved or the player has already visited the room.
 */
public class RoomDB {

	private SQLiteDB sdb = null;

	public RoomDB(){
		try {
			sdb =new SQLiteDB("MazeMansionData.db");
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param roomID
	 */

	public Room getRoom(int roomID) throws GameException{
		try{
			String query = "SELECT * FROM Room WHERE roomID = " + roomID;
			ResultSet resultSet = sdb.queryDB(query);

			if (resultSet.next()){
				int roomId = resultSet.getInt("roomID");
				String roomName = resultSet.getString("roomName");
				String roomDescription = resultSet.getString("roomDescription");
				int visited = resultSet.getInt("visited");

				return new Room(roomId, roomName, roomDescription, visited);
			}
			else
				throw new GameException("Room with ID " + roomID + " not found");

		}
		catch (SQLException e){
			throw new GameException("Error getting room " + e.getMessage());
		}
    }



	/**
	 * 
	 * @param roomID
	 */


	public ArrayList<Item> getItem(int roomID) throws GameException {
		ArrayList<Item> items = new ArrayList<>();
		try {
			String query = "SELECT * FROM ItemRoom WHERE roomID = " + roomID;
			ResultSet resultSet = sdb.queryDB(query);

			while (resultSet.next()) {
				int itemId = resultSet.getInt("itemID");
				String itemName = resultSet.getString("itemName");

				Item item = new Item(itemId, itemName);
				items.add(item);
			}
		} catch (SQLException e) {
			throw new GameException("Error getting items for room: " + e.getMessage());
		}

		return items;
	}


	/**
	 * 
	 * @param room
	 */


	public void updateRoom(Room room) throws GameException {
		try {
			String updateQuery = "UPDATE Room SET roomName = '" + room.getRoomName() +
					"', roomDescription = '" + room.getDescription() +
					"', visited = " + room.isVisited() +
					"WHERE roomID = " + room.getRoomID();
			sdb.updateDB(updateQuery);
		} catch (SQLException e) {
			throw new GameException("Error updating room: " + e.getMessage());
		}

	}
}