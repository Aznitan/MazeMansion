package org.example.Controller;

import org.example.Model.GameTablesDBCreate;
import org.example.Model.RoomDB;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class: Room
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0
 * Course ITEC 3860
 * Written: Oct 5, 2023
 *
 * The Room class represents a location within the game world. It encapsulates various characteristics of a room, including its unique identifier, name, description, exits, items, puzzles, and methods to interact with and explore the room.
 *
 * Methods :
 * +Room() : This is the no argument constructor that holds the room id, room name, description, exits and room database.
 * +Room(id : int, name : String) : This is the constructor with perameters that instantiate the class.
 *  +display() : String : This displays the game discription.
 * -buildDescription() : String : This will get the description of the game from the database.
 * -buildItems() : String : This will create the items and place them in the rooms that they belong in.
 * -displayExits() : String : This will retrieve exits from the database and show to the user where they can go.
 * +removeItem(Item : Item) : void : This will remove item from the room database when player takes the item and puts it in the inventory or drops it in a different room.
 * +dropItem(Item : Item) : void : This allows the player to drop item anywhere they choose to drop it.
 * +validDirection(cmd : char) : int : This will check of the direction they user types in is valid or not.
 * +addPuzzle(puzzleID : Puzzle) : void : This adds a puzzle to the current room.
 * +getExits() : ArrayList<Exit> : This gets the exits from an arraylist and displays it to the user.
 * +getRoomItems() : ArrayList<Item> : This gets an item from the arraylist of items and places it in the rooms.
 */
public class Room {

	/**
	 * Unique identifier for the room, allowing the game to distinguish and manage different locations.
	 */
	private int roomID;
	/**
	 * Holds the name or title of the room, providing a descriptive label for the player to identify the location.
	 */
	private String roomName;
	/**
	 * Contains a textual description of the room, providing the player with details about its appearance and any notable features or objects within.
	 */
	private String description;
	private boolean visited;

	/**
	 * Reference to the Exits class, which manages the exits or pathways from the room to other locations in the game world.
	 */

	private Collection <Exit> exits;

	/**
	 * Reference to the RoomDB class, which may be responsible for storing and retrieving information about rooms, including their attributes.
	 */
	private RoomDB roomdb;

	private ArrayList<Item> items;

	/**
	 * Getters and Setters for the variables
	 */
	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {	this.roomID = roomID;}

	public String getRoomName(){
		return this.roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}

	public boolean isVisited() {
		return this.visited;
	}
	public void setVisited(boolean visited){
		this.visited = visited;
	}

	public void setExits(Collection<Exit> exits) {
		this.exits =  exits;
	}

	/**
	 * Default constructor that creates an instance of the Room class without specific attributes.
	 */

	public Room () throws GameException {
		this.roomdb = new RoomDB();
		this.visited = false;
		this.exits = new ArrayList<>();

	}
	/**
	 * This constructor initializes a Room object with a unique identifier and a name.
	 * @param id
	 * @param name
	 */
	public Room(int id, String name, String description, int visited) throws GameException {
		this();
		this.roomID = id;
		this.retrieveByID(id);

		try {
			roomdb = new RoomDB();
			Room retrievedRoom = roomdb.getRoom(roomID);
			this.roomName = retrievedRoom.getRoomName();
			this.description = retrievedRoom.getDescription();
			this.exits = retrievedRoom.getExits();
		}catch (GameException e){
			throw new GameException("Error Creating Room " + e.getMessage());
		}
	}

	/**
	 * Returns a string representation of the room, including its name and description.
	 * Used to provide the player with information about the current room.
	 */
	public String display() throws GameException {
		StringBuilder roomDisplay = new StringBuilder();
		roomDisplay.append(buildDescription()).append("\n");
		roomDisplay.append(buildItems()).append("\n");
		roomDisplay.append(displayExits()).append("\n");
		return roomDisplay.toString();
	}



	/**
	 * Constructs a textual description of the room, including any dynamic or interactive elements within the room.
	 */
	private String buildDescription() {
		return this.description;
	}


	/**
	 * This method generates a description of the items present in the room, informing the player about objects they can interact with or add to their inventory.
	 */
	private String buildItems() throws GameException {
		try {
			StringBuilder itemsString = new StringBuilder("Items in the room: ");
			ArrayList<Item> items = getRoomItems();
			for (Item item : items) {
				itemsString.append(item.getName()).append(", ");
			}
			return itemsString.toString();
		} catch (GameException e) {
			throw new GameException("Error building items: " + e.getMessage());
		}
	}


	/**
	 * Provides a description of the available exits from the room, indicating the directions in which the player can move.
	 */
	private String displayExits() {

		StringBuilder exitDescription = new StringBuilder();
		exitDescription.append("Available exits from the ").append(roomName).append(":\n");
		if (!exits.isEmpty()) {
			for (Exit exit : exits) {
				exitDescription.append("- ").append(exit.getDirection()).append(": ")
						.append(exit.getDestination()).append("\n");
			}
		} else {
			exitDescription.append("There are no exits from this room.\n");
		}
		return exitDescription.toString();
	}


	/**
	 * This method removes a specific item from the room's contents, typically when the player interacts with and takes the item.
	 * @param Item
	 */
	public void removeItem(Item Item) {
		// TODO - implement Room.removeItem

//		Iterator<Item> iterator = item.iterator();
//		while (iterator.hasNext()) {
//			Item currentItem = iterator.next();
//			if (currentItem.getName().equals(item.getName())) {
//				iterator.remove();
//				System.out.println(item.getName() + " has been removed from the " + name + ".");
//				return;
//			}
//		}
//		System.out.println(item.getName() + " not found in the " + name + ".");


	}

	/**
	 * Allows items to be added to the room's contents, potentially providing resources or challenges for the player.
	 * @param Item
	 */
	public void dropItem(Item Item) {

//		Item.add(Item);

		System.out.println(Item.getName() + " has been dropped in the " + Item + ".");
	}

	/**
	 * This method checks if a given direction (specified as a character, e.g., 'N' for north) is a valid exit direction from the room.
	 * @param cmd
	 */
	public boolean validDirection(char cmd) {
		char directionChar = Character.toUpperCase(cmd);
		for (Exit exit : exits){
			if (exit.getDirection() == directionChar){
				return true;
			}
			else
				System.out.println("Invalid direction! Please choose a valid direction");
		}
		return false;


	}

	public Room retrieveByID(int roomNum) throws GameException{
		try {
			RoomDB roomDB = new RoomDB();
			return roomdb.getRoom(roomNum);
		} catch (GameException e) {
			throw new GameException("Errror retriveing room : " + e.getMessage());
		}
	}



	/**
	 * Associates a puzzle with the room, allowing players to interact with and attempt to solve it.
	 * @param puzzleID
	 */
	public void addPuzzle(Puzzle puzzleID) {
		// TODO - implement Room.addPuzzle
//		puzzle.add(puzzle);
//		System.out.println("Puzzle added to the room: " + puzzle.getDescription());

	}

	/**
	 * This method retrieves a list of available exits from the room, allowing the player to choose their direction of movement.
	 */
	public Collection<Exit> getExits() throws GameException {
		return roomdb.getRoom(roomID).getExits();
	}


	/**
	 * Returns a list of items currently present in the room, providing the player with information about interactable objects.
	 */
	public ArrayList<Item> getRoomItems() throws GameException {
		return roomdb.getItem(roomID);
	}
}


