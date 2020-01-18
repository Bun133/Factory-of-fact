package key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyManager implements KeyListener{
	private AtKeyEvent[] AtKeyEvent=new AtKeyEvent[10];
	public final int All_keys=36;
	public String[] keys;
	public int[] keys_int;
	public boolean[] key;
	private KeyEvent[] es=new KeyEvent[100];


	public KeyManager(JFrame J) {
		keys=new String[All_keys];
		keys_int=new int[All_keys];
		key=new boolean[All_keys];
		keys = {"1","2","3","4","5","6","7","8","9","0",
			"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
		keys_int = {KeyEvent.VK_1,
			    KeyEvent.VK_2,
			    KeyEvent.VK_3,
			    KeyEvent.VK_4,
			    KeyEvent.VK_5,
			    KeyEvent.VK_6,
			    KeyEvent.VK_7,
			    KeyEvent.VK_8,
			    KeyEvent.VK_9,
			    KeyEvent.VK_0,
			    KeyEvent.VK_Q,
			    KeyEvent.VK_W,
			    KeyEvent.VK_E,
			    KeyEvent.VK_R,
			    KeyEvent.VK_T,
			    KeyEvent.VK_Y,
			    KeyEvent.VK_U,
			    KeyEvent.VK_I,
			    KeyEvent.VK_O,
			    KeyEvent.VK_P,
			    KeyEvent.VK_A,
			    KeyEvent.VK_S,
			    KeyEvent.VK_D,
			    KeyEvent.VK_F,
			    KeyEvent.VK_G,
			    KeyEvent.VK_H,
			    KeyEvent.VK_J,
			    KeyEvent.VK_K,
			    KeyEvent.VK_L,
			    KeyEvent.VK_Z,
			    KeyEvent.VK_X,
			    KeyEvent.VK_C,
			    KeyEvent.VK_V,
			    KeyEvent.VK_B,
			    KeyEvent.VK_N,
			    KeyEvent.VK_M};


		J.addKeyListener(this);
	}
	public void tick() {
		for(int c=0;c!=AtKeyEvent.length;c++) {
			throwKey(AtKeyEvent[c],es);
		}
		clearKeyEventCollecter();
	}

	public void throwKey(AtKeyEvent Atk,KeyEvent[] es) {
		//System.out.println("throwed");
		if(Atk==null) return;
		int cnt=0;
		for(;cnt!=es.length;cnt++) {
			if (es[cnt]==null) continue;
			System.out.println("KeyManager:"+es[cnt].getKeyChar()+" is Pressed");
			Atk.run(es[cnt]);
		}
	}

	public void addclass(AtKeyEvent atk) {
		int cnt=0;
		for(;AtKeyEvent[cnt]!=null;cnt++) {
		}
		if (cnt==AtKeyEvent.length || cnt>AtKeyEvent.length) {
			System.out.println("aaaaa");
			return;
		}
		AtKeyEvent[cnt]=atk;
	}
	@Override
	public void keyTyped(KeyEvent e) {


	}
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Pressed");
		//key[getkeyid(e.getKeyCode())]=true;
		KeyEventCollecter(e);
		tick();
	}
	@Override
	public void keyReleased(KeyEvent e) {


	}
	/*public String getkeyString(int num) {
		return keys[num];
	}*/

	/*public int getkeyid(int keycode) {
		int c=0;
		while(keycode==keys_int[c]) {
			c++;
		}
		if (c==All_keys+1) {
			System.out.println("Null");
			return -1;
		}
		return c;
	}*/

	public void KeyEventCollecter(KeyEvent e) {
		int cnt=0;
		for(;cnt!=es.length;cnt++) {
			if (es[cnt]==null) break;
		}
		es[cnt]=e;
		//System.out.println(e);
	}

	private void clearKeyEventCollecter() {
		es=new KeyEvent[es.length];
	}
}
