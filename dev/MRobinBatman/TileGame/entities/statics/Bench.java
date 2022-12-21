package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.tile.Tile;

public class Bench extends StaticEntity{

	Handler handler;
	public Bench(Handler handler, float x, float y) {
		super(handler, x, y,(int)(Tile.TILEWIDTH), (int)(Tile.TILEHEIGHT));
		this.handler = handler;
		
		//bounds.x = 0;
		bounds.y = 40;
		//bounds.width = width;
		bounds.height = 30;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.Bench, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.cyan);
		//g.fillRect((int)(x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height);
		
	}

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}

}
