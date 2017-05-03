package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Assets;



public class Block extends Entity{
	
	private int width ,height;
	Color BlockColor = new Color(34, 35, 35);
	public String type;
	private Assets images = new Assets();

	public Block(float x, float y, int width, int height, String type) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.type = type;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		switch(type) {
			case "normal":
				g.setColor(BlockColor);
				g.fillRect((int)x, (int)y, width, height);
				break;
			case "spike":
				g.drawImage(Assets.spike, (int)x, (int)y, width, height, null);
		}
	}
	
	public int getX(){
		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public String getType() {
		return type;
	}
	
}
