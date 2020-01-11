package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import assets.exception.Indexalreadyused;
import file.Filemaster;

//import graphics.GetFPS;

import graphics.JFrametools;
import graphics.Mapdrawmanager;
import graphics.SetFPS;
import graphics.TextureManager;
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
		TextureManager TM=new TextureManager(100);
		KeyManager KM=new KeyManager(JFT.getJFrame());
		AtKeyEvent atk=new KeyVanilla();

		//Mdmは仕方ないよなあ？
		Mapdrawmanager Mdm=new Mapdrawmanager(JFT,TM);
		try {
			TM.addtexture("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0,"FactoryofFact:logo");
			TM.addtexture("src\\assets\\textures\\blocks\\sand.png", 1,"FactoryofFact:sand");
			TM.addtexture("src\\assets\\textures\\blocks\\OhNo.png", 2,"FactoryofFact:OhNo");
			/*Fm.newFilelistener("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0);
			Fm.newFilelistener("src\\assets\\textures\\blocks\\sand.png",1);
			Fm.newFilelistener("src\\assets\\textures\\blocks\\OhNo.png",2);*/
			Fm.newFilelistener("LICENSE",3);
		} catch (FileNotFoundException | Indexalreadyused e) {
			e.printStackTrace();
		}







		KM.addclass(atk);

		JFT.setFull();

		//Main loop↓
		for(;;) {
			Mdm.draw();
			//JFT.drawImage(TM.gettexture("FactoryofFact:OhNo"), 0, 0);
			//JFT.drawImage(Fm.getImage(2),0,0);
		}
	}
}
