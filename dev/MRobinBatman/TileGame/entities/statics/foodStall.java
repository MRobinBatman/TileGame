package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.tile.Tile;

public class foodStall extends StaticEntity{

	/*
	 * [	IMPORTANT LESSON	] 	<- LEARN THIS HERE MICHAEL
	 * - SO, YOU PUT THE SAME INPUT VARIABLES TO FOODSTALL AS PLAYER
	 * AND WHEN YOU TRIED TO ADD IT TO THE WORLD VIA THE .AddENTITY METHOD
	 * BEING USED IN THE WORLD CLASS, IT DIDNT WANT TO WORK
	 * IT WORKS NOW. YAY!
	 */
	
	
	Handler handler;
	public foodStall(Handler handler, float x, float y) {
		super(handler, x, y, (int)(Tile.TILEWIDTH *2), (int)(Tile.TILEHEIGHT*2)); //sizing goes here
		this.handler = handler;
		// These are the dimensions of the player used for collision detection
				//bounds.x = 0; // coordinate relative to top left corner of char image
				bounds.y = 43;// ditto above
				//bounds.width = 63;
				bounds.height = 85;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.foodStall, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	//	g.setColor(Color.cyan);
	//	g.fillRect(((int)(x-handler.getGameCamera().getxOffset())), (int) (y-handler.getGameCamera().getyOffset()), width, height);
	//	System.out.println("the physical coordinates for running into the stall are: "+ bounds.getMinY());
	}

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}
	

}
