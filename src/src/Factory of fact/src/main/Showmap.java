package main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Showmap {
	public Showmap() {
	}
	public Object draw(DrawView dv,BufferedImage bi,int x,int y,String filepath) {

		Graphics2D gra = bi.createGraphics();
		File file=new File(filepath);
		if (file.exists()) {

			try {
				FileReader filereader=new FileReader(file);
				BufferedReader br=new BufferedReader(filereader);

				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return null;
				}
				Loadobject loadmanager=new Loadobject();
				String [] objectdata=loadmanager.loadobject(filepath);
				//ここに読み込みファイルからウィンドウ上に書きこみ。
				//ファイルどう書くか決めないと。
				return bi;



		}else {
		return null;
		}
	}
}
