package sprite;

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

public class MoveAnimation extends JPanel {
    static JButton buttonR = new JButton("Right");
    private Timer timer = null;
    private boolean stop = false;
    int xCoord;
    int yCoord;
    Animation walkRight;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    
    public MoveAnimation(){
    	Sprite sp =new Sprite("Hero/alchemf");
    	BufferedImage[] walkingRight = {sp.getSpriteOffset(2, 0), sp.getSpriteOffset(2, 1),
    			sp.getSpriteOffset(2, 2),sp.getSpriteOffset(2, 3)};
	    walkRight = new Animation(walkingRight, 10);
		walkRight.start();
        timer = new Timer(30, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(!stop) {
            		walkRight.update();
            		repaint();
            		moveChar();
                    revalidate();
            	}
            	else {
                    ((Timer)e.getSource()).stop();
                }
            }
        });


        buttonR.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
                timer.start();              // start timer
            }
        });
    }

	private void moveChar() {
		xCoord=(xCoord+3)%300;
		yCoord+=0%600;
	}
	
	private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new MoveAnimation(), BorderLayout.CENTER);
        frame.add(buttonR, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.walkRight.getSprite(), xCoord, yCoord, null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}
