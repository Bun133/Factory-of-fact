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
		keys[0]="1";
		keys[1]="2";
		keys[2]="3";
		keys[3]="4";
		keys[4]="5";
		keys[5]="6";
		keys[6]="7";
		keys[7]="8";
		keys[8]="9";
		keys[9]="0";
		keys[10]="q";
		keys[11]="w";
		keys[12]="e";
		keys[13]="r";
		keys[14]="t";
		keys[15]="y";
		keys[16]="u";
		keys[17]="i";
		keys[18]="o";
		keys[19]="p";
		keys[20]="a";
		keys[21]="s";
		keys[22]="d";
		keys[23]="f";
		keys[24]="g";
		keys[25]="h";
		keys[26]="j";
		keys[27]="k";
		keys[28]="l";
		keys[29]="z";
		keys[30]="x";
		keys[31]="c";
		keys[32]="v";
		keys[33]="b";
		keys[34]="n";
		keys[35]="m";
		keys_int[0]=KeyEvent.VK_1;
		keys_int[1]=KeyEvent.VK_2;
		keys_int[2]=KeyEvent.VK_3;
		keys_int[3]=KeyEvent.VK_4;
		keys_int[4]=KeyEvent.VK_5;
		keys_int[5]=KeyEvent.VK_6;
		keys_int[6]=KeyEvent.VK_7;
		keys_int[7]=KeyEvent.VK_8;
		keys_int[8]=KeyEvent.VK_9;
		keys_int[9]=KeyEvent.VK_0;
		keys_int[10]=KeyEvent.VK_Q;
		keys_int[11]=KeyEvent.VK_W;
		keys_int[12]=KeyEvent.VK_E;
		keys_int[13]=KeyEvent.VK_R;
		keys_int[14]=KeyEvent.VK_T;
		keys_int[15]=KeyEvent.VK_Y;
		keys_int[16]=KeyEvent.VK_U;
		keys_int[17]=KeyEvent.VK_I;
		keys_int[18]=KeyEvent.VK_O;
		keys_int[19]=KeyEvent.VK_P;
		keys_int[20]=KeyEvent.VK_A;
		keys_int[21]=KeyEvent.VK_S;
		keys_int[22]=KeyEvent.VK_D;
		keys_int[23]=KeyEvent.VK_F;
		keys_int[24]=KeyEvent.VK_G;
		keys_int[25]=KeyEvent.VK_H;
		keys_int[26]=KeyEvent.VK_J;
		keys_int[27]=KeyEvent.VK_K;
		keys_int[28]=KeyEvent.VK_L;
		keys_int[29]=KeyEvent.VK_Z;
		keys_int[30]=KeyEvent.VK_X;
		keys_int[31]=KeyEvent.VK_C;
		keys_int[32]=KeyEvent.VK_V;
		keys_int[33]=KeyEvent.VK_B;
		keys_int[34]=KeyEvent.VK_N;
		keys_int[35]=KeyEvent.VK_M;


		J.addKeyListener(this);
	}
	public void tick() {
		for(int c=0;c!=AtKeyEvent.length;c++) {
			throwKey(AtKeyEvent[c],es);
		}
		//clearKeyEventCollecter();
	}

	public void throwKey(AtKeyEvent Atk,KeyEvent[] es) {
		//System.out.println("throwed");
		if(Atk==null) return;
		int cnt=0;
		for(;cnt!=es.length;cnt++) {
			if (es[cnt]==null) continue;
			System.out.println("KeyManager:"+"\""+es[cnt].getKeyChar()+"\" is Pressed");
			Atk.run(es[cnt]);
		}
	}

	public void addclass(AtKeyEvent atk) {
		int cnt=0;
		for(;AtKeyEvent[cnt]!=null;cnt++) {
		}
		if (cnt==AtKeyEvent.length || cnt>AtKeyEvent.length) {
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
		KeyEventPressedCollecter(e);
		tick();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		KeyEventRelesedCollecter(e);
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

	public void KeyEventPressedCollecter(KeyEvent e) {
		es[e.getKeyCode()]=e;
		//System.out.println(e);
	}

	public void KeyEventRelesedCollecter(KeyEvent e) {
		es[e.getKeyCode()]=null;
	}

	private void clearKeyEventCollecter() {
		es=new KeyEvent[es.length];
	}
}
