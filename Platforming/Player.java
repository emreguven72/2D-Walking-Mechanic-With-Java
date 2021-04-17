package Platforming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Rectangle
{
	int xVelocity;
	int yVelocity;
	int speed = 5;
	int gravity = 4;
	
	Player(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	public void move()
	{
		x += xVelocity;
		y += yVelocity;
	}
	public void gravityEffect()
	{
		setYDirection(gravity);
		move();
	}
	public void setXDirection(int xDirection)
	{
		xVelocity = xDirection;
	}
	public void setYDirection(int yDirection)
	{
		yVelocity = yDirection;
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			setYDirection(-speed);
			move();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			setYDirection(speed);
			move();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setXDirection(speed);
			move();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setXDirection(-speed);
			move();
		}
	}
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			setYDirection(gravity);
			move();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setXDirection(0);
			move();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setXDirection(0);
			move();
		}
	}
}
