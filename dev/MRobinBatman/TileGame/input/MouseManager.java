package dev.MRobinBatman.TileGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.MRobinBatman.TileGame.ui.BattleManager;
import dev.MRobinBatman.TileGame.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{
private boolean leftPressed, rightPressed;
private int mouseX, mouseY;
private  UIManager uiManager;
private BattleManager battleManager;
	public MouseManager(){
		
		}
	//added this to try to make the mouse accessible to the battle screen
	public void setBattleManager(BattleManager battleManager) {
		this.battleManager= battleManager;
	}
	
	public void setUIManger(UIManager uiManager)
	{
		this.uiManager = uiManager;
	}
// GETTERS AND SETTERS
public boolean isLeftPressed() {
	return leftPressed;
}
public boolean isRightPressed(){
	return rightPressed;
}
public int getMouseX() {
	return mouseX;
}
public int getMouseY() {
	return mouseY;
}
	// IMPLIMENTED METHODS
	@Override
	public void mouseDragged(MouseEvent e) {
	
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	 mouseX = e.getX(); // sets our mouse position to a spot on the grid
	 mouseY = e.getY(); // ditto
	 
	 if(uiManager != null) {                       
			uiManager.onMouseMove(e);    // passes on mouse movements to the uiManger
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	if(e.getButton() == MouseEvent.BUTTON1);	
		leftPressed = true;
	if(e.getButton() == MouseEvent.BUTTON3);
		rightPressed = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	if(e.getButton() == MouseEvent.BUTTON1);	
		leftPressed = false;
	if(e.getButton() == MouseEvent.BUTTON3);
		rightPressed = false;
		
	if(uiManager != null) {               //passes mouse events to the UI manager
		uiManager.onMouseRelease(e);
	}
		
	}
		
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

	}


	public void tick() {
		// TODO Auto-generated method stub
		
	}

	
}