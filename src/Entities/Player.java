package Entities;

public class Player {
	  
	private float x;
	private float y;
	private float velX;
	private float velY;
	private int width;
	private int height;
	private boolean falling;
	
	Player() {
		this.x = 30;
		this.y = 30;
		this.velX = 0;
		this.velY = 0;
		
		this.width = 30;
		this.height = 30;
		
		this.falling = false;
	}
	
	void draw() {
		//Insert code to draw the player
		
	}
	
	void update() {
		
		/*
		
		if ( left key is pressed ) {
			this.velX -= 0.5;
		}
		
		if ( right key is pressed ) {
			this.velX += 0.5;
		}
		
		if ( up key is pressed && !this.falling ) {
			this.velY -= 10;
		}
		this.falling = true
		
		*/
		
		this.x+=this.velX;
		this.collide(this.velX, 0);
		this.y+=this.velY;
		this.collide(0,  this.velY);
		
		this.velX /= 0.5;
		this.velY += 2;
		
	}
	
	void collide(float velX, float velY) {
		
	}
	
}
