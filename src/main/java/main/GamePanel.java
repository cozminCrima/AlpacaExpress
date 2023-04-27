package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private Game game;
	
	public GamePanel(Game game) {
		this.game = game;
		 mouseInputs = new MouseInputs(this);
		 addKeyListener(new KeyboardInputs(this));
		 addMouseListener(mouseInputs);
		 addMouseMotionListener(mouseInputs);
		 setPanelSize();
	}
	
	public void updateGame() {
		
	}
	
	

	private void setPanelSize() {
		Dimension size = new Dimension(1200,600);
		setPreferredSize(size);
		
	}

	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	
	public Game getGame() {
		return game;
	}
	

}
