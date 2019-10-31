package main;
import javax.swing.JFrame;

public class Mainclass {
	public static int windowx=1920;
	public static int windowy=1080;


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		JFrame mainframe=new JFrame("Title");

		mainframe.setVisible(true);

		mainframe.setTitle("Factory of fact");

		mainframe.setSize(windowx,windowy);

		mainframe.setLocationRelativeTo(null);

		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainframe.setExtendedState(mainframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//mainframe.setBounds(0, 0, windowx, windowy);
	}

}
