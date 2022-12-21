package dev.MRobinBatman.TileGame.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.MRobinBatman.TileGame.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;

	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}

	// the tick here is what check through the items on screen and sees if any have
	// been picked up
	public void tick() {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			i.tick();
			if (i.isPickedUp())
				it.remove(); // <- changing this will add to inventory
		}
	}

	public void render(Graphics g) {
		for (Item i : items) // loops through the items and renders each one
			i.render(g);
	}

	public void addItem(Item i) {
		{
			i.setHandler(handler);
			items.add(i);
		}
	}

	// Getters and Setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
