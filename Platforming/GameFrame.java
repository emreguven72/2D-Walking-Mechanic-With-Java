package Platforming;

import java.awt.Color;

import javax.swing.*;

public class GameFrame extends JFrame
{
	GameFrame()
	{
		GamePanel panel = new GamePanel();
		this.add(panel);
		this.setTitle("Platforming Game");
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
