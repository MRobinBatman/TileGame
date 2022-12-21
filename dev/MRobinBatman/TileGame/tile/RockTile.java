package dev.MRobinBatman.TileGame.tile;

import dev.MRobinBatman.TileGame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile( int id) {
		super(Assets.stone, id);
		
	}
	@Override
	public boolean isSolid() {
		return true; // changed this
	}
}
