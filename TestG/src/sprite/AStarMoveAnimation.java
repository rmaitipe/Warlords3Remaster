package sprite;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStarMoveAnimation {

    private static final int MAX_PATH_LENGTH = 100;

    private static Point startPoint = new Point(0,0);
    private static Point endPoint = new Point(9,9);
    List <Point> pointPath= new <Point> ArrayList();
    static List <Point> closedList= new <Point> ArrayList();
    static List <Point> openList= new <Point> ArrayList();

    
	public static List<Point> pathFinder(SimpleMap map, Point currentPoint){
		//openList.remove(currentPoint);
		if (currentPoint.equals(endPoint)){
			return closedList;
		}

		HashMap <Point, Integer> pathMap = (HashMap)getNeigbourPoints(map,currentPoint);
		// remove closedList points
		pathMap.entrySet().removeIf(e-> closedList.contains(e) );
		// update openList
		Point p = pathMap.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		closedList.add(p);
		//closedList.stream().forEach(e-> System.out.print(e));
		//System.out.println("");
		if(pathMap.isEmpty()){//no path
			closedList=null;
			return null;
		}
		else{
			pathFinder (map,p);
		}
		/*
		[openList add:originalSquare]; // start by adding the original position to the open list
		do {

			adjacentSquares = [currentSquare walkableAdjacentSquares]; // Retrieve all its walkable adjacent squares
			
			foreach (aSquare in adjacentSquares) {
				
				if ([closedList contains:aSquare]) { // if this adjacent square is already in the closed list ignore it
					continue; // Go to the next adjacent square
				}
				
				if (![openList contains:aSquare]) { // if its not in the open list
					
					// compute its score, set the parent
					[openList add:aSquare]; // and add it to the open list
					
				} else { // if its already in the open list
					
					// test if using the current G score make the aSquare F score lower, if yes update the parent because it means its a better path
					
				}
			}
			
		} while(![openList isEmpty]); // Continue until there is no more available square in the open list (which means there is no path)
		*/
		
		return null;
	}
	
	public static int func1(Point p1,Point p2){
		return (int)Point.distance(p1.getX(), p2.getY(), p1.getX(), p2.getY());
	}

    public static void main(String[] args) {
        SimpleMap map = new SimpleMap();
 //       init(map);
 //       System.out.println("Starting Calc "+(int)Point.distance(3, 3, 4, 4));
        System.out.println("Starting");
        closedList.add(startPoint);
//        List<Point> pathList = pathFinder(map, startPoint);
//        pathList.stream().forEach(e-> System.out.println(e));
        pathFinder(map, startPoint);
        closedList.stream().forEach(e-> System.out.println(e));
      }
    
    static class SimpleMap {
	    private static final int WIDTH = 10;
	    private static final int HEIGHT = 10;
	
	    private final static int[][] MAP = {
	        {0,1,1,1,1,1,1,1,1,1},
	        {1,0,0,0,0,0,1,1,1,1},
	        {1,0,1,1,1,0,1,1,1,1},
	        {1,0,1,1,1,0,0,0,1,1},
	        {1,0,0,0,1,1,1,0,1,1},
	        {1,1,1,0,1,1,1,0,0,0},
	        {1,0,1,0,0,0,0,0,1,0},
	        {1,0,1,1,1,1,1,1,1,0},
	        {1,0,0,0,0,0,0,0,0,0},
	        {1,1,1,1,1,1,1,1,1,0}
	    };
	}

	private static Map<Point,Integer> getNeigbourPoints(SimpleMap map, Point currentPoint) {
		Map<Point,Integer> ret = new HashMap<Point,Integer>();
		Point tempPoint;
		int wtf;
		System.out.println(" currentPoint:"+currentPoint );
		for (int  i=-1; i<2; i++)
			for (int  j=-1; j<2; j++){
				tempPoint= movePointDelta(currentPoint, i, j);
				if (tempPoint != null && !closedList.contains(tempPoint) && SimpleMap.MAP[(int)tempPoint.getX()][(int)tempPoint.getY()]==0){
					int gshortest= (int)Point.distance(startPoint.getX(), startPoint.getY(), currentPoint.getX(), currentPoint.getY());
					int hScore=(int)Point.distance(tempPoint.getX(), tempPoint.getY(), endPoint.getX(), endPoint.getY());
					int xyDelta= (int)Point.distance(currentPoint.getX(), currentPoint.getY(), tempPoint.getX(), tempPoint.getY());
					//int yDelta= (int)Point.distance(currentPoint.getX(), currentPoint.getY(), tempPoint.getX(), tempPoint.getY());
					System.out.println(" tempPoint:"+tempPoint +" gshortest:"+gshortest + " hScore:"+hScore+" total:"+(gshortest+hScore));
					ret.put(tempPoint, gshortest+xyDelta+hScore);
				}
			}
		return ret;
	}
	
	public static Point movePointDelta(Point p,int dx, int dy){
		if ((p.getX()+dx<0 || p.getX()+dx>(SimpleMap.WIDTH-1))||(p.getY()+dy<0 || p.getY()+dy>(SimpleMap.HEIGHT-1))||(dx==0 && dy==0)){
			return null;
		}
		Point ret=new Point((int)p.getX(), (int)p.getY());
		ret.translate(dx, dy);
		return ret;
	}
}