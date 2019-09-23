/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 * Drawable Piece: Rock
 *
 */



package levelPieces;

import java.util.Random;

import gameEngine.Drawable;


public class Rock implements Drawable{ //this is the piece that implements drawable.

	Random rand = new Random();
	private int location;
	char symbol = 'R';
	
	public Rock(int loc) {
		
		location =  loc;	
		
		
	}
	
	public int getLocation()
	{
		return location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
		//use Draw function from drawable.
		
	}

}
