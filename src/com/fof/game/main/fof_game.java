package com.fof.game.main;

import assets.util.Logger;
import com.fof.events.RegisterEvent;
import com.fof.graphics.Display;
import com.fof.graphics.Drawable;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.key.KeyEvent;
import com.fof.key.KeyManager;
import com.fof.object.block.Block;
import com.fof.object.item.Item;
import com.fof.register.graphics.TextureManager;
import com.fof.util.file.FileMaster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class fof_game {
    public static fof_game INSTANCE;

    static {
        try {
            INSTANCE = new fof_game();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String name;
    public final String Player_layer_name = "Player_layer";
    public layersProvider main_provider = new layersProvider();
    public layer test_layer = new layer("test_layer", main_provider);
    public Logger LOGGER = new Logger(System.out);
    public Display main_display = new Display("Fof_Game", 1000, 1000, main_provider, false);
    //public Thread debug_INSTANCE=new fof_debug();
    public KeyManager KM = new KeyManager((JFrame) main_display);
    public KeyEvent keyEvent = new KeyEvent();
    public final int BLOCK_SIZE = 64;
    public final int CHUNK_SIZE = 256;

    public fof_game() throws IOException {
    }

    public void onRegisterEvent(RegisterEvent event) throws IOException, InterruptedException {
        //Init
        LOGGER.setTextColor(new Color(255, 255, 255));
        LOGGER.showDebug(false);
        LOGGER.println("INIT");
        Item test_item = new Item("test_item", "test_item").setTexture(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
        event.register(test_item);

        Block test_block = new Block("test_block", "test_block").setTexture(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));


        //test_layer.addDrawable(test_item.getDrawable().setPos(100,100));
        test_layer.addDrawable(new Drawable("TEST", 100, 100));
        test_layer.addDrawable(new Drawable(0, 0, 100, 100));
        test_layer.addDrawable(new Drawable(TextureManager.INSTANCE.getTexture(test_block)));

        KM.addclass(keyEvent);
        //debug_INSTANCE.start();
        while (true) {
            main_display.draw();
            KM.tick();
            LOGGER.println("Tick");
            LOGGER.println("Frame:" + main_display.toString() + "'FPS:" + main_display.FPSGetter.getFPS() + "FPS");
            Thread.sleep(1);
        }
        //System.exit(0);
    }
}
