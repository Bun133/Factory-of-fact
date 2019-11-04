package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loadobject {
	public String[] loadobject(String filepath) {
		File file=new File(filepath);
		if (file.exists()) {
			try {
				FileReader filereader=new FileReader(file);
				BufferedReader br=new BufferedReader(filereader);
				String [] data = null;
				int cnt=0;
				data[cnt]=br.readLine();
				while(data[cnt]!=null) {
					cnt++;
					data[cnt]=br.readLine();
				}
				br.close();
				return data;//正常終了

			}catch(IOException e) { //ファイル読み込み中のエラーキャッチ

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
