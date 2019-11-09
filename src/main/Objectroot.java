package main;

public final class Objectroot {
	public int getrootx(int cnt,int length) {

		return cnt%getroot(length);
	}

	public int getrooty(int cnt,int length) {
		return cnt/getroot(length);
	}
	private int getroot(int cnt) {
		 int onetime=0;
		 onetime=(int) Math.sqrt(cnt);
		 if (onetime*onetime!=cnt){
			 return 0;
		 }
		 return onetime;
	 }
}
