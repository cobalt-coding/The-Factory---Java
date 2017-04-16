package Graphics;

import java.awt.image.BufferedImage;
import Graphics.ImageLoader;


public class Assets {

	private static final int  width = 50, height = 50;
	
	
	//Add images to the "res" folder and initiate a variable on the line below as a BufferedImage
	
	//public static BufferedImage
	public static BufferedImage icon;
	
	public static void init(){
		
		// exampleImage = ImageLoader.loadImage("/textures/exampleImage.png");
		 icon = ImageLoader.loadImage("/textures/Icon.png");
	}
}