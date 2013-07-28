package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	private float f_posx;
	private float f_speed;
	private BufferedImage look;

	public Background(float f_speed){
		this.f_speed = f_speed;

		try {
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/weltraum.png"));
		} catch (IOException e) {e.printStackTrace();}
	}

	public void update(float timeSinceLastFrame, boolean up, boolean down, boolean left, boolean right, Player p,int worldsize_x){
		if(p.getF_posx()<100){
			System.out.println("-x");
			if(left)f_posx-=300*timeSinceLastFrame;
		}
		if(p.getF_posx()>worldsize_x-p.getBounding().width-100){
System.out.println("+x");
			if(right)f_posx+=300*timeSinceLastFrame;
		}
	}

	public int getX(){
		return (int)f_posx;
	}

	public BufferedImage getLook(){
		return look;
	}
	//öfaksdjföajsdföljasödlfjaösjdföasjdfölajsdföljasdfölja
	//test1212
}