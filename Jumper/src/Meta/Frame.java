package Meta;

import javax.swing.JFrame;




public class Frame {
 
    public Frame(){
        JFrame frame = new JFrame();
        frame.add(new Board());
        frame.setTitle("2D Spiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,365);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        new Frame();
    }
}
 
	
	
 