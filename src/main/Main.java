package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Main {

	public static Logger logger = new Logger(System.out);

	public static void main(String[] args) {
		System.setOut(logger);
		DrawView vd = new DrawView(640,480);

		BufferedImage bi = new BufferedImage(640,480,BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<255;i++) {
			Graphics2D gra = bi.createGraphics();
			gra.setColor(Color.red);
			gra.fillOval(0, 0, 640, 480);
			gra.setColor(Color.black);
			gra.fillOval(100, 100, 540, 380);
			vd.paint2D(bi);
			vd.repaint();
			//テスト用です 黒から白に変わっていけば成功です
			logger.setTextColorOnece(new Color(i,i,i));
			System.out.println(i);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		}
		Loadimage loadimager=new Loadimage();
		//loadimager.load("/Factory of fact/src/main/test");
	}

}
