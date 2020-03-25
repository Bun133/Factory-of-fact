package com.fof.game.main;

import assets.util.Logger;
import com.fof.events.RegisterEvent;
import com.fof.graphics.Display;
import com.fof.graphics.layersProvider;
import com.fof.object.item.Item;

import java.awt.*;

public class fof_game {
    public static fof_game INSTANCE=new fof_game();
    public String name;
    public final String Player_layer_name="Player_layer";
    public Logger LOGGER=new Logger(System.out);
    public Display main_display=new Display(100,100, layersProvider.INSTANCE);

    public void onRegisterEvent(RegisterEvent event){
        //Init
        LOGGER.setTextColor(new Color(255,255,255));
        LOGGER.print("INIT");
        Item test_item=new Item();
        event.getRegister().addRegister(test_item,"test_item",0);
        LOGGER.print(event.getRegister().isThereItem(test_item));
    }
}
