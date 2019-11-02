package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loadobject {
	public int loadobject(String filepath) {
		File file=new File(filepath);
		if (file.exists()) {
			try {
				FileReader filereader=new FileReader(file);
				BufferedReader br=new BufferedReader(filereader);
				String [] data = null;
				int cnt=0;
				while((data[cnt]=br.readLine())!=null) {
					cnt++;
				}
				br.close();
			}catch(IOException e) {

				e.printStackTrace();

				return 0;
			}



			return 1;//正常終了
		}else {
			System.out.print("File Not Found");
			return 0;
		}
	}
}
