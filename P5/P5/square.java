package P5;

import javax.swing.ImageIcon;
import java.awt.Image;;

public class square {
	public static Image red = null;
	public static Image orange = null;
	public static Image yellow = null;
	public static Image green = null;
	public static Image cyan = null;
	public static Image blue = null;
	public static Image black = null;
	public static Image magenta = null;
	public square() {
		red = new ImageIcon("red.jpg").getImage();
	    orange = new ImageIcon("orange.jpg").getImage();
	    yellow = new ImageIcon("yellow.jpg").getImage();
	    green = new ImageIcon("green.jpg").getImage();
	    cyan = new ImageIcon("cyan.jpg").getImage();
	    blue = new ImageIcon("blue.jpg").getImage();
	    black = new ImageIcon("black.jpg").getImage();
	    magenta = new ImageIcon("magenta.jpg").getImage();
	 }//end of square constructor
}//end of class

