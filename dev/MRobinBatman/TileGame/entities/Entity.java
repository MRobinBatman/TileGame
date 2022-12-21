package dev.MRobinBatman.TileGame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 100;
	protected boolean active = true;
	
	public void hurt(int amt) { // entity gets hurt
		health-=amt; // health is subtracted
		System.out.println( amt + "damage done\n"+health+" health remaining.");
		if(health <=0) { // if health falls below zero
			active=false;  // the object is removed from the screen
			die(); // then dies
		}
		}
	
	protected abstract void die();

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	protected float x, y; // the float gives better smooth movement && this is for the position
	protected int width, height; // for drawing images in different sizes
	protected Game game;
	private Handler handler;
	protected Rectangle bounds;
	protected int health, startHealth;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		startHealth = health = DEFAULT_HEALTH; // i added the starting health
		bounds = new Rectangle(0, 0, width, height);

	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue; // prevents checking for collision with self
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;

	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
