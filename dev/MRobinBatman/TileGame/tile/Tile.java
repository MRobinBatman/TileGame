
package dev.MRobinBatman.TileGame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static Stuff Here
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile brickTile = new BrickTile(3);
	
	public static final int TILEWIDTH = 67, TILEHEIGHT = 67;

	protected BufferedImage Texture;
	public final int id;
	public Tile(BufferedImage texture, int id) {
		this.Texture = texture;
		this.id = id;
		tiles[id] = this; 
	}
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(Texture,x,y,TILEWIDTH,TILEHEIGHT,null);
		
	}
	public int getId() {
	return id;
	}
	public boolean isSolid() { // checks to see if it is a solid tile
		return false;
	}


}

