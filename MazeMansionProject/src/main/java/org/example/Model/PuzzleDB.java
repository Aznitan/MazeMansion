package org.example.Model;

/**
 * Class: PuzzleDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This is the database for the puzzles found in the game.
 * 
 * Methods :
 * +getPuzzleID() : int : This will retrieve the puzzle from the database using the id
 * +getDescription() : String : This retrieves the description of the puzzle.
 * +checkSolution(playerAnswer : String) : boolean : This will check of the solution matches with the solution that is in the database.
 * +resetPuzzle() : void : This will reset the puzzle if the player leaves the room or exits the game.
 */
public class PuzzleDB {

	private SQLiteDB sdb = null;

	public int getPuzzleID() {
		// TODO - implement PuzzleDB.getPuzzleID



		return 0;
	}




	public String getDescription() {
		// TODO - implement PuzzleDB.getDescription


        return null;
    }



	/**
	 * 
	 * @param playerAnswer
	 */
	public boolean checkSolution(String playerAnswer) {
		// TODO - implement PuzzleDB.checkSolution

        return false;
    }
	public void resetPuzzle() {
		// TODO - implement PuzzleDB.resetPuzzle

	}

}