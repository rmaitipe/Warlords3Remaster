package sprite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import launcher.GameMap;

public class MoveAnimation3 extends JPanel {
    private Timer timer = null;
    private boolean stop = false;
    private boolean move = false;
    int xFrameWidth=490;
    int yFrameWidth=490;
    int tileSize=49;
    int xCoord=0;
    int yCoord=0;
	int targX=0;
	int targY=0;
    int xCoordDelta=7;
    int yCoordDelta=7;
    Point goal;
    Animation current;
    int frameCycle=0;
    int pathCount=0;
    int dx = 0; int dy = 0; int i = 0;int j = 0;
    
    private static GameMap gMap;
    private static List<Point> gPath;
    private AStarMoveAnimation2 aStar;
    static JButton buttonD = new JButton("S");
    
    public static void main(String[] args) {
    	gMap=new GameMap(10,10);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    
    public MoveAnimation3(){
    	Sprite sp =new Sprite("Hero/alchemf");
    	BufferedImage[] standingStill = {sp.getSpriteOffset(6, 0)};
    	current = new Animation(standingStill, 10);
    	current.start();
        timer = new Timer(30, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
            	if(!stop) {
            		current.update();
            		repaint();
            		if (move){
            			if (targX==xCoord && targY==yCoord){
            				goal = gPath.get(pathCount);
            				targX=(int) goal.getX()*tileSize;
            				targY=(int) goal.getY()*tileSize;
            				pathCount++;
                			dx=(int)(targX-xCoord)/xCoordDelta;
                            dy=(int)(targY-yCoord)/yCoordDelta;
                            i=0; 
                            j=0;
                            System.out.println("targX " +targX +"targY " +targY);
                            System.out.println("dx " +dx +"dy " +dy);
            			}
            			moveCharByX(dx);
            			moveCharByY(dy);
            			System.out.println("xCoord " +xCoord +"yCoord " +yCoord);
            			if (xCoord==(aStar.getEndGridPoint().getX()*tileSize) && yCoord==(aStar.getEndGridPoint().getY()*tileSize)){
            				move=false;
            				System.out.println("Stop Moving");
            			}
            		}
                    revalidate();
            	}
            	else {
                    ((Timer)e.getSource()).stop();
                }
            }
            
        });
        
        buttonD.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	moveInit();
            	stop=false;
            	move=true;
            	Sprite sp =new Sprite("Hero/alchemf");
            	BufferedImage[] walkingDown = {sp.getSpriteOffset(4, 0), sp.getSpriteOffset(4, 1),
            			sp.getSpriteOffset(4, 2), sp.getSpriteOffset(4, 3)};
            	current = new Animation(walkingDown, 10);
            	current.start();
                timer.start();              // start timer
            	
            }
        });        

    }
    
    private void moveInit() {
    	AStarMoveAnimation2 aStar=new AStarMoveAnimation2();
		aStar.setgMap(gMap);
		Point startPoint = new Point(0,0);
		Point endPoint = new Point(9,9);
		aStar.setStartGridPoint(startPoint);
		aStar.setEndGridPoint(endPoint);
		int gshortest=0;
		int hScore=(int)Point.distance(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		aStar.getOpenMap().put(startPoint, gshortest+hScore);
		aStar.pathFinder(gMap, new Point(0,0));
		gPath =AStarMoveAnimation2.getClosedList();
		frameCycle = gPath.size();
	}

	private static void createAndShowGui() {
	    JFrame frame = new JFrame();
	    frame.add(new MoveAnimation3(), BorderLayout.CENTER);
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
        return new Dimension(490, 490);
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
	
}
