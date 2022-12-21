package dev.MRobinBatman.TileGame.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text {

	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font) {
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if (center) {
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2; // <- the x position will be the position we passed in subtracted by
													// the pixel width of the string we passed in divided by 2
			y = (yPos - fm.getHeight() / 2) + fm.getAscent(); // the ascent gets what the height of the text should be

		}
		g.drawString(text, x, y);

	}
}
