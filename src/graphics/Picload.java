package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Picload {
	public void picload(Graphics g,int x,int y,String filepath,JFrame JFrame) {
		Image image =Toolkit.getDefaultToolkit().getImage(filepath);
		g.drawImage(image, x, y, JFrame);

	}
}
