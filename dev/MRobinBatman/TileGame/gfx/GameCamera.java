package dev.MRobinBatman.TileGame.gfx;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.Entity;
import dev.MRobinBatman.TileGame.tile.Tile;

public class GameCamera {
	private float xOffset, yOffset;
	private Game game;
	private Handler handler;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2; // this centers the camera at the midpoint of the screen as far as
														// the x-axis is concerned
		yOffset = e.getY() - handler.getHeight() / 2; // this centers the camera at the midpoint of the screen as far as
														// the y-axis is concerned
		checkBlankSpace(); // checks to make sure no blank space is shown when the camera is centered if it
							// can be helped
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public void checkBlankSpace() { // checks to see if there is blank space outside of the game map area that is
									// showing, and then hides it
		if (xOffset < 0)
			xOffset = 0;
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) // if the amound offset
																								// is different than the
																								// world size, then set
																								// the edge to stop
																								// rendering at the
																								// world width ?? I think this kinda explains it
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		if (yOffset < 0)
			yOffset = 0;
		else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())
		yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getWidth();
	}
}
