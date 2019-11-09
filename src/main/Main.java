package main;

import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main {
	public static JFrame JFrame=new JFrame();
	public static Graphics g;
	public static void main(String[] args) {
	//Picload picloader=new Picload();
		JFrametools JFrametool=new JFrametools();
		JFrame=JFrametool.setup("Factory of fact", 500, 500);
		JFrame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}

		});
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(JFrame);
		g=JFrame.getGraphics();
		Image image =Toolkit.getDefaultToolkit().getImage("src/EDGE1.bmp");
		g.drawImage(image, 0, 0, JFrame);
		JFrame.repaint();
	}

}
