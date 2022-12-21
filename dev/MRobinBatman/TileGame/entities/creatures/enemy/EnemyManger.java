package dev.MRobinBatman.TileGame.entities.creatures.enemy;
//package dev.MRobinBatman.TileGame.entities.creatures.enemy;
//
//import java.util.ArrayList;
//
//import java.util.Iterator;
//
//import dev.MRobinBatman.TileGame.Handler;
//import dev.MRobinBatman.TileGame.entities.creatures.player.Player;
//
//public class EnemyManger {
//
//	private Handler handler;
//	private Enemy enemy;
//	private ArrayList<Enemy> enemies;
// 
//	public EnemyManger(Handler handler) {
//		this.handler = handler;
//		enemies = new ArrayList<Enemy>();
//
//	}
//
//	public void tick() {
//		Iterator<Enemy> eN = enemies.iterator();
//		while (eN.hasNext()) {
//			Enemy e = eN.next();
//			e.tick();
//			if (e.isActive()) {
//				System.out.println("There are " + e.getCount() + "enemies spawned.");
//			}
//			if(!e.isActive()) {
//				eN.remove();
//			}
//		}
//	}
//	public Enemy getEnemy() {
//		return enemy;
//	}
//
//	public void setEnemy(Enemy enemy) {
//		this.enemy = enemy;
//	}
//	
//}
