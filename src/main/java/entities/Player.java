package entities;

import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity{

	private BufferedImage[][] animations;
	private int aniTick = 0, aniIndex = 0 ,aniSpeed = 20;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;
	private boolean left, up, down, right;
	private float playerSpeed = 1.0f;
	
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		
	}

	
	
	public void update() {
		updatePos();
		updateAnimationTick(playerAction);
		setAnimation();
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, null);
	}
	
	private void updatePos() {
		
		moving = false;
		
		if(left && !right) {
			x -= playerSpeed;
			moving = true;
		}
		if(up && !down) {
			y -= playerSpeed;
			moving = true;
			}
		if(right && !left) {
			x += playerSpeed;
			moving = true;
		}
		if(down && !up) {
			y += playerSpeed;
			moving = true;
			}
		
		
	}

	private void setAnimation() {
		if(moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
		
	}

	private void updateAnimationTick(int i) {
		
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= animations[i].length)
				aniIndex = 0;
		}
		
	}

	
	
	private void loadAnimations() {
		InputStream is = getClass().getResourceAsStream("/SpriteSheet.png");
		try {
			BufferedImage img = ImageIO.read(is);
			
			animations = new BufferedImage[2][12];
			for(int i = 0; i<animations.length; i++)
				for(int j=0;j<animations[i].length;j++)
					animations[i][j] = img.getSubimage(j*100, i*100, 100, 100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}



	public boolean isLeft() {
		return left;
	}



	public void setLeft(boolean left) {
		this.left = left;
	}



	public boolean isUp() {
		return up;
	}



	public void setUp(boolean up) {
		this.up = up;
	}



	public boolean isDown() {
		return down;
	}



	public void setDown(boolean down) {
		this.down = down;
	}



	public boolean isRight() {
		return right;
	}



	public void setRight(boolean right) {
		this.right = right;
	}



	public void resetDirBooleans() {
		left = false;
		up = false;
		right = false;
		down = false;
		
	}
}
