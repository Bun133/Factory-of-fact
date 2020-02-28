package key;

import graphics.Mapdrawmanager;

import java.awt.event.KeyEvent;

public class KeyVanilla extends AtKeyEvent {
	Mapdrawmanager mdm;

	public KeyVanilla(Mapdrawmanager Mdm) {
		mdm = Mdm;
	}

	@Override
	void run(KeyEvent e) {

		switch (e.getKeyCode()) {
			case KeyEvent.VK_1:
				System.exit(0);
				break;
			case KeyEvent.VK_W:
				mdm.up();
				break;
			case KeyEvent.VK_A:
				mdm.left();
				break;
			case KeyEvent.VK_S:
				mdm.down();
				break;
			case KeyEvent.VK_D:
				mdm.right();
				break;
			default:
				break;
		}

	}

}
