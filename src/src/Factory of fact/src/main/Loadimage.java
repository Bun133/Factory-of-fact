package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Loadimage {
	public boolean load(String filepath) {
		File file=new File(filepath);
		if (!file.exists()){
		FileReader filereader;

			try {
				filereader = new FileReader(file);
			} catch (FileNotFoundException e1) {
				// TODO 自動生成された catch ブロック
				System.out.print("File Not Found.");
				e1.printStackTrace();
				return false;
			}

			BufferedReader bufferdreader=new BufferedReader(filereader);
			String data;
			try {
				while((data = bufferdreader.readLine()) != null) {
					System.out.print(data);

				}
			} catch (IOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}


		try {
			bufferdreader.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return true;
		}else {
		return false;
		}
	}
}
