package graphics.scene;

import graphics.JFrametools;

public class Scene {
	private Drawable[] Drawables = new Drawable[100];
	private JFrametools JFT;


	public Scene(JFrametools JFT_) {
		JFT = JFT_;
	}

	public void addDrawable(Drawable d, int num) {
		add_Drawable(d, num);
	}

	;

	private void add_Drawable(Drawable d,int num) {
		Drawables[num] = d;
	}

	public void draw() {
		for (int cnt = 0; cnt != Drawables.length; cnt++) {
			if (Drawables[cnt] == null) continue;
			Drawables[cnt].draw(JFT);
		}
	}
}
