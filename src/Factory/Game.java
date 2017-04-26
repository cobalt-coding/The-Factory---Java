package Factory;

import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import Display.Display;
import Display.KeyManager;
import Entity.Block;
import Entity.Player;
import Graphics.Assets;

import java.awt.*;

public class Game implements Runnable{
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy buffer;
	private Graphics g;
	Color BlueGreen = new Color(72, 135, 113);
	
	private KeyManager keyManager;
	private Player player;
	private Block block;
	
	private int level = 0;
	
	private ArrayList<ArrayList<Block>> blocks = new ArrayList<ArrayList<Block>>();
	
	private String[][] levels = {
		{
			"....................",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".                  .",
			".         .        .",
			".      .           .",
			"...................."
		}
	};
	
	public Game(String title, int width2, int height2){
		this.width = width2;
		this.height = height2;
		this.title = title;
		keyManager = new KeyManager();
		player = new Player(this, 100, 100);
	}
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		block = new Block(0, 690, 1281, 30, "normal");
		
		for (int i = 0 ; i < levels.length ; i++) {
			blocks.add(new ArrayList<Block>());
			for (int t = 0 ; t < levels[i].length ; t++) {
				for (int j = 0 ; j < levels[i][t].length() ; j++) {
					String blockType = Character.toString(levels[i][t].charAt(j));
					switch(blockType) {
						case ".":
							blocks.get(i).add(new Block(j*30, t*30, 30, 30, "normal"));
					}
				}
			}
		}
		
	}

	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1){
				update();
				render();
				delta--;
			}
		}
		stop();
	}
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		 g = buffer.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
	
		 g.setColor(BlueGreen);
		 g.fillRect(0, 0, 1280, 720);
		
		 player.render(g);
		 block.render(g);
		 
		 for (int i = 0 ; i < blocks.get(level).size() ; i++) {
			 blocks.get(level).get(i).render(g);
		 }
		 
		 buffer.show();
		 g.dispose();
	}

	private void update() {
		keyManager.tick();
		player.tick();
		player.collisionCheck(block);
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
