package org.example.Controller;

import java.sql.*;




import java.sql.*;

import org.example.Model.PuzzleDB;


/**
 * Class: Puzzle 
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * The Puzzle class represents a challenge or interactive element in the game that requires players to solve a problem or riddle.
 * 
 * Methods :
 * +solve() : void : This allows player to interact with the puzzle.
 * +isSolved() : boolean : This checks if the puzzle has already been solved or if it has not been solved.
 * +getDescription() : String : This gets the description of the puzzle from the database and displays it to the player.
 * +Puzzle(description : String) :
 * This is the constructor of  the puzzle class and stores the description of the puzzle.
 * +getHint() : String : This gets the hint from the database and displays it to the player when they press the hint button for a hint.
 * +reset() : void : This resets the puzzle when user exits the room or exits the game.
 */
public class Puzzle {

	/**
	 * Contains a textual representation of the puzzle, providing players with information about the challenge they need to overcome.
	 */
	private String description;
	/**
	 * Tracks the puzzle's completion status. It is set to true when the puzzle is successfully solved and false when it remains unsolved.
	 */
	private boolean solved;
	/**
	 * Provides a unique identifier for the puzzle, distinguishing it from other puzzles in the game. It aids in puzzle management and tracking.
	 */
	private int puzzleID;
	/**
	 * Provides a hint to the player on how to solve the puzzle when they type in "h".
	 */
	private String hint;

	/**
	 * Called when the player successfully completes the puzzle. It updates the solved attribute to indicate that the puzzle has been solved.
	 */
	public void solve() {

		solved = true;
		System.out.println("Congratulations! Puzzle solved!");


		// TODO - implement Puzzle.solve

		solved = true;
		System.out.println("Congratulations! Puzzle solved!");

	}

	/**
	 * This method enables players and the game system to check the current status of the puzzle. It returns true if the puzzle is solved and false if it remains unsolved.
	 */
	public boolean isSolved() {
		return this.solved;
	}

	/**
	 * Retrieves the textual description of the puzzle, offering players a comprehensive understanding of the challenge.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * This constructor allows you to create a new Puzzle object and set its description during instantiation.
	 *
	 * @param description
	 */


	public Puzzle(String description) throws SQLException {
		throw new UnsupportedOperationException();

	}




	/**
	 * Provides a helpful clue or guidance related to solving the puzzle. It assists players without revealing the entire solution.
	 */
	public String getHint() {

	throw new UnsupportedOperationException();
    }

	/**
	 * Method that allows players to reset the puzzle to its unsolved state, offering the flexibility to retry or start over.
	 */

	public void reset() {


	}




}





