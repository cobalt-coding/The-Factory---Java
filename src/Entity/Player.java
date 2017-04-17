package Entity;

import java.awt.Graphics;

import Factory.Game;
import Graphics.Assets;

public class Player extends Entity {

	private Game game;
	
	private float velx = 0, vely = 0;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up){
			//Jump physics will have to be put here
			if(y>0){
				vely-=1.4;
			} else {
				vely = 0;
				y = 0;
			}
		}	
		if(game.getKeyManager().down){
			//only will be used with ladders...maybe a crouch
			if(y<685){
				vely+=1.4;
			} else {
				vely = 0;
				y = 685;
			}
		}	
		if(game.getKeyManager().left){
			if(x>0){
				velx-=1.4;
			} else {
				velx = 0;
				x = 0;
			}
		}	
		if(game.getKeyManager().right){
			if(x<1233){
				velx+=1.4;
			} else {
				velx = 0;
				x = 1233;
			}
		}
		x+=this.velx;
		y+=this.vely;
		this.velx/=1.2;
		this.vely/=1.2;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icon, (int) x, (int) y, null);
	}
	
}
//Hello
