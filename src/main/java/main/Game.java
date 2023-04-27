package main;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable{
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	private Player player;
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
		
	}
	private void initClasses() {
		player = new Player(200,200);
		
	}
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0/FPS_SET;
		double timePerUpdate = 1000000000.0/UPS_SET;
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double uFreq = 0;
		double fFreq = 0;
		
		while(true) {
			
			long currentTime = System.nanoTime();
			
			uFreq += (currentTime - previousTime) / timePerUpdate;
			fFreq += (currentTime - previousTime) / timePerFrame;
			
			previousTime = currentTime;
			
			if(uFreq >= 1) {
				update();
				updates++;
				uFreq--;
			}
		
			
			if(fFreq >= 1) {
				gamePanel.repaint();
				frames++;
				fFreq--;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " UPS: " + updates);
				frames = 0;
				updates= 0;
			}
		}
	}
	
	public Player getPlayer(){
		return player;
	}
	
	private void update() {
		player.update();
		
	}
	
	public void render(Graphics g) {
		player.render(g);
	}
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	public void windowFocusLost() {
		player.resetDirBooleans();
		
	}

}
