package dev.fnfse.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.entities.creatures.Enemy;
import dev.fnfse.tilegame.entities.creatures.Player;

public class EntityManager 
{
	private Handler handler;
	private Player player;
	private Enemy enemy;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}		
	};

	
	public EntityManager(Handler handler, Player player, Enemy enemy)
	{
		this.handler = handler;
		this.player = player;
		this.enemy = enemy;
		entities = new ArrayList<Entity>();
		addEntity(player);
		addEntity(enemy);
	}
	
	public void tick()
	{
		for(int i = 0; i < entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g)
	{
		for(Entity e : entities)
		{
			e.render(g);
		}
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	//GETTERS SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
