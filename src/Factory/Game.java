package Factory;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;

import Display.Display;

public class Game implements Runnable{
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy buffer;
	private Graphics g;
	Color BlueGreen = new Color(72, 135, 113);
	
	
	public Game(String title, int width2, int height2){
		this.width = width2;
		this.height = height2;
		this.title = title;
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
		g.fillRect(500, 250, 300, 300);
		
		 
		 buffer.show();
		 g.dispose();
	}

	private void update() {
		
	}

	private void init(){
		display = new Display(title, width, height);
		//Assets.init();
		
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
