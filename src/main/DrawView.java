/***********************************
 * 単なるテスト用です
 * 本番で使う予定はありません
 * (多分)
 *
 * @author nyuto
 */

package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class DrawView {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private JFrame frame = new JFrame();

	private BufferStrategy bfi;


	public DrawView(int width,int height) {
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setIgnoreRepaint(false);
		frame.setVisible(true);
		frame.createBufferStrategy(2);
		bfi = frame.getBufferStrategy();

	}

	public void paint2D(Image i) {
		Graphics2D gra = (Graphics2D) bfi.getDrawGraphics();
		gra.drawImage(i, 0, 0, frame);
	}


	public void repaint() {
		if(!bfi.contentsLost())bfi.show();
		Toolkit.getDefaultToolkit().sync();
	}

}
