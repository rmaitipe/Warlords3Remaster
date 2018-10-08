package sprite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage spriteSheet;
    private static final int TILE_SIZE = 49;

    public Sprite(String file){
    	try {
        	FileInputStream fis = new FileInputStream(new File("resources/art/" + file + ".png"));  
        	spriteSheet = ImageIO.read(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            //sprite = ImageIO.read(new File("res/" + file + ".png"));
        	FileInputStream fis = new FileInputStream(new File("resources/art/" + file + ".png"));  
            sprite = ImageIO.read(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public BufferedImage getSprite(int xGrid, int xoffSet, int yGrid, int yoffSet) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("alchemf");
        }
        //adding offset based on the sprite sheet
        return spriteSheet.getSubimage((xGrid*TILE_SIZE)+xoffSet, (yGrid*TILE_SIZE)+yoffSet, TILE_SIZE, TILE_SIZE);
    }
    
    public BufferedImage getSpriteOffset(int xGrid, int yGrid) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("alchemf");
        }
        //adding offset based on the sprite sheet
        return spriteSheet.getSubimage((xGrid * TILE_SIZE)+128, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}