package org.example.Controller;


import java.util.Arrays;

import java.util.List;

/**
 * Class: The Game
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023
 * The Navigation class serves as the core component responsible for managing player navigations in the game. It handles various aspects of gameplay, allowing players to explore the game world, interact with objects, and make progress in their adventure.
 * Methods :
 * +move(direction : String) : This method moves the player in the direction they want to go.
 * +checkForPuzzle() : boolean : This method will see if their is a puzzle in the current room.
 * +checkForMonster() : boolean : This method will see if their is a monster in the current room.
 * +interactWithExit(exit : Exit) : This method will let player leave the room and take the player to the next room.
 * +Navigation() : This is the constructor of the navigation class.
 * +handleError(errorMsg : String) : void : This method will send an error message to the user if typed in wrong command.
 */
class Navigation {

	/**
	 * This attribute is used to track the player's current status, inventory, and location
	 */
	private Player player;
	/**
	 * A reference to the Room class representing the current room the player is in. This allows the Navigation class to interact with the room's properties and contents.
	 */
	private Room room;
	/**
	 * A reference to the Inventory class, which keeps track of the items the player is carrying. This attribute allows the Navigation class to manage the player's inventory and item interactions.
	 */
	private Inventory inventory;
	protected List<Character> DIRECTIONS = Arrays.asList('N','S','W','E','U','D');
	protected List<Character> ACTIONS =  Arrays.asList('I','O','H');
	/**
	 * The constructor for the Navigation class initializes the navigation system when an instance of the class is created.
	 */
	Navigation() {
		this.player = new Player();
		addPlayer();
	}

	protected void addPlayer() {
		String playerName = player.getPlayerName();
		player.setPlayerName(playerName);
	}
	protected void setPlayer(Player player) {
		this.player = player;
	}
	private int validateCommand(String cmdLine) throws GameException {
		char command = cmdLine.toUpperCase().charAt(0);

		if (DIRECTIONS.contains(command)) {
			return 1;
		} else if (ACTIONS.contains(command)) {
			return 2;
		}
		else {
			throw new GameException("Invalid command!");
		}
	}

	protected String doCommand (String cmd) throws GameException{
		int commandType = validateCommand(cmd);
		switch (commandType){
			case 1:
				return move(cmd);
//			case 2:
//				return itemCoomand(cmd);
			default:
				throw new GameException("Invalid command!");
		}
	}

	/**
	 * This method allows the player to move in a specified direction within the game world. The direction parameter represents the chosen direction (e.g., "north," "south") and initiates player movement.
	 * @param direction
	 */
	public String move(String direction) throws GameException{
		char direc = direction.toUpperCase().charAt(0);
		if (DIRECTIONS.contains(direc)){
			int nextRoomID = room.getRoomID();
			player.setCurrentRoom(nextRoomID);
			return "Moved to the next room.";
		}
		else {
			throw new GameException("Invalid direction! Please choose a valid direction");
		}
	}
	protected String getPlayerName(){
		return player.getPlayerName();
	}





}