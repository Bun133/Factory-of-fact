package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**

 * @author Bun133_
 *
 */
public class JFrametools{

	private JFrame J=new JFrame();
	private BufferStrategy bfi;
	private Graphics g;
	/**
	 * JFrametool使用時に絶対起動が必要です。
	 * @param Title
	 * @param Window_sizex
	 * @param Window_sizey
	 */
	public JFrametools (String Title,int Window_sizex,int Window_sizey) {
		J.setTitle(Title);
		J.setVisible(true);
		J.setBounds(0, 0, Window_sizex, Window_sizey);
		J.setLocationRelativeTo(null);
		J.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		J.createBufferStrategy(2);
		bfi = J.getBufferStrategy();
	}

	public Graphics2D GetGraphics2D() {
		return (Graphics2D) J.getBufferStrategy().getDrawGraphics();
	}

	public Graphics GetGraphics() {
		return J.getBufferStrategy().getDrawGraphics();
	}

	public void drawLine(int x,int y,int s_x,int s_y) {
		bfi = J.getBufferStrategy();
		GetGraphics().drawLine(x, y, s_x, s_y);
		repaint();
		repaint(J);
	}
	public void color(int R,int G,int B) {
		Color c=new Color(R,G,B);
		color(c);
	}

	public void color(Color c) {
		GetGraphics().setColor(c);
	}

	public void drawRect(int x,int y,int W,int H) {
		GetGraphics().drawRect(x, y, W, H);
	}

	public void fillRect(int x,int y,int W,int H) {
		GetGraphics().fillRect(x, y, W, H);
	}
	public void repaint(JFrame J) {
		J.repaint();
	}
	/**
	 * @author nyuto
	 */
	public void repaint() {
		if(!bfi.contentsLost())bfi.show();
		Toolkit.getDefaultToolkit().sync();
	}

	public void dispose() {
		GetGraphics().dispose();
	}


}
