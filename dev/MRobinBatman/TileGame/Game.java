package dev.MRobinBatman.TileGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.MRobinBatman.TileGame.display.Display;
import dev.MRobinBatman.TileGame.gfx.Assets;
import dev.MRobinBatman.TileGame.gfx.GameCamera;
import dev.MRobinBatman.TileGame.gfx.ImageLoader;
import dev.MRobinBatman.TileGame.gfx.SpriteSheet;
import dev.MRobinBatman.TileGame.input.KeyManager;
import dev.MRobinBatman.TileGame.input.MouseManager;
import dev.MRobinBatman.TileGame.states.BattleState;
import dev.MRobinBatman.TileGame.states.GameState;
import dev.MRobinBatman.TileGame.states.MenuState;
import dev.MRobinBatman.TileGame.states.SettingsState;
import dev.MRobinBatman.TileGame.states.State;

// IMPLEMENTS RUNNABLE ALLOWS THE THREAD TO BE RUN
public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	private boolean running = false;
	private Thread thread; // [IMPORTANT] THE THREAD ALLOWS THE GAME TO BE RUN ON ITS OWN
	private BufferStrategy bs; // [IMPORTANT] BUFFER IS A HIDDEN SCREEN THAT LOADS WHAT WILL BE ON THE SCREEN
								// BEFORE THE SCREEN DISPLAYS IT TO PREVENT FLICKERING
	private Graphics g;
	
	public long startTime;

	/*
	 * [	STATES	] HERE ARE ALL THE GAMES
	 * 
	 */
	public State gameState; //  we initialize the game as a regular state
	public State menuState;
	public State settingsState;
	public State battleState;
	
	
	/*
	 * [		INPUT	] 
	 * 
	 */
	
	private KeyManager keyManager; // adds the key recognition to the game
	private MouseManager mouseManager; // adds the mouse recognition to the game
	
	/*
	 * [	CAMERA	]
	 * 
	 */
	private GameCamera gameCamera;
	/*
	 * [	HANDLER	]
	 *
	 */
	private Handler handler;
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager(); 
		mouseManager = new MouseManager();  


	}

	/*
	 * [ 	SET THE GAME STATE HERE		]
	 */
	
	private void init() { // Gets things ready for the game// INIT METHOD
		display = new Display(title, width, height); // CREATES THE DISPLAY
		display.getFrame().addKeyListener(keyManager); //Listens for Key inputs
		display.getFrame().addMouseListener(mouseManager);// listens for mouse inputs on frame
		display.getCanvas().addMouseListener(mouseManager); // ditto but mouse inputs on canvas (gameAREA)
		display.getFrame().addMouseMotionListener(mouseManager); // listens for mouse movement on frame
		display.getCanvas().addMouseMotionListener(mouseManager); // ditto on canvas
		Assets.init();
		
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		if (handler != null)
			//System.out.println("there is a handler");
		gameState = new GameState(handler);  // We initialize the game state as a regular state, and then here it changes to a game state
		menuState = new MenuState(handler);
//		battleState = new BattleState(handler);
		settingsState = new SettingsState(handler);
		State.setState(menuState); // starts the game in the game state
		
	}

	private void tick() {
		keyManager.tick();
	
		
		if(State.getState() !=null)
			State.getState().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); // [IMPORTANT] DRAWS GRAPHIC TO THE CANVAS
		// Clear the screen
		g.clearRect(0, 0, width, height);
		/*
		 * [ DRAW HERE ]
		 */
		if(State.getState() !=null)
			State.getState().render(g);

		/*
		 * [ END DRAWING ]
		 */
		bs.show();
		g.dispose();
	}

	public void run() { // <- Most of actual game code // RUN METHOD
		init();

		int fps = 60; // 60 frames per second
		double timePerTick = 1000000000 / fps; // max amount of time allowed to run  the tick and render measured in nanoseconds since it is
												// more specific than seconds
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		startTime=0;

		while (running) {

			now = System.nanoTime(); // sets time in nanoseconds
			startTime = now; // added in here to get the starting time when game launches
			delta += (now - lastTime) / timePerTick; // tells computer when and when not to call the tick and render

			timer += now - lastTime; // adds how much time has passed
			lastTime = now;

			if (delta >= 1) { // this says to render the tick and render if the game started
				tick();
				render();
				ticks++; // did that, so add 1 to the ticks
				delta--; // // this says that if it rendered a frame, then take one away from the render
							// and count
			}
			if (timer >= 1000000000) { // prints out the fps to the console
				
				// right here willl show the fps
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public synchronized void start() { // CALLS THE RUN METHOD
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {

		}
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	
}
