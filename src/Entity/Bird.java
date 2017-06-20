package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;
import Menu.Menu;
import Misc.Functions;

public class Bird extends Entity{

	private Functions functions = new Functions();
	private Game game;
	private Menu menu;
	
	private float health = 10;
	public int direction = 1;
	private float velx = 0;
	private float vely = 0;
	private int width = 40;
	private int height = 30;
	private boolean alt = false;
	private Color base = new Color(96, 96, 93);

	
	public Bird(Game game,float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.menu.active)
			return;
		if(health <= 0)
			return;
			velx += .4 * direction;
		x+=this.velx;
		this.collisionCheck(velx, 0);
		y+=this.vely;
		this.collisionCheck(0, vely);
		
		this.velx/=1.2;
		alt = !alt;
	}

	@Override
	public void render(Graphics g) {
		if(health <= 0)
			return;
		g.setColor(base);
		g.fillRect((int) x + 20, (int)y+17, 10, 15);
		if (!alt){
		g.drawImage(Assets.drone, (int) x-5, (int) y-5, null);
		}else{
			g.drawImage(Assets.droneAlt, (int) x-5, (int) y-5, null);
		}
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
			 //weapon collision here at some point
		}
	}
	public int getX(){
		return (int)x;
	}
	public int getY(){
		return (int)y;
	}
	public int getWidth(){
		return (int)width;
	}
	public int getHeight(){
		return (int)height;
	}

 {

}
}
