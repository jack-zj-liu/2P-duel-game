package dev.fnfse.tilegame.states;

import java.awt.Graphics;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.entities.creatures.Player;
import dev.fnfse.tilegame.entities.statics.Tree;
import dev.fnfse.tilegame.world.World;

public class GameState extends State
{
	private Player player;
	private World world;
	private Tree tree;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}
	
	public void tick() 
	{
		world.tick();

	}

	public void render(Graphics g)
	{
		world.render(g); 
	} 
	
}
