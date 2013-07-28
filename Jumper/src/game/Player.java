package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private int worldsize_x;
	private int worldsize_y;
	private BufferedImage look;
	
	public Player(int x, int y, int worldsize_x, int worldsize_y){
		try {
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/raumschiffchen.png"));
		} catch (IOException e) {e.printStackTrace();}
		bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
		f_posx = x;
		f_posy = y;
		this.worldsize_x = worldsize_x;
		this.worldsize_y = worldsize_y;
	}
	
	public void update(float timeSinceLastFrame, boolean up, boolean down, boolean left, boolean right){
		if(up)f_posy-=300*timeSinceLastFrame;
		if(down)f_posy+=300*timeSinceLastFrame;
		if(right)f_posx+=300*timeSinceLastFrame;
		if(left)f_posx-=300*timeSinceLastFrame;
		
		if(f_posx<0)f_posx=0;
		if(f_posy<0)f_posy=0;
		if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;
		if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height;
		
		bounding.x=(int)f_posx;
		bounding.y=(int)f_posy;
		
		System.out.println("x----> " + f_posx);
		System.out.println("y----> " + f_posy);
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	
	public BufferedImage getLook(){
		return look;
	}

	public float getF_posx() {
		return f_posx;
	}

	public float getF_posy() {
		return f_posy;
	}

	
	
}