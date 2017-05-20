package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;
import Menu.Menu;
import Misc.Functions;

public class Slime extends Entity{

	public float health = 10;
	private Menu menu;
	private int direction = 1;
	private Game game;
	private float velx = 0;
	private float vely = 0;
	private int width = 40;
	private int height = 30;
	private Functions functions = new Functions();
	private boolean falling = true;
	
	public Slime(Game game,Menu menu,float x, float y) {
		super(x, y);
		this.menu = menu;
		this.game = game;
	}

	@Override
	public void tick() {
		if(menu.active)
			return;
		velx += .4 * direction;
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
	
	public void collisionCheck(float velX, float velY) {
		for (int i = 0 ; i < game.blocks.get(game.level).size() ; i++) {
			 Block block = game.blocks.get(game.level).get(i);
			 if (functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height) && block.type == "normal") {
				 if (velX > 0) {
					 direction *= -1;
					 x = block.getX()-width;
				 }
				 if (velX < 0) {
					 direction *= -1;
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
					 direction *= -1;
					 x = block.getX()-width;
				 }
				 if (velX < 0) {
					 direction *= -1;
					 x = block.getX()+block.getWidth();
				 }
			 }
		}
	}
}
