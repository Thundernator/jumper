package Meta;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, Runnable{
Spieler p;
Image img;
Timer time;
Thread animator;
int v = 172;
    public Board() {
        p = new Spieler();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("src/Bilder/Unbenannt.png");
        img = i.getImage();
        time = new Timer(5, this); 
        time.start();
    }
    
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }
boolean k = false;
    public void paint(Graphics g) {
        if (p.dy == 1 && k == false)
        {
            k = true;
            animator = new Thread(this);
            animator.start();
        }
        super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            if ((p.getX() - 590) % 2400 == 0){
                p.nx = 0; }
            if ((p.getX() - 1790) % 2400 == 0){
                p.nx2 = 0; }
            g2d.drawImage(img, 685-p.nx2, 0, null);
            if (p.getX() >= 590){
                g2d.drawImage(img, 685-p.nx, 0, null); }
            g2d.drawImage(p.getImage(), p.left, v, null);
    }
    
    private class AL extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
    }
 
    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        
        beforeTime = System.currentTimeMillis();
        while(done == false)
        {
            cycle();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 10 - timeDiff;
            if (sleep < 0){
                sleep = 2; }
            try {
                Thread.sleep(sleep);
            } catch (Exception e){}
            beforeTime = System.currentTimeMillis();
        }
        done = false;
        h = false;
        k = false;
        }
    boolean h = false;
    boolean done = false;
    public void cycle(){
        if (h == false) {
            v--; }
        if (v == 125){
            h = true; }
        if (h == true && v <= 172){
            v++;}
        if (v == 172){
            done = true;
        }
    }
}