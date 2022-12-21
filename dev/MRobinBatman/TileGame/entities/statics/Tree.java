package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.items.Item;
import dev.MRobinBatman.TileGame.tile.Tile;

public class Tree extends StaticEntity{

	Handler handler;
	
	public Tree(Handler handler, float x, float y) {
		super(handler,x,y, (int) (Tile.TILEWIDTH), (int) (Tile.TILEHEIGHT));
		this.handler =handler;
		//bounds.x = 0;
		bounds.y = 60;
		//bounds.width = width;
		bounds.height = height -30;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height+50, null);
		
	}

	@Override
	protected void die() {
		handler.getWorld().getItemManager().addItem(Item.appleItem.createNew((int) x, (int) y));
		
	}

}
