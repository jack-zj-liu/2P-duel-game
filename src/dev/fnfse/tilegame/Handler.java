package dev.fnfse.tilegame;

import dev.fnfse.tilegame.gfx.GameCamera;
import dev.fnfse.tilegame.input.KeyManager;
import dev.fnfse.tilegame.input.MouseManager;
import dev.fnfse.tilegame.world.World;

public class Handler
{
	private Game game;
	private World world;
	
	public Handler(Game game)
	{
		this.game = game;
	}
	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}

	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager()
	{
		return game.getMousemanager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
