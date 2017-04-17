package Entity;

import java.awt.Graphics;

public class Block extends Entity{

	public Block(float x, float y) {
		super(x, y);
		
	}

	@Override
	public void tick() {
	
	}

	@Override
	public void render(Graphics g) {
	g.fillRect((int)x, (int)y, 30, 30);
	}

}
