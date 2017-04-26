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
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {			
			if(collide){
			vely=0;
			if(game.getKeyManager().up && vely==0){
				vely-=8;
			}
		}
		if(game.getKeyManager().left){
			if(x>0){
				velx-=1.4;
			} else {
				velx = 0;
				x = 0;
			}
		}	
		if(game.getKeyManager().right){
			if(x<1233){
				velx+=1.4;
			} else {
				velx = 0;
				x = 1233;
			}
		}
		x+=this.velx;
		y+=this.vely;
		
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
		
	}
	
}
//Hello
