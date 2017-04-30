package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;
import Misc.Functions;

public class Player extends Entity {

	private Game game;
	private boolean collide = true;
	private Functions functions = new Functions();
	
	private float velx = 0, vely = 0;
	private int width = 40;
	private int height = 40;
	
	private boolean falling = false;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {	
		
		if(game.getKeyManager().up && !falling){
			vely-=8;
		}
		this.falling = true;
		
		if (game.getKeyManager().left) {
			if (x>0) {
				velx-=1.4;
			} else {
				velx = 0;
				x = 0;
			}
		}	
		
		if (game.getKeyManager().right) {
			if (x<1233) {
				velx+=1.4;
			} else {
				velx = 0;
				x = 1233;
			}
		}
		
		x+=this.velx;
		this.collisionCheck2(velx, 0);
		y+=this.vely;
		this.collisionCheck2(0, vely);
		
		this.velx/=1.2;
		vely+=0.3;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icon, (int) x, (int) y, null);
	}
	//Planning to remove this in favor of collisionCheck2 later
	public void collisionCheck(Block block){ 
		collide = functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height);
			
	}
	
	//Experimental, but hopefully improved collision
	public void collisionCheck2(float velX, float velY) {
		for (int i = 0 ; i < game.blocks.get(game.level).size() ; i++) {
			 Block block = game.blocks.get(game.level).get(i);
			 if (functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height)) {
				 if (velX > 0) {
					 this.velx = 0;
					 x = block.getX()-width;
				 }
				 if (velX < 0) {
					 this.velx = 0;
					 x = block.getX()+block.getWidth();
				 }
				 if (velY > 0) {
					 this.vely = 0;
					 y = block.getY()-height;
					 falling = false;
				 }
				 if (velY < 0) {
					 this.vely = 0;
					 y = block.getY()+block.getHeight();
					 falling = true;
				 }
			 }
		}
	}
	
}
//Hello
