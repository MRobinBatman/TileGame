package dev.MRobinBatman.TileGame.entities.creatures.player;

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
import dev.MRobinBatman.TileGame.ui.playerHud;

public class Player extends Creature { // no longer an abstract class

	public boolean testWorked = false;

	/*
	 * Animations
	 */
	private Animation animAttDown, animAttUp, animAttLeft, animAttRight, animAttStill;

	private Animation moveDown, moveUp, moveRight, moveLeft;

	
	private int startHealth= 1000;
	
	// Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

	// Player Inventory
	private Inventory inventory;

	
	// Player Hud
	private playerHud playerHud;
	
	///////////////////////////////////////////////////////////

	private Handler handler; // the tuturial didnt have the guy declaring a private handler here but I had to
								// for it to work

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler; // the reason being is so that here i could set it to the handler so that the
								// movement would work

		
		// health stuff
		
		health = startHealth;
		
		
		// These are the dimensions of the player used for collision detection
		bounds.x = 26; // coordinate relative to top left corner of char image
		bounds.y = 40;// ditto above
		bounds.width = 13;
		bounds.height = 30;

		// Animations declare
		moveDown = new Animation(0, Assets.player_D);
		moveUp = new Animation(0, Assets.player_U);
		moveRight = new Animation(0, Assets.player_R);
		moveLeft = new Animation(0, Assets.player_L);

		animAttDown = new Animation(265, Assets.player_DAtt); // made animations faster, what i did is divide the attack cooldown by the number of frames to get this number
		animAttUp = new Animation(265, Assets.player_UAtt);
		animAttLeft = new Animation(265, Assets.player_LAtt);
		animAttRight = new Animation(265, Assets.player_RAtt);
		
		// animStill = new Animation(1000, Assets.player_D);

		// changing to player 2:

		// animDown = new Animation(500, Assets.player2_D);
		// animUp = new Animation(500, Assets.player2_U);
		// animLeft = new Animation(500, Assets.player2_L);
		// animRight = new Animation(500, Assets.player2_R);

		inventory = new Inventory(handler); // creating a new inventory
		playerHud = new playerHud(handler, health, startHealth);
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

		getInput();

		move();
		handler.getGameCamera().centerOnEntity(this);

		checkAttacks();

		animAttDown.tick();
		animAttUp.tick();
		animAttRight.tick();
		animAttLeft.tick();

		inventory.tick();
		playerHud.tick();
//		if(health<startHealth) {
//			System.out.println("you lost health");
//		}
	}

	private void getInput() {


		
		xMove = 0;
		yMove = 0;
		
		if(inventory.isActive()) // prevents player from moving while in the inventory
			return;
		
		
		// if (handler.getKeyManager().run)
		// speed = speed+1

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	// Here I am testing a run function

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null); // when the player is rendered,
																						// here
		// we have
		// typecast the float to an int
		// this section below visualized the collision box
//		 g.setColor(Color.red);
//		 g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)
//		 (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
//		 bounds.height);

	}

	public void postRender(Graphics g) { // makes sure to put the inventory on top of the rest of the screen when it
											// renders. I will probably have to do this with all my GUI elements
		inventory.render(g);
		playerHud.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) // if we are moving left
			return moveLeft.getCurrentFrame(); // show the current fram in the moving left animation
		else if (xMove > 0)// if moving right
			return moveRight.getCurrentFrame(); // then moving right animation
		else if (yMove < 0) // if move up
			return moveUp.getCurrentFrame(); // then show move up animation
		else if(yMove>0)
			return moveDown.getCurrentFrame();
		
		// attack animation get if press attack, or if press attack and up //
		else if (handler.getKeyManager().aUp) {
			return animAttUp.getCurrentFrame();
		
		} else if (handler.getKeyManager().aDown) {
			return animAttDown.getCurrentFrame();
		} else if (handler.getKeyManager().aLeft ) {
			return animAttLeft.getCurrentFrame();
		} else if (handler.getKeyManager().aRight) {
			return animAttRight.getCurrentFrame();
		} else
			return moveDown.getCurrentFrame();
	}

	@Override
	protected void die() {
		System.out.println("You died");
		handler.getWorld().getItemManager().addItem(Item.appleItem.createNew((int) x, (int) y));
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;
		
		//makes sure the player cant attack if the inventory is open
		if(inventory.isActive()) {
			
		}
		
		
	
	
		//RECTANGLE FOR COLLISION
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		// attack animation set to arrow keys // This is where i add the attack
		// animations? under the if statement

		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().aRight) {
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
				e.hurt(100);
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
	
	public void setStartrHealth(int health) {
		this.startHealth = health;
	}
	public int getStartHealth() {
		return startHealth;
		
	}

}
