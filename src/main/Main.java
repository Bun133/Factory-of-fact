package main;

import assets.util.Logger;
import assets.util.Register;

import assets.Logger;

public class Main {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	public static Logger logger = new Logger(System.out);

	public static Register register = new Register();

	public static Logger logger = new Logger(System.out);

	public static void main(String[] args) {
		System.setOut(logger);

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


		register.register("test","test");
		//下のコメントアウトした部分を有効にするとキーが重複しているので例外が発生します
		//register.register("test","test2");
		register.register("try","test3");

		System.out.println(register.getString("test"));
		//下のコメントアウトした部分を有効にすると指定したキーが発見できないので例外が発生します
		//System.out.println(register.getString("tyy"));
		System.out.println(register.getString("try"));
	}

}