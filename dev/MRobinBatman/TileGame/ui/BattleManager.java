package dev.MRobinBatman.TileGame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.MRobinBatman.TileGame.Handler;

public class BattleManager {
	Handler handler;
	private ArrayList<BattleObject> objects;
	
	
	public BattleManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<BattleObject>();
	}
	public void tick() {
		for(BattleObject o : objects)
			o.tick();
	}
	public void render(Graphics g) {
		for(BattleObject o : objects)
			o.render(g);
	}
	public void onMouseMove(MouseEvent e) {
		for(BattleObject o : objects)
			o.onMouseMove(e);
	}
	public void onMouseRelease(MouseEvent e) {
		for(BattleObject o : objects)
			o.onMouseRelease(e);
	}
	public void addObject(BattleObject o) {
		objects.add(o);
	}
	public void removeObject(BattleObject o) {
		objects.remove(o);
	}
	
	// auto getters and setters not important yet i dont think:
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public ArrayList<BattleObject> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<BattleObject> objects) {
		this.objects = objects;
	}
}
