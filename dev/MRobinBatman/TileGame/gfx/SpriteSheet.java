package dev.MRobinBatman.TileGame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet=sheet;
	}
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height); // this cuts out a new bufferedImage of just the area specified
	}
}
