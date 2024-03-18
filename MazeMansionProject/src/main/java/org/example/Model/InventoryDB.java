package org.example.Model;

import org.example.Controller.Item;

import java.util.List;

/**
 * Class: InventoryDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023
 * This class is the item inventory, this is constantly updated when the player approaches a room and an item is found and is either picked up or dropped.
 * 
 * Methods:
 * +InventoryDB() : This is the no argument constructor of the inventory database class.
 * +removeItem(item : Item) : void : This will remove items from the inventory when player wants to use the item or drop the item.
 * +checkInventory() : List<Item> : This will check what items are in the inventory.
 * +sortInventory() : void : This will organize the items in the inventory when items are added or dropped.
 * +addItem(item : Item) : void : This will allow items to be added to inventory.
 * +useItem(item : Item) : void : This will allow to remove items from the inventory to be used.
 * +saveInventory() : void : This will save the inventory when the user saves and exits the game.
 * +loadInventory() : void : This will show what is in the inventory when the game is reopened from where it was saved.
 */
public class InventoryDB {

	public InventoryDB() {
		// TODO - implement InventoryDB.InventoryDB
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		// TODO - implement InventoryDB.removeItem
		throw new UnsupportedOperationException();
	}

	public List<Item> checkInventory() {
		// TODO - implement InventoryDB.checkInventory
		throw new UnsupportedOperationException();
	}

	public void sortInventory() {
		// TODO - implement InventoryDB.sortInventory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement InventoryDB.addItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void useItem(Item item) {
		// TODO - implement InventoryDB.useItem
		throw new UnsupportedOperationException();
	}

	public void saveInventory() {
		// TODO - implement InventoryDB.saveInventory
		throw new UnsupportedOperationException();
	}

	public void loadInventory() {
		// TODO - implement InventoryDB.loadInventory
		throw new UnsupportedOperationException();
	}

}