package sprite;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class StillAnimation extends JPanel {
    static JButton button = new JButton("Change");
    static JButton button2 = new JButton("Stop");
    private Timer timer = null;
    private boolean stop = false;
    Animation walkRight;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    
    public StillAnimation(){
    	Sprite sp =new Sprite("Hero/alchemf");
    	BufferedImage[] walkingRight = {sp.getSpriteOffset(6, 0), sp.getSpriteOffset(6, 3)};
	    walkRight = new Animation(walkingRight, 10);
		walkRight.start();
        timer = new Timer(30, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(!stop) {
            		walkRight.update();
            		repaint();
                    revalidate();
            	}
            	else {
                    ((Timer)e.getSource()).stop();
                }
            }
        });


        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=false;
                timer.start();              // start timer
            }
        });
        
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	stop=true;
            }
        });
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new StillAnimation(), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.add(button2, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.walkRight.getSprite(), 0, 0, null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}
