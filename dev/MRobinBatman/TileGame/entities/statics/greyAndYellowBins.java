package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.tile.Tile;

public class greyAndYellowBins extends StaticEntity {
	Handler handler;

	public greyAndYellowBins(Handler handler, float x, float y) {
		super(handler, x, y, (int) (Tile.TILEWIDTH), (int) (Tile.TILEHEIGHT));
		this.handler = handler;
		//bounds.x = 10;
		bounds.y = 20;
		bounds.width = width;
		bounds.height = height-25;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.greyYellowBins, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		
	}

}
