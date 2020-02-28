package map;

import java.io.File;

public class Map {
	private Chunk[][] Chunks = new Chunk[4][100];

	//Memo
	/**
	 * @apiNote Mapの縦横フルサイズを表します
	 */
	public final int size = 10 * 2;
	/**
	 * @apiNote Mapのチャンクサイズ(4分割中の一つ)を表します
	 */
	private final int Chunks_size = 10;

	public Map(File MapFile) {

	}

	public Map() {
		for (int cnt = 0; cnt != 10; cnt++) {
			Chunks[0][cnt] = new Chunk();    //right_up
			Chunks[1][cnt] = new Chunk();    //right_down
			Chunks[2][cnt] = new Chunk();    //left_down
			Chunks[3][cnt] = new Chunk();    //left_up

		}
	}

	public void setBlock(int Chunk_x, int Chunk_y, int x, int y, long num) {
		getChunk(Chunk_x, Chunk_y).setBlock(x, y, num);
	}

	public void setBlock(int Chunk_x, int Chunk_y, int x, int y, Block block) {
		getChunk(Chunk_x, Chunk_y).setBlock(x, y, block);
	}

	public Block getBlock(int Chunk_x, int Chunk_y, int x, int y) {
		return getChunk(Chunk_x, Chunk_y).getBlock(x, y);
	}

	public Chunk getChunk(int Chunk_x, int Chunk_y) {
		return Chunks[getPos(Chunk_x, Chunk_y)][getChunkNum(Chunk_x, Chunk_y)];
	}

	private int getPos(int Chunk_x, int Chunk_y) {
		if (Chunk_x == 0 && Chunk_y == 0) {
			return 0;
		}
		if (Chunk_x > 0) {
			if (Chunk_y > 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (Chunk_y > 0) {
				return 3;
			} else {
				return 2;
			}
		}
	}

	private int getChunkNum(int Chunk_x, int Chunk_y) {
		if (Chunk_x < 0) Chunk_x = Chunk_x * -1;
		if (Chunk_y < 0) Chunk_y = Chunk_y * -1;

		if (Chunk_y == 0) {
			return Chunk_x;
		} else {
			return (Chunk_y - 1) * Chunks_size + Chunk_x;
		}
	}

	public int getChunkx(int posx) {
		return posx / 30;
	}

	public int getChunky(int posy) {
		return posy / 30;
	}

	public Chunk[] getChunks(MapPos left_up, MapPos right_down) {
		return getChunks(left_up.Pos_x, left_up.Pos_y, right_down.Pos_x, right_down.Pos_y);
	}

	public Chunk[] getChunks(int left, int up, int right, int down) {
		Chunk[] Onetime = new Chunk[(right - left) * (down - up)];
		for (int x = 1; x != right - left + 1; x++) {
			for (int y = 1; y != down - up + 1; y++) {
				Onetime[x * y] = getChunk(x, y);
			}
		}
		return Onetime;
	}

	/*private Chunk[] right_up=new Chunk[100]; // +x,+y
	private Chunk[] left_up=new Chunk[100];// -x +y
	private Chunk[] right_down=new Chunk[100];// +x -y
	private Chunk[] left_down=new Chunk[100];//-x -y

	public Map(File mapfile) {

	}

	public Map() {
		for(int cnt=0;cnt!=10;cnt++) {
			right_up[cnt]=new Chunk();
			left_up[cnt]=new Chunk();
			right_down[cnt]=new Chunk();
			left_down[cnt]=new Chunk();
		}
	}

	public void setBlock(int chunk_x,int chunk_y,int x,int y,long num) {
		getpos(chunk_x,chunk_y)[getposnum(chunk_x,chunk_y)].setblock(x,y,num);
	}

	public void setBlock(int chunk_x,int chunk_y,int x,int y,Block num) {
		getpos(chunk_x,chunk_y)[getposnum(chunk_x,chunk_y)].setblock(x,y,num);
	}

	public Block getblockdata(int chunk_x,int chunk_y,int x,int y) {
		return getChunk(chunk_x,chunk_y).getBlockdata(x, y);
	}

	public Chunk getChunk(int Chunk_x,int Chunk_y) {
		return getpos(Chunk_x,Chunk_y)[getposnum(Chunk_x,Chunk_y)];
	}

	private Chunk[] getpos(int Chunk_x,int Chunk_y) {
		if(Chunk_x==0 && Chunk_y==0) {
			return right_up;
		}
		if (Chunk_x>0) {
			if (Chunk_y>0) {
				return right_up;
			}else {
				return right_down;
			}
		}else {
			if (Chunk_y>0) {
				return left_up;
			}else {
				return left_down;
			}
		}
	}

	private int getposnum(int chunk_x,int chunk_y) {
		if (chunk_x<0) {
			chunk_x=chunk_x*-1;
		}
		if (chunk_y<0) {
			chunk_y=chunk_y*-1;
		}
		if (chunk_x==0 && chunk_y==0) {
			return 0;
		}
		int one_x=chunk_x;
		int one_y=chunk_y;
		while(one_x!=1) {
			one_x-=1;
			one_y=+1;
		}
		return (one_x-1)/2*(2+(one_x-2)*2)+chunk_x;
	}

	public int getChunkx(int posx) {
		return posx/30;
	}

	public int getChunky(int posy) {
		return posy/30;
	}


	public Chunk getnowChunk(int posx,int posy) {
		return getChunk(getChunkx(posx),getChunky(posy));
	}*/
}
