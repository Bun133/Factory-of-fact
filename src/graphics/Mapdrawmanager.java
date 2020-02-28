package graphics;

import graphics.scene.Draw;
import map.Block;

public class Mapdrawmanager extends Draw {
	private JFrametools JFT;
	private map.Map Map;
	private int Cansee = 1;
	private TextureManager TM;
	private int posx = 0;
	private int posy = 0;
	private int posChunkx = 0;
	private int posChunky = 0;
	private final int moverate = 1;

	public Mapdrawmanager(JFrametools JFT_, TextureManager TM_) {
		JFT = JFT_;
		TM = TM_;
		System.out.println("YOU SHOULD \"loadmap\" AT First!");
		Map = new map.Map();
	}

	public Mapdrawmanager(JFrametools JFT_, TextureManager TM_, int x, int y) {
		JFT = JFT_;
		TM = TM_;
		posupdate(x, y);
		System.out.println("YOU SHOULD \"loadmap\" AT First!");
		Map = new map.Map();
	}

	public Mapdrawmanager(JFrametools JFT_, TextureManager TM_, int x, int y, map.Map map) {
		JFT = JFT_;
		TM = TM_;
		posupdate(x, y);
		loadmap(map);
	}

	public void loadmap(map.Map map) {
		Map = map;
	}

	public void draw() {
		posupdate(posx, posy);
		drawchunk(posChunkx, posChunky, posx, posy);
	}

	public void setblock(int chunk_x, int chunk_y, int x, int y, long data) {
		Map.setBlock(chunk_x, chunk_y, x, y, data);
	}

	public void setblock(int chunk_x, int chunk_y, int x, int y, Block data) {
		Map.setBlock(chunk_x, chunk_y, x, y, data);
	}

	private void drawchunk(int chunk_x,int chunk_y,int x,int y) {
		Map.getChunk(chunk_x, chunk_y).draw(TM, JFT, x, y);
	}

	/*private Chunk[] canseeChunk(int cansee) {

	}*/

	public void posupdate(int x, int y) {
		posx = x;
		posy = y;
		posChunkupdate(x, y);
		System.out.println("Posx:" + posx);
		System.out.println("Posy:" + posy);
	}

	private void posChunkupdate(int x, int y) {
		posChunkx = Map.getChunkx(x);
		posChunky = Map.getChunky(y);
	}

	public void up() {
		System.out.println("UP");
		posy -= moverate;
	}

	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void down() {
		posy += moverate;
	}

	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void left() {
		posx -= moverate;
	}

	/**
	 * @apiNote Call Only from KeyManager or AtKeyEvent Class
	 */
	public void right() {
		posx += moverate;
	}
}
