package com.fof.game.main;

import assets.util.Logger;
import com.fof.events.RegisterEvent;
import com.fof.graphics.Display;
import com.fof.graphics.Drawable;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.key.KeyEvent;
import com.fof.key.KeyManager;
import com.fof.object.item.Item;
import com.fof.util.file.FileMaster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class fof_game {
    public static fof_game INSTANCE = new fof_game();
    public String name;
    public final String Player_layer_name = "Player_layer";
    public layer test_layer = new layer("test_layer", layersProvider.INSTANCE);
    public Logger LOGGER = new Logger(System.out);
    public Display main_display = new Display(1000, 1000, layersProvider.INSTANCE);
    public KeyManager KM = new KeyManager((JFrame) main_display);
    public KeyEvent keyEvent = new KeyEvent();
    public final int BLOCK_SIZE=64;
    public final int CHUNK_SIZE=256;

    public void onRegisterEvent(RegisterEvent event) throws IOException, InterruptedException {
        //Init
        LOGGER.setTextColor(new Color(255, 255, 255));
        LOGGER.showDebug(true);
        LOGGER.println("INIT");
        Item test_item = new Item("test_item", 0).setTexture(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
        event.getRegister().addRegister(test_item);

        //test_layer.addDrawable(test_item.getDrawable().setPos(100,100));
        test_layer.addDrawable(new Drawable("TEST", 100, 100));
        test_layer.addDrawable(new Drawable(0, 0, 100, 100));

        KM.addclass(keyEvent);
        while (true) {
            main_display.draw();
            KM.tick();
            LOGGER.println("Tick");
            Thread.sleep(1);
        }
        //System.exit(0);
    }
}
