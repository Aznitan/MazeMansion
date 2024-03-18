package org.example.Controller;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Item {
	private int itemID;
	private String itemName;

	private String itemDescription;

	private String description;


	private boolean isHealthPotion;
	private boolean isMeleeWeapon;
	private boolean isRangedWeapon;
	private boolean isKey;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Item(int itemID, String itemName) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemDescription = getItemDescription();
	}


	public String getName() {

		return itemName;
	}


	public void useItem() {
		// TODO - implement Item.useItem

		System.out.println("Using item: " + itemName);


	}
	//check if an item is a health potion

	public boolean isHealthPotion() {
		return isHealthPotion;
	}

	public boolean isMeleeWeapon() {
		return isMeleeWeapon;
	}

	public boolean isRangedWeapon() {
		return isRangedWeapon;
	}

	public boolean isKey() {
		return isKey;
	}
}