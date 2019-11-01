package main;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		// Swingがらみの処理はEvent Dispatch Thread上でやる
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SampleRawPaint();
			}
		});

	}
}
