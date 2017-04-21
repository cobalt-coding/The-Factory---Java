package Entity;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends Entity{
	
	private int width ,height;
	Color BlockColor = new Color(34, 35, 35);

	public Block(float x, float y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void tick() {
	
	}

	@Override
	public void render(Graphics g) {
	g.setColor(BlockColor);
	g.fillRect((int)x, (int)y, width, height);
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

}
