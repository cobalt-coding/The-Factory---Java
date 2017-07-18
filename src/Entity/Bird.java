package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Factory.Game;
import Graphics.Assets;
import Menu.Menu;
import Misc.Functions;
import Entity.Bullet;

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
	private float playX, playY, yDiff, xDiff;
	private double angle;
	private int timesCalled;
	private Bullet bullet;
	private boolean bullMade;

	
	public Bird(Game game,float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		timesCalled++;
		if(timesCalled == 100){
			timesCalled = 0;
			bullet = new Bullet(this.x + 22, this.y + 19, xDiff, yDiff, angle, game);
			bullMade = true;
		}
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
		
		playX = game.getPlayer().getX();
		playY = game.getPlayer().getY();
		xDiff = x + 20 - playX;
		yDiff = y + 17 - playY;
		angle = Math.atan(xDiff/yDiff);
		if(bullMade){
			bullet.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		if(health <= 0)
			return;
		g.setColor(base);
		if (!alt){
		g.drawImage(Assets.drone, (int) x-5, (int) y-5, null);
		}else{
			g.drawImage(Assets.droneAlt, (int) x-5, (int) y-5, null);
		}
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform droneGun = g2d.getTransform();
		g2d.rotate(angle*-1, x+25, y+22.5);
		g.fillRect((int) x + 20, (int)y+17, 10, 15);
		g2d.setTransform(droneGun);
		if(bullMade){
			bullet.render(g);
		}
	}
	
	public void collisionCheck(float velX, float velY) {
		for (int i = 0 ; i < game.blocks.get(game.level).size() ; i++) {
			 Block block = game.blocks.get(game.level).get(i);
			 if (functions.collide(block.getX(), block.getY(), block.getWidth(), block.getHeight(), x, y, width, height)) {
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
