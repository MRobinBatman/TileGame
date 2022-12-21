package dev.MRobinBatman.TileGame.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.gfx.Text;
import dev.MRobinBatman.TileGame.input.KeyManager;
import dev.MRobinBatman.TileGame.items.Item;

public class Inventory {
	private boolean active = false;
	Handler handler;
	private ArrayList<Item> inventoryItems;

	private int invX = 64, invY = 48, invWidth = 119, invHeight = 118, invListCenterX = invX + 20,
			invListCenterY = invY + invHeight / 2 + 5, invListSpacing = 38;

	private int invImageX = 70, invImageY = 50, // image x and y to use for inventory elements to set how they appear in
												// the
			// pane
			invImageWidth = 32, invImageHeight = 32;

	private int invCountX = 95, invCountY = 75; // position i want the first text to go to

	public int selectedItem = 0; // index of first item

	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();

		// You can play around with adding different things to the starting inventory
		// here:
		addItem(Item.appleItem.createNew(3));

	}

	public void tick() {

		// this is what opens the inventory when you press E
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if (!active)
			return;

		// here is the inventory navigation code
		// this will allow the inventory to be scrolled through
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A))
			selectedItem--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D))
			selectedItem++;

		if (selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;

		else if (selectedItem >= inventoryItems.size())
			selectedItem = 0;

		//
		// this will display what is in the inventory
		// System.out.println("Inventory:");
		// for(Item i : inventoryItems) {
		// System.out.println(i.getName() + " " +i.getCount());
		// }
	}

	public void render(Graphics g) {
		if (!active)
			return;

		g.drawImage(Assets.inventory, invX, invY, invWidth, invHeight, null);

		int len = inventoryItems.size();
		if (len == 0)
			return;

		for (int i = -1; i < 2; i++) {
				if (selectedItem + i < 0 || selectedItem + i >= len)
					continue;
				if (i == 0) {
					Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX,
							invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.fontBangers24);
				} else {
					Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
							invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.fontBangers24);
				}
		}

		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE,
				Assets.fontBangers24);
	}

	// test text for inventory
	// Text.drawString(g, "Apples: " + Item.appleItem.getCount(), invListCenterX,
	// invListCenterY, false, Color.white, Assets.fontRye24);
	// }

	// Inventory methods
	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount()); // adds to the total # if there is one already
				return;
			}
		}
		inventoryItems.add(item);
	}

	// Getters and Setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

}
