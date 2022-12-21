package dev.MRobinBatman.TileGame.entities.creatures.enemy;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dev.MRobinBatman.TileGame.Game;
import dev.MRobinBatman.TileGame.Handler;
import dev.MRobinBatman.TileGame.entities.Entity;
import dev.MRobinBatman.TileGame.entities.creatures.Creature;
import dev.MRobinBatman.TileGame.gfx.Animation;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.inventory.Inventory;
import dev.MRobinBatman.TileGame.items.Item;
import dev.MRobinBatman.TileGame.states.State;
import dev.MRobinBatman.TileGame.states.BattleState;

public class Enemy2 extends Creature { // no longer an abstract class

	public boolean testWorked = false;
	private Inventory playerInv;
	private int playerYVal;
	private int playerXVal;
	/*
	 * Animations
	 */
	// private Animation animAttDown, animAttUp, animAttLeft, animAttRight,
	// animAttStill;

	private Animation moveDown, moveUp, moveRight, moveLeft;

	protected boolean seesPlayer = false;
	public static final int ENEMYWIDTH = 30, ENEMYHEIGHT = 30;
	float distFromP, diffPSizeX, diffPSizeY;
	
	int fullHealthEnemy;
	
	// Adding battle state so collision with entity will start a battle
	BattleState battleState;
	
	protected Rectangle enemyView;

	// Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

	// Player Inventory
	private Inventory inventory;

	///////////////////////////////////////////////////////////

	private Handler handler; // the tuturial didnt have the guy declaring a private handler here but I had to
								// for it to work

	public Enemy2(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler; // the reason being is so that here i could set it to the handler so that the
								// movement would work

//		 These are the dimensions of the player used for collision detection
		bounds.x = 15; // coordinate relative to top left corner of char image
		bounds.y = 15;// ditto above
		bounds.width = 35;
		bounds.height = 30;

		this.health = 600;
		fullHealthEnemy=health;
		
		//Creating the battle state instance with out battleState variable
		
		
		
		// this should be the size of the enemy view distance
		enemyView = new Rectangle((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);

		// Animations declare
		moveDown = new Animation(500, Assets.cat_D);
		moveUp = new Animation(500, Assets.cat_U);
		moveRight = new Animation(500, Assets.cat_R);
		moveLeft = new Animation(500, Assets.cat_L);

		// animAttDown = new Animation(500, Assets.player_DAtt);
		// animAttUp = new Animation(500, Assets.player_UAtt);
		// animAttLeft = new Animation(500, Assets.player_LAtt);
		// animAttRight = new Animation(500, Assets.player_RAtt);

		// animStill = new Animation(1000, Assets.player_D);

		// changing to player 2:

		// animDown = new Animation(500, Assets.player2_D);
		// animUp = new Animation(500, Assets.player2_U);
		// animLeft = new Animation(500, Assets.player2_L);
		// animRight = new Animation(500, Assets.player2_R);

		inventory = new Inventory(handler); // creating a new inventory
	}

	@Override
	public void tick() {
		// Animations // by not ticking them even though they are stored as animations,
		// this fixes the flickering and keeps all the types what they should be to not
		// break the game

		// moveDown.tick();
		// moveUp.tick();
		// moveLeft.tick();
		// moveRight.tick();

		// animStill.tick();
		// move

		// should make it so the enemy "sees" the player if the player walks within his
		// view bounds
//			if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(enemyView)) {
//				seesPlayer = true;
//			}
//
		// this is my simple enemy aI; it used the Euclidean Distance formula to
		// determine the distance from the player, which it then uses to generate a
		// circle around the enemy player. After that, if the player enters that circle,
		// it begins to close the distance from the player down
		for (int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++) {
			diffPSizeX = x - handler.getWorld().getEntityManager().getPlayer().getX(); // took out -width; yay that
																						// fixed it!
			diffPSizeY = y - handler.getWorld().getEntityManager().getPlayer().getY();// took out -height yay that fixed
																						// it!
			distFromP = (float) Math.sqrt((x - handler.getWorld().getEntityManager().getPlayer().getX())
					* (x - handler.getWorld().getEntityManager().getPlayer().getX())
					+ (y - handler.getWorld().getEntityManager().getPlayer().getY())
							* (y - handler.getWorld().getEntityManager().getPlayer().getY()));
		}

		// System.out.println(distFromP); sweet, it works perfectly!
		if (distFromP <= 165) { // set enemy view distance from here

			xMove = ((-1 / distFromP) * diffPSizeX);
			yMove = ((-1 / distFromP) * diffPSizeY);
		} else {
			yMove = 0;
			xMove = 0;
		}

		move();
		// handler.getGameCamera().centerOnEntity(this);

		 checkAttacks();

//			 moveDown.tick();
//			 moveUp.tick();
//			 moveLeft.tick();
//			 moveRight.tick();

		// animAttDown.tick();
		// animAttUp.tick();
		// animAttRight.tick();
		// animAttLeft.tick();

		inventory.tick();

	}

	private void getInput() {

		// xMove = 0;
		// yMove = 0;

		if (inventory.isActive()) // prevents player from moving while in the inventory
			return;

		// if (handler.getKeyManager().run)
		// speed = speed+1
//
//			if (handler.getKeyManager().up)
//				yMove = -speed;
//			if (handler.getKeyManager().down)
//				yMove = speed;
//			if (handler.getKeyManager().left)
//				xMove = -speed;
//			if (handler.getKeyManager().right)
//				xMove = speed;
	}

	// Here I am testing a run function

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); // when the player is rendered,

//			g.setColor(Color.YELLOW);
//			  g.fillOval((int)(x + bounds.x - handler.getGameCamera().getxOffset())-165, (int)
//						 (y + bounds.y - handler.getGameCamera().getyOffset())-165, bounds.width+320,
//						 bounds.height+320);

