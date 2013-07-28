package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{
	private Screen screen;
	
	final Player player;
	final Background bg;
	
	
	private boolean key_up = false;
	private boolean key_down = false;
	private boolean key_left = false;
	private boolean key_right = false;
	
	public Frame(Player player, Background bg){
		super("Main");
		screen = new Screen();
		screen.setBounds(0, 0, 800, 600);
		add(screen);
		addKeyListener(new KeyHandler());
		this.player = player;
		this.bg = bg;
	}
	
	
	public boolean getUp(){
		return key_up;
	}
	public boolean getDown(){
		return key_down;
	}
	public boolean getLeft(){
		return key_left;
	}
	public boolean getRight(){
		return key_right;
	}
	
	
	
	public void repaintScreen(){
		screen.repaint();
	}
	
	
	private class Screen extends JLabel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			
			g.drawImage(bg.getLook(), bg.getX(), 0, null);
			g.drawImage(bg.getLook(), bg.getX()+bg.getLook().getWidth(), 0, null);
			
			g.drawImage(player.getLook(), player.getBounding().x, player.getBounding().y, null);
			
		}
	}
	
	private class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S)key_down = true;
			if(e.getKeyCode() == KeyEvent.VK_W)key_up = true;
			if(e.getKeyCode() == KeyEvent.VK_D)key_right = true;
			if(e.getKeyCode() == KeyEvent.VK_A)key_left = true;
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S)key_down = false;
			if(e.getKeyCode() == KeyEvent.VK_W)key_up = false;
			if(e.getKeyCode() == KeyEvent.VK_D)key_right = false;
			if(e.getKeyCode() == KeyEvent.VK_A)key_left = false;
		}

		
		
		
		
		
		//Unnötig
		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
}
