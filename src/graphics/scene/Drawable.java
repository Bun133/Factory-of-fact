package graphics.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import graphics.JFrametools;

public class Drawable {
	int pos_x;
	int pos_y;
	int pos_size_x;
	int pos_size_y;
	Color Back_ground;

	public Drawable(String type,int x,int y,int size_x,int size_y,Color c) {Type=type;pos_x=x;pos_y=y;pos_size_x=size_x;pos_size_y=size_y;Back_ground=c;}
	public Drawable(String type,int x,int y,int size_x,int size_y,Color c,String text) {Type=type;pos_x=x;pos_y=y;pos_size_x=size_x;pos_size_y=size_y;Back_ground=c;Text=text;font=new Font(Font.SERIF,Font.PLAIN,12);}
	public Drawable(String type,int x,int y,int size_x,int size_y,Color c,String text,Font f) {Type=type;pos_x=x;pos_y=y;pos_size_x=size_x;pos_size_y=size_y;Back_ground=c;Text=text;font=f;}
	public Drawable(String type,int x,int y,int size_x,int size_y,Color c,String text,int size) {Type=type;pos_x=x;pos_y=y;pos_size_x=size_x;pos_size_y=size_y;Back_ground=c;Text=text;font=new Font(Font.SERIF,Font.PLAIN,size);}
	public Drawable(String type,int x,int y,int size_x,int size_y,Color c,Image img) {Type=type;pos_x=x;pos_y=y;pos_size_x=size_x;pos_size_y=size_y;Back_ground=c;Picture=img;}



	int getpos_x() {return pos_x;}
	int getpos_y() {return pos_y;}
	int getpos_size_x() {return pos_size_x;}
	int getpos_size_y() {return pos_size_y;}

	String Type;
	String getType() {return Type;}

	//Text
	String Text;
	Font font;
	String getText() {return Text;}
	Font getfont() {return font;}

	//Image
	Image Picture;
	Image getImage() {return Picture;}

	//Draw

	void draw(JFrametools JFT) {
		switch (Type) {
		case "Text":
			draw_background(JFT);
			JFT.drawString(font,Text,pos_x,pos_y,new Color(0,0,0));
			break;
		case "Image":
			JFT.drawImage(Picture, pos_x, pos_y);
			break;
		default:
			System.out.println("Worng Type");
			break;
		}
	}

	private void draw_background(JFrametools JFT) {JFT.fillRect(Back_ground,pos_x,pos_y,pos_size_x,pos_size_y);}

}
