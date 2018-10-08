package sprite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import launcher.GameMap;

public class MoveAnimation4 extends JPanel {
    private Timer timer = null;
    private boolean stopAnim = false;
    private boolean moveAnim = false;
    int xFrameWidth=490;
    int yFrameWidth=490;
    int tileSize=49;
    int xCoord=0;
    int yCoord=0;
	int targX=0;
	int targY=0;
    int xCoordDelta=7;
    int yCoordDelta=7;
    Point goal, p;
    Animation current;
    int frameCycle=0;
    int pathCount=0;
    int dx = 0; int dy = 0;
			
    private static GameMap gMap;
    private static List<Point> gPath;
    private AStarMoveAnimation2 aStar;
    
    public static void main(String[] args) {
    	gMap=new GameMap(10,10);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    
    public MoveAnimation4(){
//    	 JLabel[][] labelGrid = new JLabel[gMap.getMapTraverse().length][gMap.getMapTraverse()[0].length];
//    	 setLayout(new GridLayout(gMap.getMapTraverse().length, gMap.getMapTraverse()[0].length));
//         for (int r = 0; r < labelGrid.length; r++) {
//            for (int c = 0; c < labelGrid[r].length; c++) {
//               labelGrid[r][c] = new JLabel();
//               labelGrid[r][c].setIcon(Ground.getGround(gMap.getMapTraverse()[r][c]).getIcon());
//               add(labelGrid[r][c]);            
//            }
//         }
    	Sprite sp =new Sprite("Hero/alchemf");
    	BufferedImage[] standingStill = {sp.getSprite(0, 0, 3, 14)};
		BufferedImage[] walkingE = {sp.getSpriteOffset(2, 0), sp.getSpriteOffset(2, 3)};
		BufferedImage[] walkingW = {sp.getSpriteOffset(6, 0), sp.getSpriteOffset(6, 3)};
		BufferedImage[] walkingN = {sp.getSpriteOffset(0, 0), sp.getSpriteOffset(0, 3)};
		BufferedImage[] walkingS = {sp.getSpriteOffset(4, 0), sp.getSpriteOffset(4, 3)};
		BufferedImage[] walkingNE = {sp.getSpriteOffset(1, 0), sp.getSpriteOffset(1, 3)};
		BufferedImage[] walkingSE = {sp.getSpriteOffset(3, 0), sp.getSpriteOffset(3, 3)};
		BufferedImage[] walkingNW = {sp.getSpriteOffset(7, 0), sp.getSpriteOffset(7, 3)};
		BufferedImage[] walkingSW = {sp.getSpriteOffset(5, 0), sp.getSpriteOffset(5, 3)};
    	current = new Animation(standingStill, 10);
    	current.start();
        timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
            	if(!stopAnim) {
            		current.update();
            		repaint();
            		if (moveAnim){
            			if (targX==xCoord && targY==yCoord && gPath !=null){
            				goal = gPath.get(pathCount);
            				targX=(int) goal.getX()*tileSize;
            				targY=(int) goal.getY()*tileSize;
            				pathCount++;
                			dx=(int)(targX-xCoord)/xCoordDelta;
                            dy=(int)(targY-yCoord)/yCoordDelta;
                            if ((dx==0)&& (dy<0)){//N
                            	current = new Animation(walkingN, 10);
                            }
                            else if ((dx>0)&& (dy<0)){//NE
                            	current = new Animation(walkingNE, 10);
                            }
                            else if ((dx>0)&& (dy==0)){//E
                            	current = new Animation(walkingE, 10);
                            }
                            else if ((dx>0)&& (dy>0)){//SE
                            	current = new Animation(walkingSE, 10);
                            }
                            else if ((dx==0)&& (dy>0)){//S
                            	current = new Animation(walkingS, 10);
                            }
                            else if ((dx>0)&& (dy>0)){//SW
                            	current = new Animation(walkingSW, 10);
                            }
                            else if ((dx<0)&& (dy==0)){//W
                            	current = new Animation(walkingW, 10);
                            }
                            else if ((dx<0)&& (dy<0)){//NW
                            	current = new Animation(walkingNW, 10);
                            }
            			}
            			moveCharByX(dx);
            			moveCharByY(dy);
            			System.out.println("xCoord " +xCoord +"yCoord " +yCoord);
            			if (xCoord==(aStar.getEndGridPoint().getX()*tileSize) && yCoord==(aStar.getEndGridPoint().getY()*tileSize)){
            				moveAnim=false;
            				pathCount=0;
            				current = new Animation(standingStill, 10);
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
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            	moveInit(p);
            	stopAnim=false;
            	moveAnim=true;
            	//BufferedImage[] walkingDown = {sp.getSpriteOffset(4, 0), sp.getSpriteOffset(4, 1),
            	//		sp.getSpriteOffset(4, 2), sp.getSpriteOffset(4, 3)};
            	//current = new Animation(walkingDown, 10);
            	//current.start();
                timer.start();              // start timer
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            	System.out.println("XD "+ e.getLocationOnScreen().getX()+ "YD "+e.getLocationOnScreen().getY());
            	p=new Point((int)(e.getLocationOnScreen().getX()/tileSize), (int)(e.getLocationOnScreen().getY()/tileSize));
            }
        });      

    }
    
    private void moveInit(Point p) {
    	System.out.println("X "+ p.getX()+ "Y "+p.getY());
    	aStar=new AStarMoveAnimation2();
		aStar.setgMap(gMap);
		Point startGridPoint = new Point(xCoord/tileSize,yCoord/tileSize);
		Point endGridPoint = p;
		aStar.setStartGridPoint(startGridPoint);
		aStar.setEndGridPoint(endGridPoint);
		aStar.getClosedList().clear();//
		int gshortest=0;
		int hScore=(int)Point.distance(startGridPoint.getX(), startGridPoint.getY(), endGridPoint.getX(), endGridPoint.getY());
		aStar.getOpenMap().put(startGridPoint, gshortest+hScore);
		aStar.pathFinder(gMap, startGridPoint);
		gPath =aStar.getClosedList();
		frameCycle = gPath.size();
	}

	private static void createAndShowGui() {
	    JFrame frame = new JFrame();
	    MoveAnimation4 mv =new MoveAnimation4();
	    frame.add(mv, BorderLayout.CENTER);
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
	
	///////
	enum Ground {
		   DIRT(0, new Color(205,133, 63)), GRASS(1, new Color(0, 107, 60)), 
		   WATER(2, new Color(29, 172, 214));
		   private int value;
		   private Color color;
		   private Icon icon;

		   private Ground(int value, Color color) {
		      this.value = value;
		      this.color = color;

		      icon = createIcon(color);
		   }

		   private Icon createIcon(Color color) {
		      int width = 49; // how to use const in enum? 
		      BufferedImage img = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
		      Graphics g = img.getGraphics();
		      g.setColor(color);
		      g.fillRect(0, 0, width, width);
		      g.dispose();
		      return new ImageIcon(img);
		   }

		   public int getValue() {
		      return value;
		   }

		   public Color getColor() {
		      return color;
		   }

		   public Icon getIcon() {
		      return icon;
		   }

		   public static Ground getGround(int value) {
		      for (Ground ground : Ground.values()) {
		         if (ground.getValue() == value) {
		            return ground;
		         }
		      }
		      return null;
		   }

		}
	
}
