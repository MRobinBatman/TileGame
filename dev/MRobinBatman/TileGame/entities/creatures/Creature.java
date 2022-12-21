package dev.MRobinBatman.TileGame.entities.creatures;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.Entity;
import dev.MRobinBatman.TileGame.tile.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 300;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 66, DEFAULT_CREATURE_HEIGHT = 64;


	protected float speed;
	protected float xMove;
	protected float yMove;
	public Handler handler;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); // super refers to Entity class
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		this.handler = handler;
	}

	// [ IMPORTANT ] Here is where we check for collisions with entities, inside of
	// move
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();

	}

	public void moveX() {
		if (xMove > 0) { // moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH; // checks for collision when moving
																					// right
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1; // this should make it so the player can become
																		// flush alongside walls and also "bounces" them
																		// out of tiles they can't collide with; the
																		// "-1" is to allow for sliding since the player
																		// wont quite touch the wall I think
			}

		} else if (xMove < 0) { // moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH; // checks for collision when moving left
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x; // this should make it so the player can become
				// flush alongside walls and also "bounces" them
				// out of tiles they can't collide with
			}
		}
	}

	public void moveY() {
		if (yMove < 0) { // moving UP
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) // checks for collision when moving up
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		} else if (yMove > 0) { // moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) // checks for collision when moving down
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
