package dev.fnfse.tilegame.tiles;

import dev.fnfse.tilegame.gfx.Assets;

public class RockTile extends Tile
{
	public RockTile(int id)
	{
		super(Assets.stone, id);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}