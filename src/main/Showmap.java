package main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Showmap {
	public Showmap() {
	}
	public Graphics2D draw(DrawView dv,Graphics2D gra,int x,int y,String filepath) {


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
				Color c=new Color(0,0,0,0);//RGB+透明度(RGBA)
				int cnt=0;
				while(cnt!=objectdata.length){
					String [] data=null;
					String a="";
					String rgb="";
					int int_a=101;
					int int_r=256;
					int int_g=256;
					int int_b=256;
					data=objectdata[cnt].split("#");
					a=data[0];
					rgb=data[1];
					int_a=Integer.parseInt(a);




					cnt++;
				}

				gra.setColor(c);
				gra.drawLine(x, y, x, y);
				return gra;



		}else {
		return null;
		}
	}
}
