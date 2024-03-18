package org.example.Controller;

import java.util.ArrayList;

/**
 * Class: Player
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * Player class represents the in-game character controlled by the player. It encapsulates essential player-related information, including the player's name, health, and current location within the game world. The class also offers methods to interact with the game environment, manage the player's inventory, and update the player's status.
 * 
 * Methods:
 * +interact() : void : This will let players pick up items or hit monsters or solve puzzles.
 * +useItem(item : Item) : void : This will let players use items any way they want to such as pick up, drop item.
 * +addItem(item : Item) : void : This will let player add items to their inventory for later use.
 * +removeItem(item : Item) : void : This will let player remove any items they want from inventory.
 * +updatePlayer() : void : this will update players health or inventory.
 * +getInventory() : ArrayList<Item> : This displays all items in the inventory as a list.
 */
public class Player {

	/**
	 * This attribute holds the name of the player, which serves as the identifier for the in-game character.
	 */
	private String password;
	private String playerName;
	private int playerID;
	/**
	 * playerHealth attribute stores the current health or hit points of the player, reflecting the player's well-being in the game. It can change as the player encounters challenges, such as combat with monsters or environmental hazards.
	 */
	private int playerHealth;
	/**
	 * Tracks the player's current location within the game world. It typically holds the identifier of the room or location the player is in.
	 */
	private int currentRoom;

	/**
	 * inventory of Arraylist
	 */
	private Inventory inventory;

	/**
	 * Player constructor
	 */

	public Player(int playerId, String playerName)
	{
		// the player table is made from playerID, password, playerName, playerLP, currentRoom
		this.playerID = playerID;
		this.password = password;
		this.playerName = this.playerName;
		this.playerHealth = playerHealth;
		this.currentRoom = currentRoom;
		this.inventory = inventory;
	}

	public Player() {

	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}


	public int getPlayerHealth()
	{
		return playerHealth;
	}

	public void setCurrentRoom(int currentRoom)
	{
		this.currentRoom = currentRoom;
	}

	public int getCurrentRoom()
	{
		return currentRoom;
	}

	public void setPlayerHealth(int playerHealth)
	{
		this.playerHealth = playerHealth;
	}

	/**
	 * The interact() method allows the player to interact with elements within the current room or environment. It can trigger events, gather information, or initiate actions relevant to the game's narrative. interact
	 */
	public void interact()
	{
		// TODO - implement Player.interact
		// get current room
		int currentRoom = getCurrentRoom();

		// get items in the current room

//		ArrayList<Item> itemArrayList = currentRoom.getRoom

	}

	/**
	 * This method enables the player to use an item from their inventory. It consumes or applies the item, potentially affecting the game world or the player's status.
	 * @param item
	 */
	public void useItem(Item item)
	{
		// TODO - implement Player.useItem
		System.out.println("You used " + item.getName() + "!");

		//check is item is key
		if (item.isKey())
		{
			System.out.println("You use the key to unlock a door");
		}

		//if item is an health potion
		if (item.isHealthPotion())
		{
			int healingAmount = 3;
			this.playerHealth += healingAmount;
			System.out.println("Player gained " + healingAmount + " health!");
		}

		//check for melee weapon
		if (item.isMeleeWeapon())
		{
			Monster monster = new Monster();
			int meleeDamage = 2;
			if (monster != null)
			{
				System.out.println("Player attacked with " + item.getName() + " and dealt" + meleeDamage + " damage to the monster!");
				monster.decreaseHealth(meleeDamage);
				System.out.println("Monster's health after the attack: " + monster.getMonsterHealth());
			}
		}

		//check for range weapon
		if (item.isRangedWeapon())
		{
			int rangeDamage = 5;
			Monster monster = new Monster();
			if (monster != null)
			{
				System.out.println("Player attacked with " + item.getName() + " and dealt" + rangeDamage + " damage to the monster!");
				monster.decreaseHealth(rangeDamage);
				System.out.println("Monster's health after the attack: " + monster.getMonsterHealth());
			}
		}

		//removes item
		inventory.removeItem(item);

	}

	/**
	 * Allows the player to add an item to their inventory. Items may include tools, weapons, or other objects that assist the player in their journey.
	 * @param item
	 */
	public void addItem(Item item)
	{
		// TODO - implement Player.addItem
		inventory.addItem(item);
	}

	/**
	 * This method removes an item from the player's inventory, typically when the item is consumed, used, or otherwise no longer needed.
	 * @param item
	 */
	public void removeItem(Item item)
	{
		// TODO - implement Player.removeItem
		inventory.removeItem(item);
	}

	/**
	 * This method is responsible for updating the player's attributes, such as health or other relevant player statistics. It can be called in response to in-game events, actions, or decisions made by the player.
	 */
	public void updatePlayer()
	{

		// TODO - implement Player.updatePlayer
		//checks if player has low health and display warning message
		if (playerHealth < 5)
		{
			System.out.println("Warning! You have low health!");
		}

		//using a health potion if it is in the inventory
		Item[] inventory = getInventory();
		for (Item item : inventory)
		{
			if (item.isHealthPotion())
			{
				useItem(item);
				break;
			}
		}

	}

	/**
	 * This method retrieves the player's current inventory, returning a list of items the player is carrying. The inventory is a collection of items that the player can use during the game.
	 */
	public Item[] getInventory()
	{
		// TODO - implement Player.getInventory
		return inventory.getItems();
	}

	/**
	 *
	 */
	public void attackByMonster(Monster monster)
	{
		int damage = monster.getAttackDamage();
		decreasePlayerHealth(damage);
		System.out.println("Oh no! You were attacked by " + monster.getMonsterName() + " and took " + damage + " damage.");
	}

	private void decreasePlayerHealth(int damage)
	{
		playerHealth -= damage;
		if (playerHealth < 0)
		{
			playerHealth = 0;
		}
	}

}