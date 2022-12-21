package dev.MRobinBatman.TileGame.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.Entity;
import dev.MRobinBatman.TileGame.entities.EntityManager;
import dev.MRobinBatman.TileGame.entities.creatures.enemy.Enemy2;
import dev.MRobinBatman.TileGame.entities.creatures.player.Player;
import dev.MRobinBatman.TileGame.entities.statics.Bench;
import dev.MRobinBatman.TileGame.entities.statics.Tree;
import dev.MRobinBatman.TileGame.entities.statics.bigTree;
import dev.MRobinBatman.TileGame.entities.statics.foodStall;
import dev.MRobinBatman.TileGame.entities.statics.greyAndYellowBins;
import dev.MRobinBatman.TileGame.entities.statics.lightPost;
import dev.MRobinBatman.TileGame.items.Item;
import dev.MRobinBatman.TileGame.items.ItemManager;
import dev.MRobinBatman.TileGame.tile.Tile;
import dev.MRobinBatman.TileGame.utils.Utils;

public class World {

	//things for enemy spawner:
	private int tileNumber=0;
	
	
	
	
	/////
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Game game;
	private Handler handler;

	// Entities
	private EntityManager entityManager;
	private ItemManager itemManager;

	// this is an array that should help fill in the map with some trees at random
	private ArrayList<Entity> entities;

	// enemy manager being tested still
//	private EnemyManger enemyManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

//	public void setEntityManager(EntityManager entityManager) { DONT NEED YET
	// this.entityManager = entityManager;
//	}

	public World(Handler handler, String path) {
		this.handler = handler;

		// Create new entitymanager here:
		entityManager = new EntityManager(handler, new Player(handler, 100, 100), new Enemy2(handler, 100, 300));

		// Creates the new itemmanager in the world here:
		itemManager = new ItemManager(handler);

		// enemyManager = new EnemyManager(handler, new Enemy(handler, 500, 500, 32,
		// 32));
		// enemyManager = new EnemyManger(handler);
		/*
		 * / Here is where you add entities to the manager for use in rendering
		 */
		entityManager.addEntity(new foodStall(handler, 200, 200));
		entityManager.addEntity(new Bench(handler, 400, 400));
		entityManager.addEntity(new greyAndYellowBins(handler, 335, 268));
		entityManager.addEntity(new lightPost(handler, 128, 346));
		entityManager.addEntity(new Tree(handler, 600, 600));
		entityManager.addEntity(new Tree(handler, 280, 334));
		entityManager.addEntity(new Tree(handler, 600, 200));
		entityManager.addEntity(new Tree(handler, 1600, 1600));

		entityManager.addEntity(new bigTree(handler, 1000, 1000));

		// entityManager.addEntity(new Enemy(handler, 600, 300));

		/*
		 * / here is where i will try to construct my array with for-loop to hopefully
		 * cause trees to fill the map using a random number generator
		 */

//
//			for(tile : tiles)
//			if()
//		
//		
//			for (Entity e : entities) {
//				if()
//					
//			}
//		
//		

		// load the world from the world1.txt file
		loadWorld(path);

		// after loading the world you can actually set the player spawn here:
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

		// Trying out adding enemys here // I will also try to spawn them way offscreen
		// and then pull them into the map if that works
		entityManager.getEnemy().setX(6000);
		entityManager.getEnemy().setY(300);
	}

	public void tick() {
		entityManager.tick(); // sends the program tick count to the entities
		itemManager.tick();

		// enemyManager.tick();
	}

	public void render(Graphics g) {

		// this section will make the computer just render what is viewable
		int xStart = Math.max(0, (int) (handler.getGameCamera().getxOffset() / Tile.TILEWIDTH)); // checks to see if
																									// zero
																									// (top left corner
																									// of
																									// the screen) is
																									// bigger
																									// than the width
																									// and
																									// determines where
																									// to
																									// start showing the
																									// map
		int xEnd = Math.min(width,
				(int) (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = Math.max(0, (int) (handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT));
		int yEnd = Math.min(height,
				(int) (handler.getGameCamera().getyOffset() + handler.getWidth()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); // this converts tile size
																								// to
																								// pixels to make the
																								// "width
																								// and height" the
																								// number of
																								// tiles in our
																								// Worlds.txt files
			}
		}
		// RENDERS ITEMS HERE <- which means they appear before the world i think
		itemManager.render(g);

		// [ IMPORTANT ] RENDER ENTITIES BELOW
		entityManager.render(g);

	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	// added more enemy stuff here

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y > height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grassTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); // splits up world file into individual numbers
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); // we set the 1st 4 world elements to
																			// numbers, the rest generate the world
																			// layout
			
				// here is where i will attempt to spawn enemies in
		
				
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

//	public EnemyManger getEnemyManager() {
//		return enemyManager;
//	}
//
//	public void setEnemyManager(EnemyManger enemyManager) {
//		this.enemyManager = enemyManager;
//	}

}
