package map;

import java.awt.Image;

import graphics.JFrametools;

public class Block {
	private int Texture;
	private String Textureid;
	private long data;
	public Block() {
		Texture=2;
		Textureid="FactoryofFact:OhNo";
	}

	public Block(int Texture_,String id) {
		Texture=Texture_;
		Textureid=id;
	}

	public int getTexture() {
		return Texture;
	}

	public String getTextureid() {
		return Textureid;
	}

	public void setdata(long data_) {
		data=data_;
	}

	public long getdata() {
		return data;
	}

	public void draw(Image img,JFrametools JFT,int x,int y) {
		JFT.drawImage(img, x, y);
	}
}
