package main;
import javax.swing.JFrame;

public class Mainclass {
	public static int windowx=1920;
	public static int windowy=1080;


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		JFrame mainflame=new JFrame("Title");

		mainflame.setVisible(true);

		mainflame.setTitle("Factory of fact");

		mainflame.setSize(windowx,windowy);

		mainflame.setLocationRelativeTo(null);

		mainflame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainflame.setExtendedState(mainflame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//mainflame.setBounds(0, 0, windowx, windowy);
	}

}
