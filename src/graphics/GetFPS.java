package graphics;

public class GetFPS {
	/**
	 * @author Bun133
	 * @apiNote FPS測定用
	 */






	//private boolean flug=false;
	//public long ms=0;
	public long getFPS(long time) {
		if ((System.currentTimeMillis()-time)==0) {
		return 0;
		}else {
		return 1000/(System.currentTimeMillis()-time);
		}
	}


}
