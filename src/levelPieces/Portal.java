/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 * Extends Gamepiece: Portal
 */

package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class Portal extends GamePiece	{ 

	Random rand = new Random();
	int n;
	
	public Portal(int loc) {
		super('0', 5);
		n =  rand.nextInt(GameEngine.BOARD_SIZE);
		//put portal at random location initially.
		super.setLocation(loc);
	
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			//if player lands on portal, teleport to other portal on map.
			return InteractionResult.TELEPORT;
		}

		return InteractionResult.NONE;
	}
	
	public String toString() {
		return "Portal";
	}

}