package de.dakror.factory.game.entity.machine.tube;

import java.awt.Color;

import de.dakror.factory.game.entity.Entity;
import de.dakror.factory.game.world.Block;

/**
 * @author Dakror
 */
public class SilverTube extends IronTube
{
	public SilverTube(float x, float y)
	{
		super(x, y);
		speed = 10f;
		color = Color.decode("#3c6d76");
		bgColor = Color.decode("#b1dae1");
		name = "Silber-Rohr";
	}
	
	@Override
	public Entity clone()
	{
		return new SilverTube(x / Block.SIZE, y / Block.SIZE);
	}
}
