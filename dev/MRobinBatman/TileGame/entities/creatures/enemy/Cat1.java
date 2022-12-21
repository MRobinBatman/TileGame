package dev.MRobinBatman.TileGame.entities.creatures.enemy;
//package dev.MRobinBatman.TileGame.entities.creatures.enemy;
//
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//import dev.MRobinBatman.TileGame.Handler;
//import dev.MRobinBatman.TileGame.gfx.Animation;
//import dev.MRobinBatman.TileGame.gfx.Assets;
//
//public class Cat1 extends Enemy{
//	Handler handler;
//	private Animation CmoveDown;
//	
//	public Cat1(Handler handler, float x, float y, int width, int height) {
//		super(handler, x, y);
//		this.handler = handler;
//		//bounds.x =0; // coordinate relative to top left corner of char image
//		//bounds.y = 0;// ditto above
//		bounds.width = 32;
//		bounds.height = 32;
//		 CmoveDown = new Animation(0, Assets.cat_D);
////		Animation CmoveUp = new Animation(0, Assets.cat_U);
////		Animation CmoveRight = new Animation(0, Assets.cat_R);
////		Animation CmoveLeft = new Animation(0, Assets.cat_L);
//	}
//
//	public void tick() {
//		
//	}
//	public void render (Graphics g) {
//		g.drawImage(getCurrentAnimationFrame(), (int) (this.xMove - handler.getGameCamera().getxOffset()),
//				(int) (this.yMove - handler.getGameCamera().getyOffset()), width, height, null);
//}
//
//private BufferedImage getCurrentAnimationFrame() {
//	
//	return CmoveDown.getCurrentFrame();
//	
////	if (xMove < 0) // if we are moving left
////		return CmoveLeft.getCurrentFrame(); // show the current fram in the moving left animation
////	else if (xMove > 0)// if moving right
////		return CmoveRight.getCurrentFrame(); // then moving right animation
////	else if (yMove < 0) // if move up
////		return CmoveUp.getCurrentFrame(); // then show move up animation
////	else if(yMove>0)
////		return CmoveDown.getCurrentFrame();
//}
//
//
//public void move() {
//	if(!checkEntityCollisions(xMove, 0f))
//		moveX();
//	if(!checkEntityCollisions(0f, yMove))
//		moveY();
//
//}
//
//}
