package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import assets.exception.Indexalreadyused;
import assets.exception.Indexnotsetup;
import file.Filemaster;

//import graphics.GetFPS;

import graphics.JFrametools;
import graphics.SetFPS;

public class Main extends JFrame{
	public static void main(String[] args) {

		//DrawView dv=new DrawView(500,500);
		JFrametools JFT=new JFrametools("Factory of fact",500,500);
		//GetFPS FPStools=new GetFPS();
		SetFPS SetFPStools=new SetFPS();
		SetFPStools.setMaxFPS(60);
		Filemaster Fm=new Filemaster(100);
		try {
			Fm.newFilelistener("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0);
		} catch (FileNotFoundException | Indexalreadyused e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println(Fm.getFiler(0).toString());
		try {
			System.out.println(Fm.getImage(0));
		} catch (Indexnotsetup e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		JFT.setFull();
		for(;;) {
			JFT.drawImage(Fm.getImage(0),0,0,500,500);
		}



	}

}
