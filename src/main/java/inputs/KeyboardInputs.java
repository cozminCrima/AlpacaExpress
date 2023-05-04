package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;

import static utilz.Constants.Directions.*;

import main.GamePanel;

public class KeyboardInputs implements KeyListener {
	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (gamePanel.getGame().getGameState()) {
		case Menu:
			gamePanel.getGame().getMenu().keyPressed(e);
			break;
		case Gameplay:
			gamePanel.getGame().getPlaying().keyPressed(e);
			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (gamePanel.getGame().getGameState()) {
		case Menu:
			gamePanel.getGame().getMenu().keyReleased(e);
			break;
		case Gameplay:
			gamePanel.getGame().getPlaying().keyReleased(e);
			break;
		default:
			break;

		}

	}

}
