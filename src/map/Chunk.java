package map;

import assets.exception.NotMatch;

public class Chunk {
	private long[] Blockdata=new long[30*30];
	public Chunk(long[] inputdata) {
		if (inputdata.length!=900) {
			throw new NotMatch();
		}

		for(int cnt=0;cnt!=900;cnt++) {
			Blockdata[cnt]=inputdata[cnt];
		}
	}

	public Chunk() {
		for(int cnt=0;cnt!=900;cnt++) {
			Blockdata[cnt]=0L;
		}
	}


	public long getBlockdata(int x,int y) {
		return Blockdata[getpos(x,y)];
	}

	private int getpos(int x,int y) {
		if (y==0) {
		return x;
		}else {
		return 30*(y-1)+x;
		}
	}


	public void setblock(int x,int y,long data) {
		Blockdata[getpos(x,y)]=data;
	}

	public long getblock(int x,int y) {
		return Blockdata[getpos(x,y)];
	}

	public long getblock(int num) {
		return Blockdata[num];
	}
}
