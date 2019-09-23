package test;
import gameEngine.*;
import levelPieces.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestInteractions {


	@Test
	public void testDoor() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		Door door = new Door(10);
		gameBoard[10] = door;
		
		assertEquals(InteractionResult.ADVANCE, door.interact(gameBoard, 10));
		
		for(int i=0; i<10; i++)	{
			assertEquals(InteractionResult.NONE, door.interact(gameBoard, i));
		}
		
		for(int i=11; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, door.interact(gameBoard, i));
		}
		
			
		
	}
	
	@Test
	public void testNuke() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		Nuke nuke = new Nuke(10);
		gameBoard[10] = nuke;
		
		assertEquals(InteractionResult.NUKED, nuke.interact(gameBoard, nuke.getLocation()));
		assertEquals(InteractionResult.RADIATE, nuke.interact(gameBoard, nuke.getLocation()+2));
		assertEquals(InteractionResult.RADIATE, nuke.interact(gameBoard, nuke.getLocation()+1));
		assertEquals(InteractionResult.RADIATE, nuke.interact(gameBoard, nuke.getLocation()-1));
		assertEquals(InteractionResult.RADIATE, nuke.interact(gameBoard, nuke.getLocation()-2));
		
		
		for(int i=0; i<nuke.getLocation()-2; i++)	{
			assertEquals(InteractionResult.NONE, nuke.interact(gameBoard, i));
		}
		
		for(int i=nuke.getLocation()+3; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, nuke.interact(gameBoard, i));
		}	
		
		
	}
	
	@Test
	public void testWarrior() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		Warrior warrior = new Warrior(10);
		gameBoard[10] = warrior;
		
		assertEquals(InteractionResult.HIT, warrior.interact(gameBoard, warrior.getLocation()));
		
		assertEquals(InteractionResult.HIT, warrior.interact(gameBoard, warrior.getLocation()-1));
		assertEquals(InteractionResult.HIT, warrior.interact(gameBoard, warrior.getLocation()+1));
		

		
		
		for(int i=0; i<warrior.getLocation()-1; i++)	{
			assertEquals(InteractionResult.NONE, warrior.interact(gameBoard, i));
		}
		
		for(int i=warrior.getLocation()+2; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, warrior.interact(gameBoard, i));
		}	
		
		
	}
	
	@Test
	public void testTreasure() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		Treasure treasure = new Treasure(10);
		gameBoard[10] = treasure;
		
		assertEquals(InteractionResult.GET_POINT, treasure.interact(gameBoard, treasure.getLocation()));
		
		
		

		
		
		for(int i=0; i<treasure.getLocation(); i++)	{
			assertEquals(InteractionResult.NONE, treasure.interact(gameBoard, i));
		}
		
		for(int i=treasure.getLocation()+1; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, treasure.interact(gameBoard, i));
		}	
		
		
	}
	
	@Test
	public void testPortal() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];

		Portal portal = new Portal(10);
		gameBoard[10] = portal;
		
		assertEquals(InteractionResult.TELEPORT, portal.interact(gameBoard, portal.getLocation()));
		
		
		

		
		
		for(int i=0; i<portal.getLocation(); i++)	{
			assertEquals(InteractionResult.NONE, portal.interact(gameBoard, i));
		}
		
		for(int i=portal.getLocation()+1; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, portal.interact(gameBoard, i));
		}	
		
		
	}

}
