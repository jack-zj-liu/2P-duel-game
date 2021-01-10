package dev.fnfse.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.gfx.Animation;
import dev.fnfse.tilegame.gfx.Assets;

public class Enemy extends Creature
{
	//Animations
	private Animation anim;
	
	
	public Enemy(Handler handler, float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
		
		//Animations
		anim = new Animation(135, Assets.enemy);

	}

	@Override
	public void tick()
	{
		//Animations
		anim.tick();
		//Movement
		getInput();
		move();
//		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up1)
			yMove = -speed;
		if(handler.getKeyManager().down1)
			yMove = speed;
		if(handler.getKeyManager().left1)
			xMove = -speed;
		if(handler.getKeyManager().right1)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
//				bounds.width, bounds.height);
		
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		return anim.getCurrentFrame();
	}	
}