package graphics;
//キャメラ
public class Camera {
	private Mapdrawmanager MDM;
	private int posx;
	private int posy;
	private final double moverate=0.1;
	public Camera(Mapdrawmanager Mdm) {
		MDM=Mdm;
	}

	public Camera(Mapdrawmanager Mdm,int x,int y) {
		MDM=Mdm;
		posx=x;
		posy=y;
	}



	public void draw() {
		syncpos(posx,posy);
		MDM.draw();
	}

	private void syncpos(int posx,int posy) {
		MDM.posupdate(posx, posy);
	}
	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void up() {
		posy-=moverate;
	}
	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void down() {
		posy+=moverate;
	}
	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void left() {
		posx-=moverate;
	}
	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void right() {
		posx+=moverate;
	}
}
