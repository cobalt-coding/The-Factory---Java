package Factory;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Launcher {
	
	public static void main(String [] args){	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Game game = new Game("The Factory", (int)width, (int)height);
		game.start();	}
}
	
    