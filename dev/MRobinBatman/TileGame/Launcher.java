package dev.MRobinBatman.TileGame;

import dev.MRobinBatman.TileGame.display.Display;

class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Title", 800, 800); // stores game object in a new variable called game
		game.start();
	}

}
