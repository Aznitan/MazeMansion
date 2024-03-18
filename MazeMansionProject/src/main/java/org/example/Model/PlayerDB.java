package org.example.Model;
import org.example.Controller.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class: PlayerDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This is the database of the player information.
 * 
 * Methods:
 * +getPlayer(id : int) : Player : This retrieves the player information from the database using the id.
 * +update(player : Player) : void : This updates the player when health changes.
 */
public class PlayerDB {

	private SQLiteDB sdb;


	public PlayerDB() throws GameException{
		try{
			sdb = new SQLiteDB("MazeMansionData.db");
		}catch (SQLException | ClassNotFoundException e ){
			throw new GameException("Error initializing Player " + e.getMessage());
		}
	}
	public Player getPlayer(int id) throws GameException {
		try{
			String selectQuery = "SELECT * FROM Player WHERE playerID = " + id;
			ResultSet resultSet = sdb.queryDB(selectQuery);
			if (resultSet.next()){
				int playerId = resultSet.getInt("playerId");
				String playerName = resultSet.getString("playerName");
				return new Player(playerId,playerName);
			}else {
				throw new GameException("Player not found for ID " + id);
			}
		}catch (SQLException | GameException e){
			throw new GameException("Error getting player: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param player
	 */
	public void update(Player player) throws GameException {
		try {
			String updateQuery = "UPDATE Player SET playerName = '" + player.getPlayerName() + "' WHERE playerID = " + player.getPlayerID();
			sdb.updateDB(updateQuery);
		}
		catch (SQLException e){
			throw new GameException("Error updating player: " + e.getMessage());
		}
	}

	public void close() {
		try {
			if (sdb != null){
				sdb.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}