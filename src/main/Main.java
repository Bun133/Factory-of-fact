package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {
		DrawView vd = new DrawView(640,480);

		BufferedImage bi = new BufferedImage(640,480,BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<100;i++) {
			Graphics2D gra = bi.createGraphics();
			/*gra.setColor(Color.red);
			gra.fillOval(0, 0, 640, 480);
			gra.setColor(Color.black);
			gra.fillOval(100, 100, 540, 380);*/

			//Load処理(予定)
			Showmap mapmanager=new Showmap();
			gra=mapmanager.draw(gra, 100,100,"testobject");
			vd.paint2D(bi);
			vd.repaint();
			System.out.println(i);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		}


	}

}
//test2
