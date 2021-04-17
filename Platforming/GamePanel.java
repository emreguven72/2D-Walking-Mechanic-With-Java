package Platforming;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Delayed;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements Runnable
{
	static final int Screen_Width = 600;
	static final int Screen_Height = 600;
	static final int unit_Size = 25;
	int x;
	int y;
	boolean running = false;
	Player player;
	Platforms platforms;
	int speed = 10;
	Thread gameThread;
	Image image;
	Graphics graphics;
	
	GamePanel()
	{
		newPlatform();
		newPlayer();
		player.gravityEffect();
		this.setPreferredSize(new Dimension(Screen_Width + unit_Size, Screen_Height + unit_Size));
		this.setFocusable(true);
		this.addKeyListener(new myKeyAdapter());
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void paintComponent(Graphics g)
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	public void draw(Graphics g)
	{
			/*for(int i = 0; i<Screen_Width / unit_Size; i++)
			{
				g.drawLine(i * unit_Size, 0, i * unit_Size, Screen_Height);
				g.drawLine(0, i * unit_Size, Screen_Width, i * unit_Size);
			}*/
			
			platforms.draw(g);
			player.draw(g);
	}
	public void move()
	{
		player.move();
	}
	public void newPlatform()
	{
		platforms = new Platforms(0, Screen_Height, Screen_Width + unit_Size, unit_Size);
	}
	public void checkCollision()
	{
		if(player.intersects(platforms))
		{
			player.y = platforms.y - unit_Size;
		}
		
		if(player.x < 0)
		{
			player.x = 0;
		}
		if(player.x > Screen_Width)
		{
			player.x = Screen_Width;
		}
		if(player.y < 0)
		{
			player.y = 0;
		}
		if(player.y > Screen_Height)
		{
			player.y = Screen_Height;
		}
	}
	public void newPlayer()
	{
		player = new Player(100, (Screen_Height / 2), unit_Size, unit_Size);
	}
	
	public class myKeyAdapter extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			player.keyPressed(e);
		}
		public void keyReleased(KeyEvent e)
		{
			player.keyReleased(e);
		}
	}

	@Override
	public void run() 
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(true)
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta > 1)
			{
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
}
