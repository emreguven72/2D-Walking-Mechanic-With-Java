package Platforming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platforms extends Rectangle
{
	
	
	Platforms(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
