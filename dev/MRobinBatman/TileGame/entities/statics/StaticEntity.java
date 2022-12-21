package dev.MRobinBatman.TileGame.entities.statics;

import java.awt.Graphics;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.Entity;

public abstract class StaticEntity extends Entity{
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x,y,width,height);
	}
}
