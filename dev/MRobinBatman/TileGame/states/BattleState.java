package dev.MRobinBatman.TileGame.states;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.inventory.Inventory;
import dev.MRobinBatman.TileGame.ui.BattleButton;
import dev.MRobinBatman.TileGame.ui.BattleManager;
import dev.MRobinBatman.TileGame.ui.ClickListener;
import dev.MRobinBatman.TileGame.ui.UIImageButton;
import dev.MRobinBatman.TileGame.ui.UIManager;
import dev.MRobinBatman.TileGame.worlds.World;

public class BattleState extends State {

	private World world;
	protected Handler handler;
	private BattleManager battleManager;
	private int playerXPos;
	private int playerYPos;
	private Inventory playerInv;
	
	
	
	public BattleState(Handler handler, int x, int y, Inventory i) {
		super(handler);
		this.handler = handler;

		// first i think it will need to store the player's location so that i can put
		// them back where they were if they lose the battle
		this.playerXPos = x;
		this.playerYPos = y;
		this.playerInv = handler.getWorld().getEntityManager().getPlayer().getInventory();
		// attempting to go to the new battlemap for the battle to take place
		world = new World(handler, "res/worlds/battleMap1");
		handler.setWorld(world);

//		// this should add the mouse clicker to the battle state for choosing options
//		battleManager = new BattleManager(handler);
//		handler.getMouseManager().setBattleManager(battleManager);
//
//	
//	// this is how the uImanager did the clicker
//		 //this adds the start button to the main menu
//		//	battleManager.addObject(new BattleButton(259, 300, 206, 94, Assets.startButton, new ClickListener() {
//
//				@Override
//				public void onClick() {	
//					
//					handler.getMouseManager().setUIManger(null);
//					
//					State.setState(handler.getGame().gameState); // starts the game when you click the start button
//				}}));
//	
	}

	@Override
	public void tick() {
		world.tick();
		battleManager.tick();

	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		battleManager.render(g);

	}

}
