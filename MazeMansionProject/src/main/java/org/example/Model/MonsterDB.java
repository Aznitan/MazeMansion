package org.example.Model;

import org.example.Controller.Monster;

/**
 * Class: MonsterDB
 * @author: Luis Fabela, Cristian Cortez, Jared Oyuela
 * @verison: 1.0 
 * Course ITEC 3860 
 * Written: Oct 5, 2023 
 *  
 * This class is the database for monster that holds all the information of the monsters and will constantly be updated when either the monster losses health and when it is defeated.
 * 
 * Methods:
 * +getMonster(id = int) : Monster : This retrieves the monster from the database using the id of the monster.
 * +getMonsterHealth() : int : This retrieves the health of the monster that updates in the database.
 * +isMonsterDefeated(monsterID : String) : boolean : This checks if the monster has been beaten by the player by the monster id.
 */
public class MonsterDB {

	private SQLiteDB sdb;

	/**
	 * 
	 * @param id
	 */
	public Monster getMonster(int id) {
		// TODO - implement MonsterDB.getMonster
		throw new UnsupportedOperationException();
	}

	public int getMonsterHealth() {
		// TODO - implement MonsterDB.getMonsterHealth
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param monsterID
	 */
	public boolean isMonsterDefeated(String monsterID) {
		// TODO - implement MonsterDB.isMonsterDefeated
		throw new UnsupportedOperationException();
	}

}