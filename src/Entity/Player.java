package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;
import Misc.Functions;

public class Player extends Entity {

	private Game game;
	private Functions functions = new Functions();
	
	private float velx = 0, vely = 0;
	private int width = 40;
	private int height = 30;
	
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
		this.collisionCheck(velx, 0);
		y+=this.vely;
		this.collisionCheck(0, vely);
		
		this.velx/=1.2;
		vely+=0.3;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icon, (int) x-5, (int) y-5, null);
	}
	
	//Experimental, but hopefully improved collision
	public void collisionCheck(float velX, float velY) {
		for (int i = 0 ; i < game.blocks.get(game.level).size() ; i++) {
			 Block block = game.blocks.get(game.level).get(i);
			 if (functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height) && block.type == "normal") {
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
			 if (functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height) && block.type == "spike") {
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
					 //INSERT DEATH CODE HERE PROBABLY
					 System.out.println("REEEEEEEEEEE" + Math.random());
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
