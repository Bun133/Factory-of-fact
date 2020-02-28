package graphics.scene;

import graphics.JFrametools;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Drawable {
	int pos_x;
	int pos_y;
	int pos_size_x;
	int pos_size_y;
	Color Back_ground;

	public Drawable(String type, int x, int y, int size_x, int size_y, Color c) {
		Type = type;
		pos_x = x;
		pos_y = y;
		pos_size_x = size_x;
		pos_size_y = size_y;
		Back_ground = c;
	}

	public Drawable(String type, int x, int y, int size_x, int size_y, Color c, String text) {
		Type = type;
		pos_x = x;
		pos_y = y;
		pos_size_x = size_x;
		pos_size_y = size_y;
		Back_ground = c;
		Text = text;
		font = new Font(Font.SERIF, Font.PLAIN, 12);
	}

	public Drawable(String type, int x, int y, int size_x, int size_y, Color c, String text, Font f) {
		Type = type;
		pos_x = x;
		pos_y = y;
		pos_size_x = size_x;
		pos_size_y = size_y;
		Back_ground = c;
		Text = text;
		font = f;
	}

	public Drawable(String type, int x, int y, int size_x, int size_y, Color c, String text, int size) {
		Type = type;
		pos_x = x;
		pos_y = y;
		pos_size_x = size_x;
		pos_size_y = size_y;
		Back_ground = c;
		Text = text;
		font = new Font(Font.SERIF, Font.PLAIN, size);
	}

	public Drawable(String type, int x, int y, int size_x, int size_y, Color c, Image img) {
		Type = type;
		pos_x = x;
		pos_y = y;
		pos_size_x = size_x;
		pos_size_y = size_y;
		Back_ground = c;
		Picture = img;
	}

	public Drawable(Method m, Object obj) {
		Type = "Method";
		pos_x = 0;
		pos_y = 0;
		method = m;
		object = obj;
	}

	public Drawable(Draw d) {
		Type = "Draw";
		draw = d;
		pos_x = 0;
		pos_y = 0;
	}


	int getpos_x() {
		return pos_x;
	}

	int getpos_y() {
		return pos_y;
	}

	int getpos_size_x() {
		return pos_size_x;
	}

	int getpos_size_y() {
		return pos_size_y;
	}

	String Type;

	String getType() {
		return Type;
	}

	//Text
	String Text;
	Font font;

	String getText() {
		return Text;
	}

	Font getfont() {
		return font;
	}

	//Image
	Image Picture;

	Image getImage() {
		return Picture;
	}

	//Method
	Method method = null;
	Object object = null;
	//DrawClass
	Draw draw;
	//Draw

	void draw(JFrametools JFT) throws InvocationTargetException, IllegalAccessException {
		switch (Type) {
			case "Text":
				draw_background(JFT);
				JFT.drawString(font, Text, pos_x, pos_y, new Color(0, 0, 0));
				System.out.println("GraphicsのdrawStringは推奨されていません");
				break;
			case "Image":
				JFT.drawImage(Picture, pos_x, pos_y);
				break;
			case "Method":
				method.invoke(object);
				break;
			case "Draw":
				draw.draw();
				break;
			default:
				System.out.println("Worng Type");
				break;
		}
	}

	private void draw_background(JFrametools JFT) {JFT.fillRect(Back_ground,pos_x,pos_y,pos_size_x,pos_size_y);}

}
