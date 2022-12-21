package dev.MRobinBatman.TileGame.states;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.creatures.player.Player;
import dev.MRobinBatman.TileGame.entities.statics.foodStall;
import dev.MRobinBatman.TileGame.entities.statics.lightPost;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.tile.Tile;
import dev.MRobinBatman.TileGame.worlds.World;

public class GameState extends State {

	private World world;

	// moved to other section <- the part that went with this is @ the parameterized
	// constructor below:
	
	// private Player player;
	// private lightPost lamp;
	// private foodStall stall;

	// Handler gets his own spot because he is important
	protected Handler handler;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt"); // loads the 1st world
		handler.setWorld(world);
		//player = new Player(handler, 100, 100); // generates an instance of the player and starts them at (100,100)
												// (Initializes Player)

		//lamp = new lightPost(handler, 100, 200);
		// stall = new foodStall(handler,400,500);
		

	}

	public void tick() {
		world.tick();
		// removed player and others from gamestate to put into their own method
		// player.tick();
	
		// game.getGameCamera().move(1, 1); fun test, just moves the camera at diagonal
	}

	public void render(Graphics g) {
		// g.drawImage(Assets.dirt,0,0, null); // shows how to show an image
		world.render(g);

	//	player.render(g);

		/*
		 * [IMPORTANT] MAKE SURE YOU ADD INITIALIZED ENTITIES TO THE RENDER SO THEY SHOW
		 * UP YOU DUMMIE
		 */

	//	lamp.render(g);
		// Tile.tiles[0].render(g, 0, 0); // this generates a tile of type 0, which is a
		// grass tile, and renders it at (0,0)

	}

}
