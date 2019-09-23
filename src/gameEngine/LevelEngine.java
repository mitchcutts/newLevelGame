/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 *
 *
 */
package gameEngine;

import java.util.ArrayList;
import java.util.Random;
import levelPieces.*;


public class LevelEngine  {
	//allocate amounts of types of pieces
	private int numNukes=0;
	private int numWarriors=0;
	private int numRocks=3;
	private int numPortals=2;
	private ArrayList<GamePiece> allGamePieces;
	private ArrayList<Integer> openLocations;
	private ArrayList<Rock> onlyDrawables;
	
	public LevelEngine() {
		//constructor
		allGamePieces = new ArrayList<GamePiece>();
		openLocations = new ArrayList<Integer>();
		onlyDrawables = new ArrayList<Rock>();

	}

	public void createLevel(int levelNum) {
		allGamePieces.clear();
		openLocations.clear();
		for(int i=0; i<GameEngine.BOARD_SIZE; i++) {
			openLocations.add(i);
		}
		System.out.println("level: " + levelNum); //display level for player before continuing.


		switch(levelNum)	{ //game increases in difficulty; nuke is added for level two.
		case 1:
			numNukes=0;
			numWarriors=1;
			break;
		case 2:
			numNukes=1;
			numWarriors=1;
			break;
		}

		
		
		Random rand = new Random();
		int r;
		
		//Game pieces are added according to priority, as some added later will replace former game pieces if they have same location
		
		for(int i=0; i<numWarriors; i++) {
			r=rand.nextInt(openLocations.size());
			allGamePieces.add(new Warrior(openLocations.get(r)));
			openLocations.remove(r);
		}
		for(int i=0; i<numNukes; i++) {
			r=rand.nextInt(openLocations.size());
			allGamePieces.add(new Nuke(openLocations.get(r)));
			openLocations.remove(r);
		}
		for(int i=0; i<numPortals; i++) {
			r=rand.nextInt(openLocations.size());
			allGamePieces.add(new Portal(openLocations.get(r)));
			openLocations.remove(r);
		}
	
		
		//only ever one of these game pieces per level:
		r=rand.nextInt(openLocations.size());
		allGamePieces.add(new Treasure(openLocations.get(r)));
		openLocations.remove(r);
		
		r=rand.nextInt(openLocations.size());
		allGamePieces.add(new Door(openLocations.get(r)));
		openLocations.remove(r);
		
		for(int i=0; i<numRocks; i++) {
			r=rand.nextInt(openLocations.size());
			onlyDrawables.add(new Rock(openLocations.get(r)));
			openLocations.remove(r);
		}
	}

	public Drawable[] getBoard() {
		//getBoard function creates board using the pieces and drawable arrays.
		
		Drawable[] board = new Drawable[GameEngine.BOARD_SIZE];
		
		for(int i=0; i<onlyDrawables.size(); i++)	{
			board[onlyDrawables.get(i).getLocation()] = onlyDrawables.get(i);
		}
		
		
		for(int i=0; i<allGamePieces.size(); i++)	{
			board[allGamePieces.get(i).getLocation()] = allGamePieces.get(i);
		}
		
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		//define list of all moving pieces. 
		ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
		
		for(int i=0; i<allGamePieces.size(); i++) {
			GamePiece p = allGamePieces.get(i);
			if(p.isMoveable)	{
				movingPieces.add((Moveable) allGamePieces.get(i));
			
			}
		}
		
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() { //getter for interacting pieces (allGamePieces)
		return allGamePieces;
	}

	public int getPlayerStartLoc() {
		return 0;
	}

}