		// here
		// we have
		// typecast the float to an int
		// this section below visualized the collision box
			 g.setColor(Color.BLUE);
			  g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)
			 (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
			 bounds.height);

	/*
	 * here is where i will try to put in a health bar
	 */
		g.drawImage(Assets.enemyHealthBar,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset())- 35, 76,25,null);

		if(health==fullHealthEnemy) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+35,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+42,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+49,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+56,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthLast,(int) (x - handler.getGameCamera().getxOffset())+63,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);


		} else if(health>=fullHealthEnemy*8/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+35,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+42,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+49,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+56,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*7/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+35,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+42,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+49,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*6/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+35,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+42,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*5/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+35,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*4/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+28,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*3/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+21,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*2/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
			g.drawImage(Assets.enemyHealthMiddle,(int) (x - handler.getGameCamera().getxOffset())+14,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);
		} else if(health>=fullHealthEnemy*1/9) {
			g.drawImage(Assets.enemyHealthFirst,(int) (x - handler.getGameCamera().getxOffset())+6,(int) (y - handler.getGameCamera().getyOffset())- 30, 8, 18, null);

		}
		
	}

	public void postRender(Graphics g) { // makes sure to put the inventory on top of the rest of the screen when it
											// renders. I will probably have to do this with all my GUI elements
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) // if we are moving left
			return moveLeft.getCurrentFrame(); // show the current fram in the moving left animation
		else if (xMove > 0)// if moving right
			return moveRight.getCurrentFrame(); // then moving right animation
		else if (yMove < 0) // if move up
			return moveUp.getCurrentFrame(); // then show move up animation
		else if (yMove > 0)
			return moveDown.getCurrentFrame();
		else
			return moveDown.getCurrentFrame();

		// attack animation get if press attack, or if press attack and up //
//			else if (handler.getKeyManager().aUp) {
//				return animAttUp.getCurrentFrame();
//			
//			} else if (handler.getKeyManager().aDown) {
//				return animAttDown.getCurrentFrame();
//			} else if (handler.getKeyManager().aLeft ) {
//				return animAttLeft.getCurrentFrame();
//			} else if (handler.getKeyManager().aRight) {
//				return animAttRight.getCurrentFrame();
//			} else
//				return moveDown.getCurrentFrame();
	}

	@Override
	protected void die() {
		System.out.println("You Killed it!");
		handler.getWorld().getItemManager().addItem(Item.bottles.createNew((int) x, (int) y));
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		// makes sure the player cant attack if the inventory is open
		if (inventory.isActive()) {

		}

		// RECTANGLE FOR COLLISION
		 Rectangle cb = getCollisionBounds(0, 0); //took out because not needed anymore
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		// attack animation set to arrow keys // This is where i add the attack
		// animations? under the if statement

			if (yMove<0) {
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			} else if (yMove>0) {
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y + cb.height;
			} else if (xMove<0) {
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			} else if (xMove>0) {
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height / 2 - arSize / 2;
			} else {
				return;
			}

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
//				playerXVal = (int) handler.getWorld().getEntityManager().getPlayer().getX();
//				playerYVal = (int) handler.getWorld().getEntityManager().getPlayer().getY();
//				playerInv = handler.getWorld().getEntityManager().getPlayer().getInventory();
//				battleState = new BattleState(handler, playerXVal, playerYVal, playerInv);
//				State.setState(battleState);
				
				//should hurt player if come into contact with enemy
//				System.out.println(handler.getWorld().getEntityManager().getPlayer().getHealth());
				e.hurt(200);
				return;
			}
		}

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
