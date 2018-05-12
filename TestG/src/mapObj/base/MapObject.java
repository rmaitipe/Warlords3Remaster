package mapObj.base;

import java.awt.Point;
import java.awt.image.BufferedImage;
/* This abstract class for representing objects in gameMap has 2 fields - one for the icon (image) and the other for 
 * its location (coordinates)*/
public abstract class MapObject {

	private BufferedImage image;
	private Point coordinates;
	
	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
