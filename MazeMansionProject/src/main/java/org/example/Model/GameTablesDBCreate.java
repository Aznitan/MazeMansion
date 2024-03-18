package org.example.Model;

import org.example.Controller.Game;
import org.example.Controller.GameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Class: GameTablesDBCreate
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This creates all the tables in the database for all the other databases and is dependant of the SQLiteDB class.
 * 
 * Methods:
 * +buildTables() : void : This builds the tables needed for the game.
 * +buildRoom() : void : This builds the room table of all the rooms with the descriptions and exits.
 * +buildItem() : void : This builds the items table of all the items with the id and names.
 * +buildItemRoom() : void : This builds the table of the items and what room it belongs to.
 * +buildExit() : void : This builds the table of the exits and to what room it goes to.
 * +buildPlayer() : void : This builds the table of the player of the game.
 * +buildPlayerItem() : void : This builds the table for the items the player picks up or uses.
 * +buildMonster() : void : This builds the table for the monsters.
 * +buildPuzzle() : void : This builds the table for the puzzles that are in the game.
 */
public class GameTablesDBCreate {

	SQLiteDB sdb ;

	public GameTablesDBCreate() {
		try {
			sdb = new SQLiteDB("MazeMansionData.db");
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public void buildTables() throws SQLException, GameException, ClassNotFoundException {
		buildRoom();
		buildItem();
		buildExit();
		buildPlayer();
		buildMonster();
		buildPuzzle();

	}

	public void buildRoom() throws SQLException, GameException, ClassNotFoundException {
//		String createRoomTableQuery = "CREATE TABLE IF NOT EXISTS Room (roomID INT PRIMARY KEY NOT NULL, roomName TEXT NOT NULL, roomDescription TEXT NOT NULL, visited INTEGER NOT NULL)";
		try {
//			sdb.updateDB(createRoomTableQuery);
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Rooms.txt"));
			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);

			}
			reader.close();

		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Room table: " + e.getMessage());
		}
	}

	public void buildItem() throws GameException {
//		String createItemTableQuery = "CREATE TABLE IF NOT EXISTS Item (itemID INTEGER PRIMARY KEY, itemName TEXT NOT NULL, itemDescription TEXT NOT NULL, itemDamage INTEGER NOT NULL)";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Items.txt"));
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);
			}
			reader.close();
			//sdb.updateDB(createItemTableQuery);
		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Item table: " + e.getMessage());
		}
	}

	public void buildItemRoom() {
		// TODO - implement GameTablesDBCreate.buildItemRoom
		throw new UnsupportedOperationException();
	}

	public void buildExit() throws GameException {
		//String createExitTableQuery = "CREATE TABLE IF NOT EXISTS Exit (exitID INTEGER PRIMARY KEY, roomID INTEGER NOT NULL, direction TEXT NOT NULL, destination TEXT NOT NULL)";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Exits.txt"));
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);
			}
			reader.close();
		//	sdb.updateDB(createExitTableQuery);
		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Exits table: " + e.getMessage());
		}
	}

	public void buildPlayer() throws GameException{
		//String createPlayerTableQuery = "CREATE TABLE IF NOT EXISTS Player(playerID INTEGER PRIMARY KEY, password TEXT NOT NULL, playerName TEXT NOT NULL, playerLP INTEGER NOT NULL, currentRoom INTEGER NOT NULL)";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Players.txt"));
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);
			}
			reader.close();
			//sdb.updateDB(createPlayerTableQuery);
		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Player: " + e.getMessage());
		}
	}

	public void buildPlayerItem() {
		// TODO - implement GameTablesDBCreate.buildPlayerItem
		throw new UnsupportedOperationException();
	}

	public void buildMonster() throws GameException {
		//String createMonsterTableQuery = "CREATE TABLE IF NOT EXISTS Monster(monsterName TEXT NOT NULL, monsterID INTEGER NOT NULL, monsterLP INTEGER NOT NULL, roomID INTEGER NOT NULL)";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Monster.txt"));
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);
			}
			reader.close();
			//sdb.updateDB(createMonsterTableQuery);
		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Monster: " + e.getMessage());
		}
	}

	public void buildPuzzle() throws GameException{
		//String createPuzzleTableQuery = "CREATE TABLE IF NOT EXISTS Puzzle(puzzleID INTEGER PRIMARY KEY, itemID INTEGER NOT NULL, puzzleDescription TEXT NOT NULL, roomID INTEGER NOT NULL)";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\siul_\\Documents\\MazeMansion\\MazeMansionProject\\src\\Puzzles.txt"));
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println("Executing SQL: " + line);
				sdb.updateDB(line);
			}
			reader.close();
			//sdb.updateDB(createPuzzleTableQuery);
		}
		catch (IOException | SQLException e) {
			throw new GameException("Error building Puzzle: " + e.getMessage());
		}
	}

}