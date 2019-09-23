/**
 *Mitchell Cutts, Jared Hamilton, 11:00 Section
 * 
 * Implements Moveable: Warrior
 */

package levelPieces;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.lang.Math;

public class Warrior extends GamePiece implements Moveable { 
	//moveable piece
	Random rand = new Random();
	int n;
	
	
	public Warrior(int loc)  {
		super('W', 0);
		n =  rand.nextInt(GameEngine.BOARD_SIZE);		
		//initialize warrior to random location
		super.setLocation(loc);
		super.isMoveable = true;
	}

	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		System.out.println(Math.abs((playerLocation - this.getLocation())));
		if(Math.abs((playerLocation - this.getLocation())) == 1) { 
			//if warrior is exactly 1 space of player, hit player and respawn somewhere else.
			//if player lands on warrior, player "defeats" warrior and warrior gets respawned somewhere else.
			
			while(Math.abs((playerLocation - this.getLocation())) <= 1)	{
				n = rand.nextInt(GameEngine.BOARD_SIZE);
				this.setLocation(n);
			}
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}
	
	public void move(Drawable[] gameBoard, int playerLocation)	{
		//move warrior one location place closer to the player every round.
		
		if(playerLocation>this.getLocation()) {
			this.setLocation(this.getLocation()+1);
		}	else	
		
			if (playerLocation<this.getLocation())	{
			this.setLocation(this.getLocation()-1);
		}
			
		
	}	
	

}
