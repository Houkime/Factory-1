package de.dakror.factory.game.world;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import de.dakror.factory.game.Game;
import de.dakror.factory.game.entity.Entity;
import de.dakror.gamesetup.util.Drawable;

/**
 * @author Dakror
 */
public class World implements Drawable
{
	int[][] blocks;
	public int width, height;
	BufferedImage render;
	
	public CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<>();
	
	public int x, y;
	
	public World(int width, int height)
	{
		this.width = width * Tile.SIZE;
		this.height = height * Tile.SIZE;
		blocks = new int[width][height];
		x = y = 0;
		
		init();
	}
	
	public void init()
	{
		for (int i = 0; i < blocks.length; i++)
			for (int j = 0; j < blocks[0].length; j++)
				blocks[i][j] = Tile.stone.ordinal();
		
		generate();
	}
	
	public void render()
	{
		render = new BufferedImage(blocks.length * Tile.SIZE, blocks[0].length * Tile.SIZE, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) render.getGraphics();
		for (int i = 0; i < blocks.length; i++)
		{
			for (int j = 0; j < blocks[0].length; j++)
			{
				g.drawImage(Game.getImage("tile/" + Tile.values()[blocks[i][j]].name() + ".png"), i * Tile.SIZE, j * Tile.SIZE, Tile.SIZE, Tile.SIZE, null);
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		if (render == null) return;
		
		g.drawImage(render, x, y, Game.w);
		
		for (Entity e : entities)
			e.draw(g);
	}
	
	@Override
	public void update(int tick)
	{
		for (Entity e : entities)
		{
			if (e.isDead()) entities.remove(e);
			else e.update(tick);
		}
	}
	
	public void generate()
	{
		Tile[] ores = { Tile.coal_ore, Tile.copper_ore, Tile.gold_ore, Tile.iron_ore };
		for (int i = 0; i < Math.random() * ores.length * 2; i++)
		{
			int radius = (int) Math.round(Math.random() * 2) + 2;
			int index = i % ores.length;
			Point point = new Point((int) (Math.random() * (blocks.length - radius * 2) + radius), (int) (Math.random() * (blocks[0].length - radius * 2) + radius));
			fillCircle(point, radius, ores[index], 0.4f);
		}
	}
	
	public void fillCircle(Point center, int radius, Tile tile, float chance)
	{
		for (int i = -radius; i < radius; i++)
		{
			for (int j = -radius; j < radius; j++)
			{
				try
				{
					if (new Point(i + center.x, j + center.y).distance(center) <= radius && Math.random() <= chance) blocks[i + center.x][j + center.y] = tile.ordinal();
				}
				catch (ArrayIndexOutOfBoundsException e)
				{}
			}
		}
	}
}
