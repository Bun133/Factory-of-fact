package main;

import java.awt.Color;

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
		SetFPStools.setMaxFPS(60);
		for(int c=0;c!=10000;) {
			JFT.getGraphics().setColor(Color.RED);
			System.out.println(JFT.getColor_B());
			JFT.fillRect(0, 0, 500, 500);
			JFT.repaint();
			try {
				SetFPStools.Force_wait(FPStools.time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println(FPStools.getFPS());
			FPStools.time=System.currentTimeMillis();



		}



	}

}

