package dev.MRobinBatman.TileGame.gfx;

import java.awt.Font;
//import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	// Font sizes and fonts
	public static Font fontRye24, fontBangers24;

	
	// background texture size - match to tile size
	private static final int terrainW = 67, terrainH = 67;

	// player size;
	private static final int playerW = 64, playerH = 64;

	// Static variable sizes:
	private static final int lightPostW = 30, lightPostH = 97;
	private static final int enemyW = 62, ememyH = 64;
	private static final int stallW = 63, stallH = 63;
	private static final int castleBaseW = 33, castleBaseH = 33;
	private static final int p2W = 16, p2H = 16;
	private static final int sButtonW = 206, sButtonH = 94;
	private static final int treeW = 63, treeH = 158;
	private static final int catW = 31, catH = 31;
	private static final int hudW = 85, hudH = 70, healthW= 8, healthH=16, hudCapW = 33, hudCapH=24;
	
	// tiles
	public static BufferedImage dirt, grass, stone, brick, water,
			// static entities
			lampPost, enemy, foodStall, Bench, greyYellowBins, tree, BigTree, smallTree;

	// item drops
	public static BufferedImage apple, bookClosed, bottles;

	// Inventory Screens
	public static BufferedImage inventory;
	
	//player HUD
	public static BufferedImage playerHud;
	public static BufferedImage playerHealthEmpty;
	public static BufferedImage playerHealthFull;
	public static BufferedImage playerManaFull;
	public static BufferedImage playerStaminaFull;
	public static BufferedImage playerHudCap1;
	public static BufferedImage playerHudCap2;
	public static BufferedImage playerHudCap3;
	
	//enemyhealthbar
	public static BufferedImage enemyHealthBar;
	public static BufferedImage enemyHealthFirst;
	public static BufferedImage enemyHealthMiddle;
	public static BufferedImage enemyHealthLast;
	
	
	// Animation Button SpriteMaps
	public static BufferedImage[] startButton, startButtonHover;

	// Animation SpriteMaps
	// public static BufferedImage player_D, player_U, player_R, player_L;  //<- this is
	 												// testing to see if I can do movement differently
	public static BufferedImage[] player_DAtt;
	public static BufferedImage[] player_UAtt;
	public static BufferedImage[] player_RAtt;
	public static BufferedImage[] player_LAtt;
	public static BufferedImage[] player_D;
	public static BufferedImage[] player_U;
	public static BufferedImage[] player_R;
	public static BufferedImage[] player_L;

	// animation spritemap 2
	public static BufferedImage[] player2_D;
	public static BufferedImage[] player2_U;
	public static BufferedImage[] player2_R;
	public static BufferedImage[] player2_L;

	public static BufferedImage[] enemy1_D;
	public static BufferedImage[] enemy1_U;
	public static BufferedImage[] enemy1_L;
	public static BufferedImage[] enemy1_R;
	
	public static BufferedImage[] cat_D;
	public static BufferedImage[] cat_U;
	public static BufferedImage[] cat_L;
	public static BufferedImage[] cat_R;

	public static void init() {

		String name;
		/*
		 * Initializing Assets Here
		 */

		// DONT BE A DUMMY, INCLUDE THE FONT FILE EXTENSION WHEN YOU INITIALIZE IT

		// fontRye24 = FontLoader.loadFont("/fonts/Rye-Regular.ttf", 24); // gets the
		// font and sets the size
		fontBangers24 = FontLoader.loadFont("res/fonts/Bangers.ttf", 24);

		SpriteSheet sheetTerrain = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteMap.png.png"));
		SpriteSheet sheetPlayer = new SpriteSheet(ImageLoader.loadImage("/textures/body.png.png")); // test player code
		SpriteSheet sheetPost = new SpriteSheet(ImageLoader.loadImage("/textures/Castle2.png"));
		SpriteSheet sheetSkel = new SpriteSheet(ImageLoader.loadImage("/textures/bodySkel.png.png"));
		SpriteSheet sheetButtons1 = new SpriteSheet(ImageLoader.loadImage("/textures/MainMenu.png"));
		SpriteSheet sheetTree = new SpriteSheet(ImageLoader.loadImage("/textures/Tree.png"));
		SpriteSheet sheetSProps = new SpriteSheet(ImageLoader.loadImage("/textures/InsideProps.png"));
		SpriteSheet sheetInv = new SpriteSheet(ImageLoader.loadImage("/textures/UIImages.png"));
	
		
		
		// SpriteSheet sheetCrow = new SpriteSheet(ImageLoader.loadImage("/textures/Crow.png"));

		// Player 2 stuff
		SpriteSheet sheetPlayer2 = new SpriteSheet(ImageLoader.loadImage("/textures/Knight.png.png"));
		SpriteSheet sheetPlayer3 = new SpriteSheet(ImageLoader.loadImage("/textures/Player3.png"));
		SpriteSheet sheetCat = new SpriteSheet(ImageLoader.loadImage("/textures/cat1.png"));
		
		
		/*
		 * Below here is the assignment of variables
		 */

		// this declares and array of buffered images and crops out each frame of the
		// player to animate him walking
		player_DAtt = new BufferedImage[3];
		player_DAtt[0] = sheetPlayer.crop(playerW, 0, playerW, playerH); // facing down already, wobble right
		player_DAtt[1] = sheetPlayer.crop(playerW * 7, 0, playerW, playerH); // wobble left
		player_DAtt[2] = sheetPlayer.crop(0, 0, playerW, playerH); // then return to center

		player_UAtt = new BufferedImage[3];
		player_UAtt[0] = sheetPlayer.crop(playerW * 5, 0, playerW, playerH);
		player_UAtt[1] = sheetPlayer.crop(playerW * 3, 0, playerW, playerH);
		player_UAtt[2] = sheetPlayer.crop(playerW * 4, 0, playerW, playerH);

		player_RAtt = new BufferedImage[3];
		player_RAtt[0] = sheetPlayer.crop(playerW * 7, 0, playerW, playerH);
		player_RAtt[1] = sheetPlayer.crop(playerW * 5, 0, playerW, playerH);
		player_RAtt[2] = sheetPlayer.crop(playerW * 6, 0, playerW, playerH);

		player_LAtt = new BufferedImage[3];
		player_LAtt[0] = sheetPlayer.crop(playerW, 0, playerW, playerH);
		player_LAtt[1] = sheetPlayer.crop(playerW * 7, 0, playerW, playerH);
		player_LAtt[2] = sheetPlayer.crop(0, 0, playerW, playerH);

		player_DAtt = new BufferedImage[3];
		player_DAtt[0] = sheetPlayer.crop(playerW, 0, playerW, playerH); // facing down already, wobble right
		player_DAtt[1] = sheetPlayer.crop(playerW * 7, 0, playerW, playerH); // wobble left
		player_DAtt[2] = sheetPlayer.crop(0, 0, playerW, playerH); // then return to center
		/////////////////////////////// regular move attempt
		player_U = new BufferedImage[2];
		player_U[0] = sheetPlayer.crop(playerW * 4, 0, playerW, playerH);
		player_U[1] = sheetPlayer.crop(playerW * 4, 0, playerW, playerH);
		player_R = new BufferedImage[2];
		player_R[0] = sheetPlayer.crop(playerW * 6, 0, playerW, playerH);
		player_R[0] = sheetPlayer.crop(playerW * 6, 0, playerW, playerH);
		player_L = new BufferedImage[2];
		player_L[0] = sheetPlayer.crop(playerW*2, 0, playerW, playerH);
		player_L[1] = sheetPlayer.crop(playerW*2, 0, playerW, playerH);
		player_D = new BufferedImage[2];
		player_D[0] = sheetPlayer.crop(0, 0, playerW, playerH);
		player_D[1] = sheetPlayer.crop(0, 0, playerW, playerH);
//			playerWalkRight = sheetPlayer.crop(131, 0, playerW, playerH); //test player code

		// player2_L = new BufferedImage[4];
		// player2_L[0] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[1] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[2] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[3] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);

		// player2_L = new BufferedImage[4];
		// player2_L[0] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[1] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[2] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[3] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);

		// player2_L = new BufferedImage[4];
		// player2_L[0] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[1] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[2] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[3] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);

		// player2_L = new BufferedImage[4];
		// player2_L[0] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[1] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[2] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);
		// player2_L[3] = sheetPlayer2.crop(p2W, p2H, p2W, p2H);

//		 enemy1_D = new BufferedImage[2];
//		 enemy1_D[0] = sheetCrow.crop(0, 16, 15, 16);
//		 enemy1_D[1] = sheetCrow.crop(0, 16, 15, 16);
//		 
//
//		 enemy1_U = new BufferedImage[2];
//		 enemy1_U[0] = sheetCrow.crop(0, 16, 15, 16);
//		 enemy1_U[1] = sheetCrow.crop(0, 16, 15, 16);
//		 
//
//		 enemy1_U = new BufferedImage[2];
//		 enemy1_U[0] = sheetCrow.crop(0, 16, 15, 16);
//		 enemy1_U[1] = sheetCrow.crop(0, 16, 15, 16);
//		
//
//		 enemy1_U = new BufferedImage[2];
//		 enemy1_U[0] = sheetCrow.crop(0, 16, 15, 16);
//		 enemy1_U[1] = sheetCrow.crop(0, 16, 15, 16);
	
			 cat_L = new BufferedImage[4];
			 cat_L[0] = sheetCat.crop(129, 170, catW, catH); //5
			 cat_L[1] = sheetCat.crop(103, 170, catW, catH);
			 cat_L[2] = sheetCat.crop(129, 170, catW, catH);
			 cat_L[3] = sheetCat.crop(161, 170, catW, catH);

			 cat_U = new BufferedImage[4];
			 cat_U[0] = sheetCat.crop(129, 230, catW, catH-5); //7
			 cat_U[1] = sheetCat.crop(96, 230, catW, catH-5);
			 cat_U[2] = sheetCat.crop(129, 230, catW, catH-5);
			 cat_U[3] = sheetCat.crop(159, 230, catW, catH-5);

			 cat_D = new BufferedImage[4];
			 cat_D[0] = sheetCat.crop(136, 128, catW, catH); //4
			 cat_D[1] = sheetCat.crop(96, 128, catW, catH); 
			 cat_D[2] = sheetCat.crop(136, 128, catW, catH);
			 cat_D[3] = sheetCat.crop(167, 128, catW, catH);

			 cat_R = new BufferedImage[4];
			 cat_R[0] = sheetCat.crop(129, 198, catW, catH);  //6
			 cat_R[1] = sheetCat.crop(98, 198, catW, catH);
			 cat_R[2] = sheetCat.crop(129, 198, catW, catH);
			 cat_R[3] = sheetCat.crop(161, 198, catW, catH);
		 
		 
		 

		// BACKGROUND TEXTURES CROPPED TO EACH ACTUAL SQUARE

		grass = sheetTerrain.crop(1, 1, terrainW, terrainH);
		stone = sheetTerrain.crop(1, terrainW, terrainW, terrainH);
		dirt = sheetTerrain.crop(terrainW * 2, 1, terrainW, terrainH);
		// brick = sheetTerrain.crop(135, 168, terrainW, terrainH);

		// SCENERY OBJECTS TO POPULATE MAP

		lampPost = sheetPost.crop(481, 352, lightPostW, lightPostH);
		// System.out.println(lampPost !=null);
		foodStall = sheetPost.crop(1, 288, stallW, stallH);
		Bench = sheetPost.crop(450, 313, 62, 38);
		greyYellowBins = sheetPost.crop(95, 256, 65, 32);

		tree = sheetTree.crop(960, 0, treeW, treeH);
		BigTree = sheetTree.crop(924, 896, 100, 126);
		water = sheetTree.crop(325, 287, 98, 95);
		smallTree = sheetTree.crop(865, 896, 63, 97);
		// water = sheetTree.crop(castleBaseW, ememyH, castleBaseH, lightPostH)

		// Item Drops
		apple = sheetSProps.crop(145, 93, 11, 14);
		bookClosed = sheetSProps.crop(57,34,17,20);
		bottles = sheetSProps.crop(38, 10, 22, 29);
		// ENIMIES MAY GO HERE I THINK
		// enemy = sheetPost.crop(0, 0, enemyW, ememyL);

		// new character idea

		// Buttons for UI
		startButton = new BufferedImage[2];
		startButton[0] = sheetButtons1.crop(0, 0, sButtonW, sButtonH);
		startButton[1] = sheetButtons1.crop(0, 0, sButtonW, sButtonH);

		//inventory Screen
		inventory = sheetInv.crop(314, 292, 119, 118);
	
		// Player HUd
		playerHud = sheetInv.crop(447, 176, hudW, hudH);
		playerHealthEmpty = sheetInv.crop(533, 184, healthW, healthH);
		playerHudCap1 = sheetInv.crop(551,176, hudCapW,hudCapH);
		playerHealthFull = sheetInv.crop(592, 186, healthW, healthH);
		
		//enemyHealth
		enemyHealthBar= sheetInv.crop(258, 62, 76, 25);
		enemyHealthFirst= sheetInv.crop(399,72,8,16);
		enemyHealthMiddle= sheetInv.crop(408, 72,8, 16);
		enemyHealthLast= sheetInv.crop(416, 72, 8, 16);
	}
}
