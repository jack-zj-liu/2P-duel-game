package dev.fnfse.tilegame.entities.statics;

import java.awt.Graphics;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.gfx.Assets;
import dev.fnfse.tilegame.tiles.Tile;

public class Tree extends StaticEntity
{

	public Tree(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}
