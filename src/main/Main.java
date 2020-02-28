
package main;

import assets.exception.Indexalreadyused;
import assets.util.Logger;
import assets.util.Register;
import file.Filemaster;
import graphics.*;
import graphics.scene.Drawable;
import graphics.scene.Scene;
import key.AtKeyEvent;
import key.KeyManager;
import key.KeyVanilla;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

//import graphics.GetFPS;

public class Main extends JFrame {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    public static Logger log = new Logger(System.out);
    public static Register mainRegister = new Register();

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InterruptedException {


        JFrametools JFT = new JFrametools("Factory of fact", 500, 500);
        Filemaster Fm = new Filemaster(100);
        TextureManager TM = new TextureManager(100);
        KeyManager KM = new KeyManager(JFT.getJFrame());
        //Mdmは仕方ないよなあ？
        Mapdrawmanager Mdm = new Mapdrawmanager(JFT, TM);
        Camera MainCamera = new Camera(Mdm);
        AtKeyEvent VanillaKey = new KeyVanilla(MainCamera);
		Scene AtMap = new Scene(JFT);


		try {
			TM.addtexture("src\\assets\\textures\\title\\Factory_of_fact_logo.png", 0, "FactoryofFact:logo");
			TM.addtexture("src\\assets\\textures\\blocks\\sand.png", 1, "FactoryofFact:sand");
			TM.addtexture("src\\assets\\textures\\blocks\\OhNo.png", 2, "FactoryofFact:OhNo");
			TM.addtexture("src\\assets\\textures\\blocks\\stone.png", 3, "FactoryofFact:stone");
			TM.addtexture("src\\assets\\textures\\blocks\\water.png", 4, "FactoryofFact:water");
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


        AtMap.addDrawable(new Drawable("Text", 100, 200, 500, 500, new Color(255, 255, 255), "Test", 200), 1);

        AtMap.addDrawable(new Drawable(Mdm), 0);

        //Main loop↓
        for (; ; ) {
            AtMap.draw();
            Framelimiter.limitFPS();
            //MainCamera.draw();
            //JFT.drawImage(TM.gettexture("FactoryofFact:OhNo"), 0, 0);
            //JFT.drawImage(Fm.getImage(2),0,0);
        }
    }
}