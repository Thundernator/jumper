package game;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Player player = new Player(300, 300, 800, 600);
		Background bg = new Background(100);
		
		
		Frame f = new Frame(player, bg);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setUndecorated(true);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
//		DisplayMode displayMode = new DisplayMode(800, 600, 16, 75);
//		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice device = environment.getDefaultScreenDevice();
//		
//		device.setFullScreenWindow(f);
//		device.setDisplayMode(displayMode);
		
		long lastFrame = System.currentTimeMillis();
		while(true){
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			player.update(timeSinceLastFrame, f.getUp(), f.getDown(), f.getLeft(), f.getRight());
			bg.update(timeSinceLastFrame, f.getUp(), f.getDown(), f.getLeft(), f.getRight(),player,800);
			
			f.repaintScreen();
			
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}