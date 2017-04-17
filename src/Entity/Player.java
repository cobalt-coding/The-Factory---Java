package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;

public class Player extends Entity {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up){
			//Jump physics will have to be put here
			if(y>0){
				y-=3;
			}
		}	
		if(game.getKeyManager().down){
			//only will be used with ladders...maybe a crouch
			if(y<685){
				y+=3;
			}
		}	
		if(game.getKeyManager().left){
			if(x>0){
				x-=3;
			}
		}	
		if(game.getKeyManager().right){
			if(x<1233){
				x+=3;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icon, (int) x, (int) y, null);
	}
	
}
//Hello
