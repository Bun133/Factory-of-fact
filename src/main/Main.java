package main;


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
		SetFPStools.setMaxFPS(60);
		long time = 0;
		Random r=new Random();
		for(int c=0;c!=1;){
			JFT.setColor(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			JFT.fillRect(0, 0, 500, 500);
			//JFT.repaint();

			try {
				SetFPStools.Force_wait(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(FPStools.getFPS(time));
			time=System.currentTimeMillis();
		}




	}

}

