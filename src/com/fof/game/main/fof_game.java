package com.fof.game.main;

import assets.util.Logger;
import com.fof.events.RegisterEvent;
import com.fof.graphics.Display;
import com.fof.graphics.Drawable;
import com.fof.graphics.camera.Camera;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.graphics.map.MapDrawer;
import com.fof.key.KeyEvent;
import com.fof.key.KeyManager;
import com.fof.map.Map;
import com.fof.map.MapManager;
import com.fof.map.pos.onDisplayPos;
import com.fof.map.pos.onDisplayRect;
import com.fof.object.block.Block;
import com.fof.object.item.Item;
import com.fof.player.Player;
import com.fof.register.Register;
import com.fof.register.graphics.TextureManager;
import com.fof.util.file.FileMaster;

import java.awt.*;
import java.io.IOException;

public class fof_game {
    public static fof_game INSTANCE;

    static {
        INSTANCE = new fof_game();
    }

    public String name;
    public final String Player_layer_name = "Player_layer";
    public layersProvider main_provider = new layersProvider();
    public layer test_layer = new layer("test_layer", main_provider);
    public Logger LOGGER = new Logger(System.out);
    public Display main_display = new Display("Fof_Game", 1000, 1000, main_provider, false);
    //public Thread debug_INSTANCE=new fof_debug();
    public KeyManager KM = new KeyManager(main_display);
    public KeyEvent keyEvent = new KeyEvent();
    public final int BLOCK_SIZE = 64;
    public final int CHUNK_SIZE = 16;
    public MapManager MapManager = com.fof.map.MapManager.VANILLA_INSTANCE;
    public Map Current_Map = MapManager.dummy_Map();
    public Player player = new Player(Current_Map);
    public Camera main_camera;
    //public final int CHUNK_SIZE = 256;


    public void onRegisterEvent(RegisterEvent event) throws IOException, InterruptedException {
        //Init
        LOGGER.setTextColor(new Color(255, 255, 255));
        LOGGER.showDebug(true);
        LOGGER.println("INIT");
        Item test_item = new Item("test_item", "test_item").setTexture(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
        event.register(test_item);

        Block test_block = new Block("test_block", "test_block").setTexture(FileMaster.INSTANCE.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
        Register.INSTANCE.addRegister(test_block);


        //test_layer.addDrawable(test_item.getDrawable().setPos(100,100));
        test_layer.addDrawable(new Drawable("TEST", new onDisplayPos(100, 300)));
        test_layer.addDrawable(new Drawable(new Color(100, 255, 162), new onDisplayRect(new onDisplayPos(0, 0), new onDisplayPos(100, 100))));
        test_layer.addDrawable(new Drawable(TextureManager.INSTANCE.getTexture(test_block), new onDisplayPos(150, 150)));
        main_camera = new Camera(main_provider, Current_Map, player, main_display);
        MapDrawer mapDrawer = new MapDrawer("Map_Layer", main_provider, Current_Map, main_camera);
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
