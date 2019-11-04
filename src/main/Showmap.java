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
	public Graphics2D draw(Graphics2D gra,int x,int y,String filepath) {


		File file=new File(filepath);
		if (file.exists()==true) {

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

				int add_x=0;
				int add_y=0;
				Objectroot objroot=new Objectroot();
				int cnt=0;
				while(cnt<objectdata.length){
					if(objectdata[cnt]==null) {
						System.out.println("data is null");
						cnt++;
						continue;
					}
					String a="";
					String rgb="";
					int int_a=101;
					int int_r=256;
					int int_g=256;
					int int_b=256;
					String[] data=objectdata[cnt].split("#");
					a=data[0];
					rgb=data[1];
					int_a=Integer.parseInt(a);
					int_r=Integer.parseInt(rgb.substring(5,6));
					int_g=Integer.parseInt(rgb.substring(7,8));
					int_g=Integer.parseInt(rgb.substring(9,10));
					int_a=Integer.parseInt(a);
					c=new Color(int_r,int_g,int_b,int_a);
					add_x=objroot.getrootx(cnt,data.length);
					add_y=objroot.getrooty(cnt,data.length);

					gra.setColor(c);

					gra.drawLine(x+add_x, y+add_y, x+add_x, y+add_x);




					cnt++;
				}

				return gra;



		}else {
		System.out.println("File Not Found");
		return null;
		}
	}
}
