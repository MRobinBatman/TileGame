package dev.MRobinBatman.TileGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//import com.sun.swing.internal.plaf.basic.resources.basic; <- idk what this is ill leave it until i am 100% sure

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.creatures.enemy.Enemy2;
import dev.MRobinBatman.TileGame.entities.creatures.player.Player;
import dev.MRobinBatman.TileGame.entities.statics.foodStall;
import dev.MRobinBatman.TileGame.entities.statics.lightPost;

public class EntityManager {
	private Handler handler;
	private Player player;
	private Enemy2 enemy;
	
	private foodStall stall;
	private ArrayList<Entity> entities;
	

	// this is used to sort the render items in an order so you can see when // you
	// walk behind stuff
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getWidth())
				return -1;
			return 1;
		}
	};

	public EntityManager(Handler handler, Player player, Enemy2 enemy) {
		this.handler = handler;
		this.player = player;
		this.enemy = enemy;
		
		
		
		entities = new ArrayList<Entity>();
		addEntity(player);
		
		addEntity(enemy);
	}
	//added here to see if would work?


	public void tick() {
		// for (int i = 0; i < entities.size(); i++) {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if (!e.isActive()) // if the entity died
				it.remove(); // remove it
		}
		entities.sort(renderSorter); // after you tic your player, you find out w
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g); // it goes through the for loop and renders all entities

			// [ BEFORE WORK I WAS HERE TESTING COLLISION

		}
		player.postRender(g); // renders the player inventory screen on top of all other entities
	}

//	 GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	public Enemy2 getEnemy() {
		return enemy;
	}


	public void setEnemy(Enemy2 enemy) {
		this.enemy = enemy;
	}
	
}
