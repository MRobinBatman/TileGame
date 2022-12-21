package dev.MRobinBatman.TileGame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.ui.ClickListener;
import dev.MRobinBatman.TileGame.ui.UIImageButton;
import dev.MRobinBatman.TileGame.ui.UIManager;
import dev.MRobinBatman.TileGame.worlds.World;

public class MenuState extends State{

	private World world;
	protected Handler handler;
	private UIManager uiManager;
	
	
	public MenuState(Handler handler) {
		super(handler);
		this.handler = handler;
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManger(uiManager);
		
		
		 //this adds the start button to the main menu
		uiManager.addObject(new UIImageButton(259, 300, 206, 94, Assets.startButton, new ClickListener() {

			@Override
			public void onClick() {	
				
				handler.getMouseManager().setUIManger(null);
				
				State.setState(handler.getGame().gameState); // starts the game when you click the start button
			}}));
		
	}

	@Override
	public void tick() {
		
	
		uiManager.tick();
		
		// TURN THE MAIN MENU OFF AND ON BY COMMENTING ON OR OFF RIGHT BELOW ME
		// handler.getMouseManager().setUIManger(null);
		// State.setState(handler.getGame().gameState);
		
		
		//System.out.println(handler.getMouseManager().getMouseX()+ ", " + handler.getMouseManager().getMouseY());
		// This will show the mouse position in the console
		
		// this is supposed to be what 
		
		/// IDK WHY THIS WONT WORK BUT IT WONT WORK WHEN I TRY TO LOG 2 BUTTON PRESSES BUT TOGETHER IN THIS IF STATMENT
		//if( handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
		//	State.setState(handler.getGame().gameState);
		
		//this is the code that would launch the game with a click
		//if(handler.getMouseManager().isLeftPressed())
				//State.setState(handler.getGame().gameState);
		
		}
	

	@Override
	public void render(Graphics g) {
	
		uiManager.render(g);
		
		//this is the thing that shows where the mouse is with a color
	//	g.setColor(Color.GREEN);
	//	g.fillRect(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(), 15, 15);
	}


}
