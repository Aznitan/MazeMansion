package org.example.Controller;


import java.io.*;


/**
 * Class: GameException
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 * 
 *  This class creates a custom exception for the game.
 * 
 * Methods :
 * +GameException() : This is the no-argument constructor of the exception.
 * +GameException(message : String) : This is the constructor that holds the message that is displayed to the user.
 */

public class GameException extends Exception {
		public GameException() {
			super();
		}
		/**
		 * @param message
		 */
		public GameException(String message) {
			super(message);
		}

}





