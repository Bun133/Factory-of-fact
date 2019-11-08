package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JFrametools {
	public JFrame setup(String title,int x,int y) {
		JFrame JFrame=new JFrame(title);
		JFrame.setVisible(true);
		JFrame.setBounds(0, 0, x, y);
		JFrame.setLocationRelativeTo(null);
		JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		return JFrame;
	}
}
