package map;

import assets.exception.NotMatch;
import graphics.JFrametools;
import graphics.TextureManager;

public class Chunk {
	private Block[] Blockdata=fillChunk(new Block());
	public Chunk(long[] inputdata) {
		if (inputdata.length!=900) {
			throw new NotMatch();
		}

		for(int cnt=0;cnt!=900;cnt++) {
			Blockdata[cnt].setdata(inputdata[cnt]);
		}
	}

	public Chunk() {
		for(int cnt=0;cnt!=900;cnt++) {
			Blockdata[cnt].setdata(0L);
		}
	}


	public Block getBlockdata(int x,int y) {
		return Blockdata[getpos(x,y)];
	}

	public int getpos(int x,int y){
		if (y==0) {
		return x;
		}else {
		return 30*(y-1)+x;
		}
	}

	public int getposx(int num) {
		return num%30;
	}

	public int getposy(int num) {
		if (num%30==0){
			return num/30+1;
		}else {
			return num/30;
		}
	}


	public void setblock(int x,int y,Block data) {
		Blockdata[getpos(x,y)]=data;
	}

	public void setblock(int x,int y,long data) {
		Blockdata[getpos(x,y)].setdata(data);
	}

	public Block getblock(int x,int y) {
		return Blockdata[getpos(x,y)];
	}

	public Block getblock(int num) {
		return Blockdata[num];
	}

	public void draw(TextureManager TM,JFrametools JFT,int x,int y) {
		for(int cnt=0;cnt!=900;cnt++) {
			Blockdata[cnt].draw(TM.gettexture(Blockdata[cnt]), JFT, (getposx(cnt))*64+x, (getposy(cnt))*64+y);
		}
	}

	private Block[] fillChunk(Block block) {
		Block[] onetime=new Block[900];
		for(int cnt=0;cnt!=900;cnt++) {
			onetime[cnt]=block;
		}
		return onetime;
	}
}
