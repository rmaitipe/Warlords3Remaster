package sprite;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import launcher.GameMap;

public class AStarMoveAnimation2 {

    private static final int MAX_PATH_LENGTH = 100;

    private static Point startGridPoint;
    private static Point endGridPoint;
    static List <Point> closedList= new <Point> ArrayList();
    static Map <Point, Integer> openMap= new <Point, Integer> HashMap();

    //
    private static GameMap gMap;
    
    public static void main(String[] args) {
 //       init(map);
        System.out.println("Starting");
        gMap=new GameMap(10,10);
        startGridPoint=new Point(0,0);
        endGridPoint=new Point(9,9);
        int gshortest=0;
		int hScore=(int)Point.distance(startGridPoint.getX(), startGridPoint.getY(), endGridPoint.getX(), endGridPoint.getY());
        openMap.put(startGridPoint, gshortest+hScore);
        pathFinder(gMap, startGridPoint);
        closedList.stream().forEach(e-> System.out.println(e));
    }
    
	public static List<Point> pathFinder(GameMap map, Point currentGridPoint){
		if (openMap.isEmpty()){//no path exists
			closedList=null;
			return null;
		}
		if (currentGridPoint.equals(endGridPoint)){
			closedList.add(currentGridPoint);
			openMap.clear();
			return closedList;
		}
		closedList.add(currentGridPoint);
		openMap.remove(currentGridPoint);
		Map <Point, Integer> tempMap = (HashMap)getNeigbourPoints(map,currentGridPoint);
		Point nextPoint;
		if(tempMap!=null){
			nextPoint = tempMap.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
			// remove closedList points
			// update openList
			// add to openList
			for (Entry<Point, Integer> p: tempMap.entrySet()){
				if (closedList.contains(p.getKey())){
					//don't add to openList
				}
				else if (openMap.entrySet().contains(p.getKey())){
					Integer oldV = openMap.get(p.getKey());
					Integer newV = p.getValue();
					if (newV<oldV){
						
					}
				}
				else {
					openMap.put(p.getKey(), p.getValue());
				}
			}
			pathFinder (map,nextPoint);
		}
		else{//go back ????
			closedList.remove(closedList.size()-1);
		}
		//Point p = pathMap.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

		
		return null;
	}
	
	public static int func1(Point p1,Point p2){
		return (int)Point.distance(p1.getX(), p2.getY(), p1.getX(), p2.getY());
	}
    
	private static Map<Point,Integer> getNeigbourPoints(GameMap map, Point currentPoint) {
		Map<Point,Integer> ret = new HashMap<Point,Integer>();
		Point tempPoint;
		System.out.println(" currentPoint:"+currentPoint );
		for (int  i=-1; i<2; i++)
			for (int  j=-1; j<2; j++){
				tempPoint= movePointDelta(currentPoint, i, j);
				if (tempPoint != null && !closedList.contains(tempPoint) && gMap.getMapTraverse()[(int)tempPoint.getY()][(int)tempPoint.getX()]==0){
					int gshortest= (int)Point.distance(startGridPoint.getX(), startGridPoint.getY(), currentPoint.getX(), currentPoint.getY());
					int hScore=(int)Point.distance(tempPoint.getX(), tempPoint.getY(), endGridPoint.getX(), endGridPoint.getY());
					int xyDelta= (int)Point.distance(currentPoint.getX(), currentPoint.getY(), tempPoint.getX(), tempPoint.getY());
					System.out.println(" tempPoint:"+tempPoint +" gshortest:"+gshortest + " hScore:"+hScore+" total:"+(gshortest+hScore));
					ret.put(tempPoint, gshortest+xyDelta+hScore);
				}
			}
		return ret;
	}
	
	public static Point movePointDelta(Point p,int dx, int dy){
		if ((p.getX()+dx<0 || p.getX()+dx>(gMap.getMapWidth()-1))||(p.getY()+dy<0 || p.getY()+dy>(gMap.getMapHeight()-1))||(dx==0 && dy==0)){
			return null;
		}
		Point ret=new Point((int)p.getX(), (int)p.getY());
		ret.translate(dx, dy);
		return ret;
	}

	public static Point getStartGridPoint() {
		return startGridPoint;
	}

	public static void setStartGridPoint(Point startGridPoint) {
		AStarMoveAnimation2.startGridPoint = startGridPoint;
	}

	public static Point getEndGridPoint() {
		return endGridPoint;
	}

	public static void setEndGridPoint(Point endGridPoint) {
		AStarMoveAnimation2.endGridPoint = endGridPoint;
	}

	public static List<Point> getClosedList() {
		return closedList;
	}

	public static void setClosedList(List<Point> closedList) {
		AStarMoveAnimation2.closedList = closedList;
	}

	public static Map<Point, Integer> getOpenMap() {
		return openMap;
	}

	public static void setOpenMap(Map<Point, Integer> openMap) {
		AStarMoveAnimation2.openMap = openMap;
	}

	public static GameMap getgMap() {
		return gMap;
	}

	public static void setgMap(GameMap gMap) {
		AStarMoveAnimation2.gMap = gMap;
	}
	
}