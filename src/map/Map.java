package map;

import java.io.File;

public class Map {
	private Chunk[] right_up=new Chunk[100]; // +x,+y
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


}
