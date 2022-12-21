package dev.MRobinBatman.TileGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[]keys, justPressed, cantPress;
	
	public boolean up,down,left,right, enter, j, k, run;
	
	public boolean aUp, aDown, aLeft, aRight;
	
	public void tick() {
		
		for(int i =0; i< keys.length; i++) {
			if(cantPress[i] && !keys[i]) // keys array returns false because  
				cantPress[i] =false;
			else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		
		if(keyJustPressed(KeyEvent.VK_E))
		
			//example of keyjustpressed
			System.out.println("E just pressed");
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
		
		
		enter = keys[KeyEvent.VK_ENTER]; // Navigate menus and attack enimies on map for
											//advantage in encounter
		j = keys[KeyEvent.VK_J];
		k = keys[KeyEvent.VK_K];
		
		
		run = keys[KeyEvent.VK_SHIFT];
		
		
	}
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() < 0 || e.getKeyCode()>= keys.length) // making sure the key is the right one
			return;
		keys[e.getKeyCode()]=true; // listens to see if the key at that keycode was pressed and if so returns true
		
		System.out.println("Pressed the "+e.getKeyCode()+"Key");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}
	

	

}
