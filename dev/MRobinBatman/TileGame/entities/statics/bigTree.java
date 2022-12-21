package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
//import dev.MRobinBatman.TileGame.entities.creatures.enemy.Enemy;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.items.Item;
import dev.MRobinBatman.TileGame.tile.Tile;

public class bigTree extends StaticEntity{

	Handler handler;
	boolean spawnEnemy =false;
	public bigTree(Handler handler, float x, float y) {
		super(handler, x, y, (int) (Tile.TILEWIDTH), (int) (Tile.TILEHEIGHT));
		this.handler = handler;
		//bounds.x = 0;
		bounds.y = 60;
		//bounds.width = width;
		bounds.height = height -30;
		health= 800;
		
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.BigTree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height+50, null);
		
	}

	@Override
	protected void die() {
		handler.getWorld().getEntityManager().getEnemy().setX(this.x);
		handler.getWorld().getEntityManager().getEnemy().setY(this.y);
	}
	
	public void hurt() {
		System.out.println("Old health" + health);
	}

}
