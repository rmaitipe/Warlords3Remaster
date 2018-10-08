package test.combat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import sprite.Animation;
import sprite.Sprite;

public class MoveAnimationTester extends JPanel {
    static JButton buttonL = new JButton("W");
    static JButton buttonR = new JButton("E");
    static JButton buttonU = new JButton("N");
    static JButton buttonD = new JButton("S");
    
    static JButton buttonStop = new JButton("Pause");
    private Timer timer = null;
    private boolean stop = false;
    int xFrameWidth=300;
    int yFrameWidth=300;
    int xCoord=0;
    int yCoord=0;
    int xCoordDelta=0;
    int yCoordDelta=0;
    Animation current;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    
    public MoveAnimationTester(){
    	Sprite sp =new Sprite("Hero/alchemf");
    	BufferedImage[] standingStill = {sp.getSprite(0, 0, 3, 14)};
    	current = new Animation(standingStill, 10);
    	current.start();
        timer = new Timer(30, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(!stop) {
            		current.update();
            		repaint();
            		moveCharByX(xCoordDelta);
            		moveCharByY(yCoordDelta);
                    revalidate();
            	}
            	else {
                    ((Timer)e.getSource()).stop();
                }
            }
        });

        buttonL.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
            	xCoordDelta=-3;
            	yCoordDelta=0;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingLeft = {sp.getSpriteOffset(6, 0), sp.getSpriteOffset(6, 1),
            		sp.getSpriteOffset(6, 2), sp.getSpriteOffset(6, 3)};
            	current = new Animation(walkingLeft, 10);
            	current.start();
                timer.start();              // start timer
            }
        });
        
        buttonR.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
            	xCoordDelta=3;
            	yCoordDelta=0;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingRight = {sp.getSpriteOffset(2, 0), sp.getSpriteOffset(2, 1),
            		sp.getSpriteOffset(2, 2), sp.getSpriteOffset(2, 3)};
            	current = new Animation(walkingRight, 10);
            	current.start();
                timer.start();              // start timer
            }
        });
        
        buttonU.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
            	xCoordDelta=0;
            	yCoordDelta=-3;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingUp = {sp.getSpriteOffset(0, 0), sp.getSpriteOffset(0, 1),
            		sp.getSpriteOffset(0, 2), sp.getSpriteOffset(0, 3)};
            	current = new Animation(walkingUp, 10);
            	current.start();
                timer.start();              // start timer
            }
        });
        
        buttonD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
            	xCoordDelta=0;
            	yCoordDelta=3;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingDown = {sp.getSpriteOffset(4, 0), sp.getSpriteOffset(4, 1),
            		sp.getSpriteOffset(4, 2), sp.getSpriteOffset(4, 3)};
            	current = new Animation(walkingDown, 10);
            	current.start();
                timer.start();              // start timer
            }
        });
        
        buttonStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=!stop;
            	xCoordDelta=3;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingDown = {sp.getSpriteOffset(4, 0)};
            	current = new Animation(walkingDown, 10);
            	current.start();
                timer.start();              // start timer
            }
        });
    }

	private void moveCharByX(int xDelta) {
		xCoord=(xCoord+xDelta)%xFrameWidth;
		if (xCoord<0){
			xCoord=xFrameWidth;
		}
	}
	private void moveCharByY(int yDelta) {
		yCoord=(yCoord+yDelta)%yFrameWidth;
		if (yCoord<0){
			yCoord=yFrameWidth;
		}
	}	    
		
	private static void createAndShowGui() {
	    JFrame frame = new JFrame();
	    frame.add(new MoveAnimationTester(), BorderLayout.CENTER);
	    frame.add(buttonR, BorderLayout.EAST);
	    frame.add(buttonL, BorderLayout.WEST);
	    frame.add(buttonU, BorderLayout.NORTH);
	    frame.add(buttonD, BorderLayout.SOUTH);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.current.getSprite(), xCoord, yCoord, null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}
