package test.combat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import launcher.GameMap;
import sprite.AStarMoveAnimation2;
import sprite.Animation;
import sprite.Sprite;

public class MoveAnimation5 extends JPanel {
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
    static Sprite spTerra1Sheet= new Sprite("Terrain/Data/o_plains");
    static Sprite spTerra2Sheet= new Sprite("Terrain/Data/hills0");
    static Sprite spTerra3Sheet= new Sprite("Terrain/Data/iwater");
			
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
    
    public MoveAnimation5(){
    	 JLabel[][] labelGrid = new JLabel[gMap.getMapTraverse().length][gMap.getMapTraverse()[0].length];
    	 setLayout(new GridLayout(gMap.getMapTraverse().length, gMap.getMapTraverse()[0].length));
         for (int r = 0; r < labelGrid.length; r++) {
            for (int c = 0; c < labelGrid[r].length; c++) {
               labelGrid[r][c] = new JLabel();
               labelGrid[r][c].setIcon(Ground.getGround(gMap.getMapTraverse()[r][c]).getIcon());
               add(labelGrid[r][c]);            
            }
         }
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
            	if (moveInit(p)){
            		stopAnim=false;
            		moveAnim=true;
            		timer.start();              // start timer
            	}
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            	System.out.println("Target XD "+ (int)e.getLocationOnScreen().getX()/tileSize+ "YD "+(int)((e.getLocationOnScreen().getY()-30)/tileSize));//Adding offset for Y as it counts framebar?
            	//System.out.println("XD Co"+ e.getLocationOnScreen().getX()/tileSize+ "YD Co"+e.getLocationOnScreen().getY()/tileSize);
            	p=new Point((int)(e.getLocationOnScreen().getX()/tileSize), (int)((e.getLocationOnScreen().getY()-30)/tileSize));
            }
        });      

    }
    
    private boolean moveInit(Point p) {
    	boolean ret = false;
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
		System.out.println("MapVal ="+ gMap.getMapTraverse()[(int) endGridPoint.getY()][(int) endGridPoint.getX()]);
		if(gMap.getMapTraverse()[(int) endGridPoint.getY()][(int) endGridPoint.getX()]!=1){//row/col
			aStar.pathFinder(gMap, startGridPoint);
			gPath =aStar.getClosedList();
			frameCycle = gPath.size();
			ret=true;
		}
		else{
			gPath=null;
			frameCycle =0;
		}
		return ret;
	}

	private static void createAndShowGui() {
	    JFrame frame = new JFrame();
	    MoveAnimation5 mv =new MoveAnimation5();
	    frame.add(mv, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setVisible(true);
	    frame.pack();//Set Size etc
	    
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
		   DIRT(0, spTerra1Sheet.getSprite(0, 0, 0, 0)), 
		   GRASS(1, spTerra2Sheet.getSprite(1, 1, 0, 0)), 
		   WATER(2, spTerra3Sheet.getSprite(0, 1, 0, 0));
		   private int value;
		   private BufferedImage tile;
		   private Icon icon;

		   private Ground(int value, BufferedImage tile) {
		      this.value = value;
		      this.tile = tile;
		      icon = new ImageIcon(tile);
		   }

		   public int getValue() {
		      return value;
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
