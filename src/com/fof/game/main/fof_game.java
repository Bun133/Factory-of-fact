package com.fof.game.main;

import assets.util.Logger;
import com.fof.events.RegisterEvent;
import com.fof.graphics.Display;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.key.KeyEvent;
import com.fof.key.KeyManager;
import com.fof.object.item.Item;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class fof_game {
    public static fof_game INSTANCE=new fof_game();
    public String name;
    public final String Player_layer_name="Player_layer";
    public layer test_layer=new layer("test_layer",0,layersProvider.INSTANCE);
    public Logger LOGGER=new Logger(System.out);
    public Display main_display=new Display(1000,1000, layersProvider.INSTANCE);
    public KeyManager KM=new KeyManager((JFrame)main_display);
    public KeyEvent keyEvent=new KeyEvent();

    public void onRegisterEvent(RegisterEvent event) throws MalformedURLException, InterruptedException {
        //Init
        LOGGER.setTextColor(new Color(255, 255, 255));
        LOGGER.println("INIT");
        URL url = new File("src\\assets\\textures\\title\\Factory_of_fact_logo.png").toURI().toURL();
        Item test_item = new Item("test_item", 0).setTexture(Toolkit.getDefaultToolkit().createImage(url));
        event.getRegister().addRegister(test_item);
        LOGGER.println(event.getRegister().isThereItem(test_item));
        test_layer.addDrawable(test_item.getDrawable());
        LOGGER.println(layersProvider.INSTANCE.getlayers());
        KM.addclass(keyEvent);
        while(true) {
            main_display.draw();
            KM.tick();
            Thread.sleep(1);
        }
        //System.exit(0);
    }
}
