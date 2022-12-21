package dev.MRobinBatman.TileGame.states;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;

//abstract class

public abstract class State {

	//GameState managing methods
	private static State currentState=null;
	
	public static void setState(State state) { // just a basic state setter. sets the state to the current state
		currentState = state;
	}
	public static State getState() { // the same as a getter
		return currentState;
	}
	
	
	
	//	CLASS
	protected Handler handler;
	//protected Game game;

	/*
	 * here i had to add in an unparameterized state // which i then took out
	 */
	public State(Handler handler) {
		this.handler = handler;
	}
	public abstract void tick();

	public abstract void render(Graphics g);

}
