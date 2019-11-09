package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loadobject {
	public String [] data=null;
	public String[] loadobject(String filepath) {
		File file=new File(filepath);
		if (file.exists()) {
			try {
				FileReader filereader=new FileReader(file);
				BufferedReader br=new BufferedReader(filereader);


				//行ごとに配列に入れる処理
				Textload textloder =new Textload();
				int length=textloder.filelength(br);
				for (int cnt=0;cnt==length;cnt++) {
					data[cnt]=textloder.textloadofline(br, cnt);	//ここ
				}

				br.close();
				if (data[0]==null) {								//ここ
					System.out.println("All Null");
				}
				return data;//正常終了(誰が正常と言った)

			}catch(IOException e) { //ファイル読み込み中のエラーキャッチ
				System.out.println("File Not Found");
				e.printStackTrace();

				String [] data=null;
				return data;
			}

		}else { //ファイルが存在しない
			System.out.print("File Not Found");
			String [] data=null;
			return data;
		}
	}

	/*public String[] loadobjectofnum(int num) {
		String [] data=null;

		return ;
	}*/
}
