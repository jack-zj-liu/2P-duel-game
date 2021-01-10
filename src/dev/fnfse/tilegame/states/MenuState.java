package dev.fnfse.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.fnfse.tilegame.Handler;

public class MenuState extends State
{
	public MenuState(Handler handler)
	{
		super(handler);
	}
	
	public void tick()
	{
//		System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
		{
			State.setState(handler.getGame().gameState);
		}
	}
	public void render(Graphics g)
	{

	}
}
