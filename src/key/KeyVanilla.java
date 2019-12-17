package key;

import java.awt.event.KeyEvent;

public class KeyVanilla extends AtKeyEvent{

	@Override
	void run(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			System.exit(0);
			break;
		default:
			break;
		}

	}

}
