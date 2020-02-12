package map;

import java.awt.Image;

import graphics.JFrametools;

public class Block {
	private int Texture;
	private String Textureid;
	private long data;

	private final int Default_Texture=2;
	private final String Default_Textureid="FactoryofFact:OhNo";
	public Block() {
		Texture=Default_Texture;
		Textureid=Default_Textureid;
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
