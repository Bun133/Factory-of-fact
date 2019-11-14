package main;

import javax.swing.JFrame;

import graphics.JFrametools;

public class Main extends JFrame{
	public static void main(String[] args) {
		//DrawView dv=new DrawView(500,500);
		JFrametools JFT=new JFrametools("Factory of fact",500,500);

		JFT.drawLine(100, 100, 200, 200);
		




	}

}

