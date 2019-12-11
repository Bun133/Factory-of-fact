package main;

import java.io.BufferedReader;
import java.io.IOException;

public class Textload {
	public String textloadofline(BufferedReader br,int line) {
		String linedata=null;
		for(int cnt=0;cnt!=line;cnt++) {
			try {
				linedata=br.readLine();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return "Error";
			}
		}
		return linedata;
	}

	public int filelength(BufferedReader br)  {
		String linedata=null;
		int cnt=0;
		try {
			linedata=br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		while(linedata!=null) {
			cnt++;
			try {
				linedata=br.readLine();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return cnt;
	}
}
