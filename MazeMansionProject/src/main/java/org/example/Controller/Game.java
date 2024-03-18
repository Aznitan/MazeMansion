package org.example.Controller;

import org.example.Model.GameTablesDBCreate;

import java.sql.SQLException;

/**
 * Class: The Game
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  This class collects all the user interactions and sends forward the same inputs for other methods that call them.
 * Methods :
 * +Game() : This method is the constructor in which activates the commands made to allow the player to move around.
 * +startGame() : void : This method initiates the game when the user is logged in from either the beginning or from where they last saved the game
 * +displayRoomDiscription() : String : This displays the room that the player is in and what is in the room and where they can go.
 * +getPlayerName() : String : This method gets the name of the player from the database.
 * +useCommand(cmd : String) : String : This method gets the method from what the player types in and instantiates the method.
 * +printMap() : String : This method shows the map to the user when they need to see where they are and where to go next.
 *  
 */
public class Game {

	/**
	 * Keeps track of the player's current location 
	 */
	public int currentRoom = 1;
	private Navigation commands;

	/**
	 * The constructor initializes a new game instance and prepares it for the player's adventure
	 */
	public Game() {
		this.commands = new Navigation();
	}

	/**
	 * The constructor initializes a new game instance.
	 */
	public void startGame() throws SQLException, GameException, ClassNotFoundException {
		GameTablesDBCreate gameDB = new GameTablesDBCreate();
		gameDB.buildTables();
//		gameDB.buildRoom();
//		gameDB.buildExit();
//		gameDB.buildItem();
		displayRoomDescription();

	}

	/**
	 * This method retrieves and returns the textual description of the current room.
	 */
	public String displayRoomDescription() throws GameException{
		try {
			Room currentRoom = new Room();
			currentRoom.display();
			return currentRoom.retrieveByID(this.currentRoom).getDescription();
		}catch (GameException e ){
			throw new GameException("Error displaying room description: " +  e.getMessage());
		}
	}

	/**
	 * Method retrieves the player's name
	 */
	public String getPlayerName() {
		return commands.getPlayerName();
	}

	/**
	 * Processes the player's input commands
	 * @param cmd
	 */
	public String useCommand(String cmd) throws GameException{
		try {
			return commands.doCommand(cmd);
		}catch (GameException e){
			throw new GameException("Error executing the command" + e.getMessage());
		}
	}

	/**
	 * Method generates a visual representation of the game world, displaying rooms, exits, and the player's location.
	 */
	public String printMap() {
		// TODO - implement Game.printMap
		throw new UnsupportedOperationException();
	}

}