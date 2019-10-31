package main;
import javax.swing.SwingUtilities;

import main.Drawtools.AbstractRawFrame;

public class SampleRawPaint extends AbstractRawFrame {

	public static void main(String[] args) {

		// Swingがらみの処理はEvent Dispatch Thread上でやる
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SampleRawPaint();
			}
		});

	}

	public SampleRawPaint() {
		initialize(640, 480);

	}

	@Override
	public void updatePixels(int[] pixels) {
		int offset = 0;
		for (int y = 0; y < 480; y ++) {
			for (int x = 0; x < 640; x ++) {
				pixels[offset ++] = Math.random() >= 0.5 ?
						0xff000000 : 0xffffffff;
			}
		}
	}

}