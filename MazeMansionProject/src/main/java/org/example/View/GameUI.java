package org.example.View;
import org.example.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * Class: GameUI 
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 *  
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 * This responsible for managing the user interface and game flow. It allows users to register, log in, and interact with the game once logged in  
 * Methods: 
 * +GameUI() : This method connects the game that is in the database to the user. 
 * +main() : This method will display login or register UI to the user. 
 * -getCommand() : This method gets the direction that the user wants to go towards. 
 * -playGame() : This method starts the game from either the beginning or where the player has saved it from and the player can navigate through the game and pick up items. 
 * -registerUser(scanner : Scanner) : Once the user has entered their information the registerUser() method will send the information to the database to securely store away. 
 * -loginUser(scanner : Scanner) : This method will allow user to type in username and password and send to the database to verify.
 *   
 */
public class GameUI {

	private static Scanner input = new Scanner(System.in);
	private Game gm;
	private static String userName = "a";
	private static String password = "a";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	private static int reset = 0;
	private String availableCommands = "|Available Options|\n" + "|North| |South| |East| |West|";
	private static String welcome = "************************************************************\n" +
			"************************************************************\n" +
			"************************************************************\n" +
			"***                   MazeMansion                        ***\n" +
			"                 _                 _\n" +
			"             ___/|\\_______________/|\\___\n" +
			"            /~^/|||\\ ~~ ~~~  ~~ ^/|||\\~^\\\n" +
			"           /^~/|||||\\~~  ^^~  ^~/|||||\\~~\\\n" +
			"     ()   /~~/|||||||\\ ~^~_~^~ /|||||||\\~~\\\n" +
			"  (()))) /~^/| / | \\ |\\^~/|\\~^/| / | \\ |\\~~\\\n" +
			" ()((())/~~/||_)_|_(_||\\/|||\\/||_)_|_(_||\\~~\\\n" +
			"(()()()/~~ ~~^ ^~^~ ~~ /|||||\\ ~~ ~^~^ ^~~ ~~\\ ()\n" +
			"()()()()||||||||||||||/|||||||\\|||||||||||||| (()))\n" +
			"((()()))|||||||||||||/|||||||||\\|||||||||||||()()())\n" +
			"()((())||| / | | \\ |||| |+|+| |||| / | | \\ ||()))())())\n" +
			"()(())(|||_)_|_|_(_|||| |+|+| ||||_)_|_|_(_||(())()())\n" +
			"(()(())||||||||||||||||_|+|+|_|||||||||||||||())()()())\n" +
			"@@@ @@@@@@ @@@ @@@ @@@|-------|@@@ @@@ @@@ @@@@@ @@@@@ @@\n" +
			"************************************************************\n" +
			"***              Welcome to MazeMansion                   **\n" ;
	private static String regisLogin = "....................[1] Login.......................\n" +
			"....................[2] Register....................\n" +
			"....................Enter your choice:";
	/**
	 * Method GameUI
	 * Creates an instance of the Game class the interface of the controller package
	 */
	public GameUI() {
		this.input = new Scanner(System.in);
		this.gm = new Game();
	}

	/**
	 * Method Main 
	 * Runs the game by displaying a menu for the user actions and game interactions 
	 * Starts the Scanner, calls playGame and closes Scanner
	 */

	public static void main(String[] args) {
		int choice;
			do {
				timerString(welcome, 0);
				timerString(regisLogin, 0);
				choice = input.nextInt();
					switch (choice) {
						case 1:
							try {
								loginUser();
							} catch (SQLException | GameException e) {
								throw new RuntimeException(e);
							}
							break;
						case 2:
							registerUser();
							reset = 1;
							break;
						default:
							System.err.println("Not a Choice. Try Again...");
					}

			}
			while (reset >= 0);
		try {
			GameUI gameUI = new GameUI();
			gameUI.playGame();
		} catch (SQLException | GameException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Method getCommand
	 * ask the user for their input and returns this to playGame
	 */
	private String getCommand() {
		// Now with the returning input we can use it on the Game class everytime we ask the user for a command and transforms the command to uppercase
		System.out.print("Enter your command: ");
		if (availableCommands.equalsIgnoreCase("help")){
			System.out.println(availableCommands);
		}
		return  input.nextLine().toUpperCase().trim();
	}

	/**
	 * Method playGame
	 * Allows the player to play the game
	 * prints introduction message
	 * display text for valid directions
	 * loops the game until game decides to stop
	 * Calls getCommand method to get the input from the user
	 * passes the user input to the Commands method and executeCommand.
	 */
	private void playGame() throws SQLException, GameException, ClassNotFoundException {
	timerString(welcome,1);
	timerString(availableCommands,1);
	boolean gameRuns = true;
		while (gameRuns){
			gm.startGame();
			//String command = getCommand();
		}
		input.close();
	}

	/**
	 * Method registerUser
	 *  
	 * Handles user registration by obtaining a username and password from the user and forwarding the registration request to the UserAuthentication instance. 
	 * @param //scanner the Scanner object for the user input
	 * @return True if registration is successful, false otherwise 
	 * @param //scanner
	 */
	private static void registerUser() {
		input.nextLine();
		System.out.println("Enter your username: ");
		 userName= input.nextLine();

		System.out.println("Enter your password: ");
		 password = input.nextLine();
		/**
		 * now from here use the userName and password to the playerDB or DB to register the player maybe use a set or hash
		 */
		String mes = ANSI_GREEN + "Account Successfully registered" + ANSI_RESET;
		timerString(mes,10);
	}

	public static void timerString(String str, int delayTime){

		for (int i = 0 ; i < str.length() ; i++){
			System.out.print(str.charAt(i));
			try{
				Thread.sleep(delayTime);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method loginUser
	 * 
	 * Handles user login by obtaining a username and password from the user * and forwarding the login request to the UserAuthentication instance. 
	 * @param //scanner The Scanner object for user input.
	 * @return True if login is successful, false otherwise. 
	 *  
	 * @param //scanner
	 */
	private static void loginUser() throws SQLException, GameException {
		input.nextLine();
		System.out.println("Enter your username: ");
		String userNameLog = input.nextLine();

		System.out.println("Enter your password: ");
		String passwordLog = input.nextLine();

		if (userNameLog.equalsIgnoreCase(userName) && passwordLog.equalsIgnoreCase(password)) {
			String succ =ANSI_GREEN +  "Successfully logged in as " + userName + "\n" + ANSI_RESET;
			System.out.println();
			timerString(succ,10);

		reset = -1;
		}
		else {
			String notFounf = ANSI_RED + "Account not found Please! Register an Account" + ANSI_RESET;
			timerString(notFounf ,10);
			reset = 1;
		}
	}

}