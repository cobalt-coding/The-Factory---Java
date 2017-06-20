package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;
import Misc.Functions;

public class Enemy extends Entity{	
	
public String type;
private Slime slime;
private Bird bird;
private Game game;

private int width, height;

public Enemy(float x, float y, String type, Game game) {
	super(x, y);
	this.type = type;
	this.game = game;
	switch(type){
	case "slime":
		slime = new Slime(game, x, y);
		width = 40;
		height = 30;
		break;
	case "drone":
		bird = new Bird(game, x, y);
	}
}

@Override
public void tick() {
	switch(type) {
	case "slime":
	 slime.tick();
	 x = slime.x;
	 y = slime.y;
		break;
	case "drone":
	 bird.tick();
	 x = bird.x;
	 y = bird.y;
	}
}

@Override
public void render(Graphics g) {
	switch(type) {
		case "slime":
			slime.render(g);
			break;
		case "drone":
			bird.render(g);
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
