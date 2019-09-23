/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 * Extends Gamepiece: Nuke
 */

package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class Nuke extends GamePiece	{
	//extends gamepiece

	Random rand = new Random();
	int n;

	public Nuke(int loc) {
		super('N', 5);
		n =  rand.nextInt(GameEngine.BOARD_SIZE);	
		//give Nuke random initial location
		super.setLocation(loc);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(Math.abs((playerLocation - this.getLocation())) <= 1) {
			//if player lands within one of nuke, player gets nuked
			return InteractionResult.NUKED;
		}
		else {

			if(Math.abs(playerLocation-this.getLocation())<=2)	{
				return InteractionResult.RADIATE;
			//if player lands within two of nuke, player gets radiation warning.
			}

		}
		return InteractionResult.NONE;
	}

}
