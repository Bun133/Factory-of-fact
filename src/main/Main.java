package main;

import javax.swing.JFrame;

import graphics.JFrametools;

public class Main extends JFrame{
	public static void main(String[] args) {
		//DrawView dv=new DrawView(500,500);
		JFrametools JFT=new JFrametools("Factory of fact",500,500);

		for(int c=0;c!=10000;c++) {
		JFT.clear();
		//System.out.println(c%255);
		JFT.color(c%255,c%255,c%255);
		//JFT.drawLine(100, 100, 200, 200);
		JFT.fillRect(0, 0, 500, 500);
		JFT.repaint();
		JFT.dispose();


		}



	}

}

