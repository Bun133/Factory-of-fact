package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import assets.exception.Indexalreadyused;
import assets.exception.Indexnotsetup;
import file.Filemaster;

//import graphics.GetFPS;

import graphics.JFrametools;
import graphics.Mapdrawmanager;
import graphics.SetFPS;
import key.AtKeyEvent;
import key.KeyManager;
import key.KeyVanilla;

public class Main extends JFrame{
	public static void main(String[] args) {

		//DrawView dv=new DrawView(500,500);
		JFrametools JFT=new JFrametools("Factory of fact",500,500);
		//GetFPS FPStools=new GetFPS();
		SetFPS SetFPStools=new SetFPS();
		SetFPStools.setMaxFPS(60);
		Filemaster Fm=new Filemaster(100);
		KeyManager KM=new KeyManager(JFT.getJFrame());
		AtKeyEvent atk=new KeyVanilla();

		//Mdmは仕方ないよなあ？
		Mapdrawmanager Mdm=new Mapdrawmanager(JFT.getGraphics());
		try {
			Fm.newFilelistener("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0);
			Fm.newFilelistener("src\\assets\\textures\\blocks\\sand.png",1);
		} catch (FileNotFoundException | Indexalreadyused e) {
			e.printStackTrace();
		}

		System.out.println(Fm.getFiler(0).toString());
		try {
			System.out.println(Fm.getImage(0));
		} catch (Indexnotsetup e) {
			e.printStackTrace();
		}

		KM.addclass(atk);

		//JFT.setFull();
		System.out.println(Fm.getbytenum((byte) 0x15, 1, 1));
		//Main loop↓
		for(;;) {
			JFT.drawImage(Fm.getImage(1),0,0);
		}
	}
}
