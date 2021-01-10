package dev.fnfse.tilegame.entities.statics;

import dev.fnfse.tilegame.Handler;
import dev.fnfse.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity
{
	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
	}
}
