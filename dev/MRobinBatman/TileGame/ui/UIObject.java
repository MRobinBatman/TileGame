package dev.MRobinBatman.TileGame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {

	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY()))
			hovering = true; // if the area of the UI object contains the mouse in its space  then the mouse is hovering
		else
			hovering = false; // otherwise it is not hovering over the UI object
	}
	public void onMouseRelease(MouseEvent e) {
		if(hovering)
			onClick(); // if you are hovering over the UIObject and the mouse button is clicked (pressed and let go of)
						// then it will call the abstract onClick method
	}
	
	// Getters and Setters
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
