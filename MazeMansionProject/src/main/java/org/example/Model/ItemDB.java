package org.example.Model;

import org.example.Controller.GameException;
import org.example.Controller.Item;

import java.sql.*;

/**
 * Class: ItemDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This class is for the item database in which will be updated when a player picks up an item and stores it away in the inventory, the item is used to fight monsters or the item is dropped.
 * 
 * Methods :
 * +ItemDB() : This is the no argument constructor of the item class.
 * +getItem(id : int) : Item : This retrieves the item from the database using the id.
 */
public class ItemDB {

	private SQLiteDB sdb;

	public ItemDB() throws GameException{
		try {
			sdb = new SQLiteDB("MazeMansionData.db");
		} catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Error initializing ItemDB: " + e.getMessage());
        }
    }

	/**
	 * 
	 * @param id
	 */
	public Item getItem(int id) throws GameException {
		try {
			String query = "SELECT * FROM Item WHERE itemID = " + id;
			ResultSet resultSet = sdb.queryDB(query);

			if (resultSet.next()) {
				int itemId = resultSet.getInt("itemID");
				String itemName = resultSet.getString("itemName");
				return  new Item (itemId, itemName);
			}else {
				throw new GameException("Item not found itemID was " + id);
			}
		} catch (SQLException e) {
			throw new GameException("Error getting item: " + e.getMessage());
		}
	}

	public void close(){
		try {
			if (sdb != null){
				sdb.close();
			}
		}catch (SQLException e ){
			e.printStackTrace();
		}
	}

}