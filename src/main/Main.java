package main;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import graphics.GetFPS;
import graphics.JFrametools;
import graphics.SetFPS;

public class Main extends JFrame{
	public static void main(String[] args) {
		//DrawView dv=new DrawView(500,500);
		JFrametools JFT=new JFrametools("Factory of fact",500,500);
		GetFPS FPStools=new GetFPS();
		SetFPS SetFPStools=new SetFPS();
		Random r=new Random();
		SetFPStools.setMaxFPS(60);
		for(int c=0;c!=10000;c++) {
			JFT.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			JFT.drawRect(0, 0, 500, 500);
			JFT.repaint();
			try {
				SetFPStools.Force_wait(FPStools.time);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println(FPStools.getFPS());
			FPStools.time=System.currentTimeMillis();



		}



	}

}

