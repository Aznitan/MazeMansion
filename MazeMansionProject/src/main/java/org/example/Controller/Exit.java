package org.example.Controller;


import org.example.Model.ExitDB;

import java.sql.*;
import java.util.Arrays;


/**
 * Class: Exit
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * The Exit class represents a pathway or connection between different rooms.
 * 
 * Methods :
 * +getDirection() : String : This retrieves the direction from the database when the user types in a direction.
 * +getDestination() : Room : This will get the next room from the database.
 *  
 */
public class Exit {

	/**
	 * Stores information about the direction in which the exit leads. It typically uses descriptive terms like "north," "south," "east," or "west" to indicate the relative orientation of the exit.
	 */
	private char direction;
	/**
	 * References the target room to which the exit leads. It establishes the connection between the current room and the room the player will reach when using the exit.
	 */
	private int destination;
	/**
	 *  An identifier for the current room.
	 */
	private int roomID;
	private int exitID;

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	private final java.util.List<String> VALID_DIRECTIONS = Arrays.asList(new String[] {"WEST", "NORTH", "SOUTH", "EAST", "UP", "DOWN"});


	public Exit(int exitID, char direction, int destinationRoomID) {
		this.exitID = exitID;
		this.direction = direction;
		this.destination = destinationRoomID;
	}

	@Override
	public String toString() {
		return "Direction: " + direction + ", Destination RoomID: " + destination;
	}




}