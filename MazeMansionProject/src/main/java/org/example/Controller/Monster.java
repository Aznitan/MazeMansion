package org.example.Controller;

/**
 * Class: Monster 
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  The Monster class is responsible for managing the attributes and behavior of these related to "Monster"
 * 
 * Methods:
 * +decreaseHealth() : int : This will lower the health of the monster when hit by player.
 * +getMonsterName() : String : This will retrieve the name of the monster from the database and display the name to the player.
 * +getMonsterHealth() : int : This will retrieve the health of the monster from the database and will update the database will the health level changes.
 */
public class Monster {

	/**
	 * Serves as the identifier for the monster, distinguishing one type of creature from another.
	 */
	private String monsterName;
	/**
	 * Reflects the current health or hit points of the monster. It quantifies the monster's ability to withstand damage
	 */
	private int monsterHealth;

	private int attackDamage;

	/**
	 * Method that simulates the reduction of the monster's health when it is subjected to attacks or damage. It calculates and returns the updated health value after the decrease, facilitating combat interactions with the monster.
	 */
	public int decreaseHealth(int damage)
	{
		// TODO - implement Monster.decreaseHealth
		monsterHealth -= attackDamage;
		if (monsterHealth < 0)
		{
			monsterHealth = 0;
		}
		return monsterHealth;
	}

	/**
	 * This method retrieves the name or identifier of the monster. It provides a means for players to identify the specific creature they are facing.
	 */
	public String getMonsterName()
	{
		return this.monsterName;
	}

	/**
	 * Method that allows players to query the monster's current health status.
	 */
	public int getMonsterHealth()
	{
		return this.monsterHealth;
	}

	/**
	 *
	 */
	public int getAttackDamage()
	{
		return attackDamage;
	}
}