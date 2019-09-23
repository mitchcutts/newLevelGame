/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 * Extends Gamepiece: Door
 */

package levelPieces;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class Door extends GamePiece{

	
	Random rand = new Random();
	int n;
	public Door(int loc) {
		super('D', 20);
		n =  rand.nextInt(GameEngine.BOARD_SIZE);	
		//give door random location
		super.setLocation(loc);
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//if player lands on door, then advance to next level.
		if(playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
			
		}
		else {
			return InteractionResult.NONE;
			
		}
	}
}
