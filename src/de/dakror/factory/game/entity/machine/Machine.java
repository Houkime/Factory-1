package de.dakror.factory.game.entity.machine;

import java.awt.Color;
import java.awt.Graphics2D;

import de.dakror.factory.game.entity.Entity;
import de.dakror.factory.game.world.Block;

/**
 * @author Dakror
 */
public abstract class Machine extends Entity
{
	protected String name;
	
	public Machine(int x, int y, int width, int height)
	{
		super(x * Block.SIZE, y * Block.SIZE);
		this.width = width * Block.SIZE;
		this.height = height * Block.SIZE;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		Color c = g.getColor();
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.black);
		g.drawRect((int) x, (int) y, width, height);
		
		drawIcon(g);
		
		g.setColor(c);
	}
	
	protected abstract void drawIcon(Graphics2D g);
	
	@Override
	protected void tick(int tick)
	{}
	
	@Override
	protected void onReachTarget()
	{}
}
