package Meta;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spieler{
    int x, y, dx, dy, nx, nx2, left;
    Image still;
    ImageIcon i = new ImageIcon("src/Bilder/SpielerstehtR.png");
    ImageIcon i2 = new ImageIcon("src/Bilder/SpielerstehtL.png");
    ImageIcon l = new ImageIcon("src/Bilder/Spieler.gif");
    ImageIcon l2 = new ImageIcon("src/Bilder/SpielerL.gif");
    ImageIcon j = new ImageIcon("src/Bilder/Spielerjump.gif");
 
    public Spieler(){
        still = i.getImage();
        left = 150;
        x = 75;
        nx2 = 685;
        nx = 0;
        y = 172;
    }
 
    
    public void move(){
        if (dx != -1){
            if (left + dx <= 150){
                left = left + dx;
                }
                else{   
                    x = x + dx;
                    nx2 = nx2 + dx;
                    nx = nx + dx;
                    }
        }
        else
            {
                if (left + dx > 0)
                    left = left + dx;
            }
    }
    
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Image getImage(){
        return still;
    }
 
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode(); 
    
        if (key == KeyEvent.VK_LEFT){
            dx = -1;
            still = l2.getImage();
        }
        if (key == KeyEvent.VK_RIGHT){
            dx = +1;
            still = l.getImage();
        }
        if (key == KeyEvent.VK_UP){
            dy = 1;
            still = j.getImage();
        }
    }
 
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode(); 
    
        if (key == KeyEvent.VK_LEFT){
            dx = 0;
            still = i2.getImage();
        }
        if (key == KeyEvent.VK_RIGHT){
            dx = 0;
            still = i.getImage();
        }
        if (key == KeyEvent.VK_UP){
            dy = 0;
            still = i.getImage();
        }
    }
}