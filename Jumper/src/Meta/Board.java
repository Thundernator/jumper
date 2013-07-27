package Meta;

import java.awt.*;
import java.awt.event.*;



import javax.swing.*;


public class Board extends JPanel implements ActionListener {

 Timer time;
 Image img;
 
 //EInmal welche Taste 
 int nx,nx2;
 int key,links;
 //Aktuelle X Position des Bildes !
 int x_bild;
 
 
 int anzahl=0 ; 
 int anzahl2=0 ;
 
	public Board() { 
		
		System.out.println("test2");
		nx = 0;
		nx2 = 690;
		
		x_bild = 0;

		setFocusable(true);
		ImageIcon u = new ImageIcon("C:/Java_eclipse/background.jpg");
		img = u.getImage();
		
		
		System.out.println("test3");
		addKeyListener(new AL());
		
		
		time = new Timer(5,this);
		time.start();
		System.out.println("test4");
}

 
	public void actionPerformed(ActionEvent e){
		bewegen();
		repaint();
	}

	public void paint (Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;


		System.out.println("test21341");
		if (getXBild() == 510+(anzahl*2350)){
			anzahl += 1; 
			nx = 0;
			System.out.println("Nx = 0");
		}
		
		
		if (getXBild() == 1690+(anzahl2*2350)){
			anzahl2+= 1;
			nx2= 0;	
		}
		
		if (getXBild() >= 510){
			g2d.drawImage(img, 685-nx, 0,null);
			
		}


		
			g2d.drawImage(img,685 -nx2, 0,null);
			
}
	
	
	private class AL extends KeyAdapter{
		
		 public AL() {
			
			 
			 
		 }
		  
		  //Taste gedrückt
		public void keyReleased(KeyEvent e){
			
			key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT){
				
				links = 0;
			}
			
			if( key == KeyEvent.VK_RIGHT){
				links = 0;
			}
		
			
			}
			
		 public void keyPressed(KeyEvent e){
			 
			 
			 key = e.getKeyCode();
				
				if (key == KeyEvent.VK_LEFT ){
					
					links =-2;
				} 
				
				
				if(key == KeyEvent.VK_RIGHT){
					
					links = 2;
				}
		 
					
		 }}
	
	public void bewegen(){
		
		x_bild += links;
		nx += links;
		nx2 += links;
		
		
	}
	public int getXBild() {
		return x_bild;
	}
	
	
	
	
	}
	
	
	




