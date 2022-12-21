package dev.MRobinBatman.TileGame.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.gfx.Assets;

import dev.MRobinBatman.TileGame.entities.creatures.player.Player;

public class playerHud {
	private boolean active = true;
	private int hudX = 60, hudY=700, hudWidth = 88, hudHeight = 70, hudCenterX=hudX+30,
			hudCenterY= hudY+hudHeight/2+5, hudListSpacing=40;
	Handler handler;
	Player player;
	
	int playerHealth, startHealth;
	boolean fullHealth =true;
	boolean ninetyPerc= false, eightyPerc= false, seventyPerc = false, sixtyPerc = false,
			fiftyPerc = false, fourtyPerc= false, thirtyPerc= false, twentyPerc = false,
			tenPerc =false, dead= false;
	
	
	private int hudImgX = 70, hudImgY=50;
	
	
	public playerHud(Handler handler, int playerHealth, int startingHealth) {
		this.handler = handler;
		this.playerHealth= playerHealth;
		this.startHealth = startingHealth;
		// getting the total health and current health
		
	}
	
	
	public void tick() {

		
		playerHealth =handler.getWorld().getEntityManager().getPlayer().getHealth();
		
//		System.out.println(playerHealth +" "+ startHealth); // this will print the health remaining out of the total to the console

	}
	public void render(Graphics g) {
		
//		if(!active)
//			return;
		g.drawImage(Assets.playerHud, hudX, hudY, hudWidth, hudHeight, null);
		
		//EmptyHealthBars // 10 slots
//		if(dead =true) {
		g.drawImage(Assets.playerHealthEmpty, hudX+88, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+96, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+104, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+112, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+120, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+128, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+136, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+144, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+152, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthEmpty, hudX+160, hudY+8, 8, 16, null);
//		}
		// playerhudcaphealth
		g.drawImage(Assets.playerHudCap1, hudX+168,hudY+2, 33,22,null);
		
//		//FullHealthBars
		if(fullHealth = true && playerHealth ==startHealth) {
		g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+128, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+136, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+144, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+152, hudY+8, 8, 16, null);
		g.drawImage(Assets.playerHealthFull, hudX+160, hudY+8, 8, 16, null);
		} else if (playerHealth >= startHealth*9/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+128, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+136, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+144, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+152, hudY+8, 8, 16, null);
		} else if (playerHealth >= startHealth*8/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+128, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+136, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+144, hudY+8, 8, 16, null);
		} else if (playerHealth>= startHealth*7/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+128, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+136, hudY+8, 8, 16, null);
		} else if (playerHealth>= startHealth*6/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+128, hudY+8, 8, 16, null);
		} else if (playerHealth>=startHealth*5/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+120, hudY+8, 8, 16, null);
	
		} else if (playerHealth>=startHealth*4/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+112, hudY+8, 8, 16, null);
		
		}else if (playerHealth>=startHealth*3/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+104, hudY+8, 8, 16, null);
	
		} else if (playerHealth>=startHealth*2/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			g.drawImage(Assets.playerHealthFull, hudX+96, hudY+8, 8, 16, null);
			
		} else if (playerHealth>=startHealth*1/10) {
			g.drawImage(Assets.playerHealthFull, hudX+88, hudY+8, 8, 16, null);
			
		}
		
	}
	
}
