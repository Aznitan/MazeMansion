package org.example.View;
import org.example.Controller.*;
import org.example.Model.*;
import java.util.Scanner;
/**
 * Class: LoginAuthentication
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 *  
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * The UserAuthentication class is responsible for user account management, including registration and login, as well as password hashing and verification  
 * Methods : 
 * +UserAuthentication(userDatabase : UserDatabase) : This method verifies user by comparing the information that is in the database. 
 * +registerUser(username : String, password : String) : boolean : This method will receive the information from the user and send it to the database to be stored and used to verify user every time they login. 
 * +loginUser(username : String, password : String) : boolean : This method will prompt user to type in login information.
 * -verifyLogin(password : String, hashedPassword : String) : boolean :  This method will compare what the user types in and what has been saved in the database to see if it matches, if it matches it will allow access, if no match then the user will not be allowed access. 
 *  
 */
public class LoginAuthentication {

	private UserDatabase userDatabase;

	/**
	 * Method UserAuthentication
	 * Initializes the UserAuthentication class with a UserDatabase instance. 
	 * @param userDatabase The UserDatabase instance used for database interactions.
	 *  
	 * @param userDatabase
	 */
	public void UserAuthentication(UserDatabase userDatabase) {
		// TODO - implement LoginAuthentication.UserAuthentication
		throw new UnsupportedOperationException();
	}

	/**
	 * Method registerUser
	 * Registers a new user by adding their username and password to the database. @param username The desired username for registration. 
	 * @param password The password chosen during registration. 
	 * @return True if registration is successful, false if the username already exists.
	 *  
	 * @param username
	 * @param password
	 */
	public boolean registerUser(String username, String password) {
		// TODO - implement LoginAuthentication.registerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * Method loginUser
	 * Logs in a user by checking their username and password in the database. @param username The user's username for login. 
	 * @param password The password provided during login. 
	 * @return True if login is successful, false if the username or password is incorrect.
	 *  
	 * @param username
	 * @param password
	 */
	public boolean loginUser(String username, String password) {
		// TODO - implement LoginAuthentication.loginUser
		throw new UnsupportedOperationException();
	}

	/**
	 * Method verifyLogin
	 * verifies a provided password against a stored hashed and salted password. @param password The password provided during login. 
	 * @param hashedPassword The stored hashed and salted password. 
	 * @return True if the provided password matches the stored password, false otherwise.
	 *  
	 * @param password
	 * @param hashedPassword
	 */
	private boolean verifyLogin(String password, String hashedPassword) {
		// TODO - implement LoginAuthentication.verifyLogin
		throw new UnsupportedOperationException();
	}

}