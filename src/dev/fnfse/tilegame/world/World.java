package dev.fnfse.tilegame.world;

import java.awt.Graphics;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.entities.EntityManager;
import dev.fnfse.tilegame.entities.creatures.Enemy;
import dev.fnfse.tilegame.entities.creatures.Player;
import dev.fnfse.tilegame.entities.statics.Tree;
import dev.fnfse.tilegame.tiles.Tile;
import dev.fnfse.tilegame.utils.Utils;

public class World 
{
	private Handler handler;
	private int width, height;
	private int PspawnX, PspawnY, EspawnX, EspawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	
	public World(Handler handler, String path)
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100), new Enemy(handler, 100, 100));
//		entityManager.addEntity(new Tree(handler, 100, 250));
		
		loadWorld(path);
		
		
		entityManager.getPlayer().setX(PspawnX);
		entityManager.getPlayer().setY(PspawnY);
		entityManager.getEnemy().setX(EspawnX);
		entityManager.getEnemy().setY(EspawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick()
	{
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,  (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart; x < xEnd; x++)
			{
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width | y >= height)
		{
			return Tile.grassTile;
		}
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		PspawnX = Utils.parseInt(tokens[2]);
		PspawnY = Utils.parseInt(tokens[3]);
		EspawnX = Utils.parseInt(tokens[4]);
		EspawnY = Utils.parseInt(tokens[5]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 6]);
			}
		}
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
