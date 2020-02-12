package key;

import java.awt.event.KeyEvent;

import graphics.Camera;

public class KeyVanilla extends AtKeyEvent{
	private Camera Camera;
	public KeyVanilla(Camera camera) {
		Camera=camera;
	}

	@Override
	void run(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			System.exit(0);
			break;
		case KeyEvent.VK_W:
			Camera.up();
			break;
		case KeyEvent.VK_A:
			Camera.left();
			break;
		case KeyEvent.VK_S:
			Camera.down();
			break;
		case KeyEvent.VK_D:
			Camera.right();
			break;
		default:
			break;
		}

	}

}
