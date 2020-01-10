package graphics;

public class Mapdrawmanager{
	private JFrametools JFT;
	private map.Map Map;
	public Mapdrawmanager(JFrametools JFT_){
		JFT=JFT_;
		System.out.println("YOU SHOULD \"loadmap\" AT First!");
	}

	public void loadmap() {
	}
	public void draw() {

	}

	public void setblock(int chunk_x,int chunk_y,int x,int y,long data) {
		Map.set(chunk_x, chunk_y, x, y, data);
	}

	private void drawchunk(int chunk_x,int chunk_y) {
		for(int cnt=0;cnt!=900;cnt++) {
			Map.getChunk(chunk_x, chunk_y).getblock(cnt);
		}
	}


}
