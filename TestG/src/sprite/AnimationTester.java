package sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AnimationTester {
	
	
	public static void main (String[] args){
		Sprite sp =new Sprite("Hero/alchemf");
		BufferedImage[] walkingLeft = {sp.getSpriteOffset(2, 0), sp.getSpriteOffset(2, 3)}; // Gets the upper left images of my sprite sheet
		BufferedImage[] walkingRight = {sp.getSpriteOffset(6, 0), sp.getSpriteOffset(6, 3)};
		BufferedImage[] walkingUp = {sp.getSpriteOffset(0, 0), sp.getSpriteOffset(0, 3)};
		BufferedImage[] walkingDown = {sp.getSpriteOffset(4, 0), sp.getSpriteOffset(4, 3)};
		BufferedImage[] walkingNE = {sp.getSpriteOffset(1, 0), sp.getSpriteOffset(1, 3)};
		BufferedImage[] walkingSE = {sp.getSpriteOffset(3, 0), sp.getSpriteOffset(3, 3)};
		BufferedImage[] walkingNW = {sp.getSpriteOffset(7, 0), sp.getSpriteOffset(7, 3)};
		BufferedImage[] walkingSW = {sp.getSpriteOffset(5, 0), sp.getSpriteOffset(5, 3)};
		BufferedImage[] standingStill = {sp.getSprite(0, 0, 3, 14)};		
		Animation walkLeft = new Animation(walkingLeft, 10);
		Animation walkRight = new Animation(walkingRight, 10);
		Animation standing1 = new Animation(standingStill, 10);
		 
		JFrame frame = buildFrame();

	     JPanel pane = new JPanel() {
	         @Override
	         protected void paintComponent(Graphics g) {
	             super.paintComponent(g);
	             g.drawImage(walkRight.getSprite(), 0, 0, null);
	        }
	     }; 
	     
		frame.add(pane);
		//frame.getGraphics().drawImage(walkRight.getSprite(), 0, 0, null);
	   	frame.revalidate();
	}
	

 private static JFrame buildFrame() {
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.setSize(600, 300);
     frame.setVisible(true);
     return frame;
 }
	
//	public void mousePressed(MouseEvent e) {
//		Animation animation = walkLeft;
//	    animation.start();
//	}
//
//	public void mouseReleased(MouseEvent e) {
//		Animation animation = walkLeft;
//		animation.stop();
//	    animation.reset();
//	    animation = standing1;
//	}
	
}
