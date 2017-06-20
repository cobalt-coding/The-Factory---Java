package Graphics;

import java.awt.image.BufferedImage;
import Graphics.ImageLoader;


public class Assets {

	private static final int  width = 50, height = 50;
	
	
	//Add images to the "res" folder and initiate a variable on the line below as a BufferedImage
	
	//public static BufferedImage
	public static BufferedImage icon, spike, ladder, lCon, rCon, drone, droneAlt;
	
	public static void init(){
		
		// exampleImage = ImageLoader.loadImage("/textures/exampleImage.png");
		 icon = ImageLoader.loadImage("/textures/Icon.png");
		 spike = ImageLoader.loadImage("/textures/spiky.png");
		 ladder = ImageLoader.loadImage("/textures/ladder.png");
		 lCon = ImageLoader.loadImage("/textures/LCon.png");
		 rCon = ImageLoader.loadImage("/textures/RCon.png");
		 drone = ImageLoader.loadImage("/textures/Drone.png"); 
		 droneAlt = ImageLoader.loadImage("/textures/DroneAlt.png");
	}
}