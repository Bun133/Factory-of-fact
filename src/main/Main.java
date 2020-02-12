package main;

import java.awt.Color;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import assets.exception.Indexalreadyused;
import file.Filemaster;
import graphics.Camera;

//import graphics.GetFPS;

import graphics.JFrametools;
import graphics.Mapdrawmanager;
import graphics.SetFPS;
import graphics.TextureManager;
import graphics.scene.Drawable;
import graphics.scene.Scene;
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
		//Mdmは仕方ないよなあ？
		Mapdrawmanager Mdm=new Mapdrawmanager(JFT,TM);
		Camera MainCamera=new Camera(Mdm);
		AtKeyEvent VanillaKey=new KeyVanilla(MainCamera);
		Scene AtMap=new Scene(JFT);


		try {
			TM.addtexture("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0,"FactoryofFact:logo");
			TM.addtexture("src\\assets\\textures\\blocks\\sand.png", 1,"FactoryofFact:sand");
			TM.addtexture("src\\assets\\textures\\blocks\\OhNo.png", 2,"FactoryofFact:OhNo");
			TM.addtexture("src\\assets\\textures\\blocks\\stone.png",3,"FactoryofFact:stone");
			TM.addtexture("src\\assets\\textures\\blocks\\water.png", 4,"FactoryofFact:water");
			/*Fm.newFilelistener("src\\assets\\textures\\title\\Factory_of_fact_logo.png",0);
			Fm.newFilelistener("src\\assets\\textures\\blocks\\sand.png",1);
			Fm.newFilelistener("src\\assets\\textures\\blocks\\OhNo.png",2);*/
			Fm.newFilelistener("LICENSE",0);
		} catch (FileNotFoundException | Indexalreadyused e) {
			e.printStackTrace();
		}






		//AtKeyEvent Class include
		KM.addclass(VanillaKey);
		//JFTsetFull
		//JFT.setFull();


		AtMap.addDrawable(new Drawable("Text",100,200,500,500,new Color(255,255,255),"Test",200),1);
		//Main loop↓
		for(;;){
			AtMap.draw();
			//MainCamera.draw();
			//JFT.drawImage(TM.gettexture("FactoryofFact:OhNo"), 0, 0);
			//JFT.drawImage(Fm.getImage(2),0,0);
		}
	}
}
