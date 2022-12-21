package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.tile.Tile;

public class lightPost extends StaticEntity{
	Handler handler;
	public lightPost (Handler handler, float x, float y) {
		super(handler, x, y, (int)(Tile.TILEWIDTH /2), (int)(Tile.TILEHEIGHT*1.5)); // [IMPORTANT] THE ENTITY WILL HAVE ALL THE SIZE DATA ALREADY
																// WHAT THIS DOES IS IF YOU DO *2 TO THE TILE HIGHT IS IT WILL RENDER THE ENTITY 2 TIMES AS TALL
		
		this.handler = handler;
		// These are the dimensions of the entity used for collision detection
		bounds.x = 6; // coordinate relative to top left corner of entity image
		bounds.y = 73;// ditto above
		bounds.width = 25;
		bounds.height = 8;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.lampPost, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);;
		g.setColor(Color.cyan);
		g.fillRect(((int)(bounds.x-handler.getGameCamera().getxOffset()))-this.bounds.x, (int) (bounds.y-handler.getGameCamera().getyOffset())-this.bounds.y, bounds.width, bounds.height);
		
	}

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}

}
