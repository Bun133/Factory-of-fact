package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**

 * @author Bun133_
 *
 */
public class JFrametools extends JFrame{

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
		J.getContentPane().setBackground(Color.white);
		J.setResizable(false);
		J.setIgnoreRepaint(false);
		J.createBufferStrategy(2);
		bfi = J.getBufferStrategy();
		g=J.getGraphics();
		//J.setIgnoreRepaint(true);
	}

	public Graphics2D getGraphics2D() {
		return (Graphics2D) g;
	}

	public Graphics getGraphics() {
		return g;
	}

	public void drawLine(int x,int y,int s_x,int s_y) {
		bfi = J.getBufferStrategy();
		getGraphics().drawLine(x, y, s_x, s_y);
	}
	public void setColor(int R,int G,int B) {
		Color c=new Color(R,G,B);
		setColor(c);
	}

	public void setColor(Color c) {
		getGraphics().setColor(c);
	}

	public void drawRect(int x,int y,int W,int H) {
		getGraphics().drawRect(x, y, W, H);
	}

	public void fillRect(int x,int y,int W,int H) {
		getGraphics().fillRect(x, y, W, H);

	}
	public void repaint(JFrame J) {
		J.repaint();
	}
	/**
	 * @author nyuto
	 * @deprecated
	 * @apiNote 特別書く必要ありません
	 */
	@Override
	public void repaint() {
		if(!bfi.contentsLost())bfi.show();
		Toolkit.getDefaultToolkit().sync();
	}

	public void dispose() {
		getGraphics().dispose();
	}

	public int getWindow_y() {
		return J.getHeight();
	}

	public int getWindow_x() {
		return J.getWidth();
	}

	public String gettitle() {
		return J.getTitle();
	}

	public void clear() {
		Color c;
		c=getColor();
		setColor(Color.WHITE);
		fillRect(0,0,getWindow_x(),getWindow_y());
		setColor(c);
	}

	public Color getColor() {
		return getGraphics().getColor();
	}

	public int getColor_R() {
		return getGraphics().getColor().getRed();
	}

	public int getColor_G() {
		return getGraphics().getColor().getGreen();
	}

	public int getColor_B() {
		return getGraphics().getColor().getBlue();
	}

	public JFrame getJFrame() {
		return J;
	}


	public void drawImage(Image image,int x,int y) {
		getGraphics().drawImage(image,x,y,null);
	}

	public void drawImage(Image image,int x,int y,int w,int h) {
		getGraphics().drawImage(image,x,y,w,y,null);
	}


	public void drawImage(Image image,int x,int y,double image_x,double image_y) {
		drawImage(image,x,y,(int)image_x,(int)image_y);
	}
	public void drawImage(Image image,int x,int y,double d) {
		int image_x=0;
		int image_y=0;
		image_x=image.getWidth(null);
		image_y=image.getHeight(null);
		drawImage(image,x,y,image_x*d,image_y*d);
	}


	public void setWindowsize(int x,int y) {
		J.setSize(x,y);
	}

	public void setFull() {
		setUndecorated(true);
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		device.setFullScreenWindow(J);
	}

	public void disableFull() {
		setUndecorated(false);
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		device.setFullScreenWindow(null);
	}

	public void setUndecorated(Boolean b) {
		dispose();
		J.setUndecorated(b);
		J.setVisible(true);

	}
}
