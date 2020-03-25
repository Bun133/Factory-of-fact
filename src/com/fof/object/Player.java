package com.fof.object;

import com.fof.game.main.fof_game;
import com.fof.graphics.IDrawable;
import com.fof.graphics.layer;
import com.fof.register.layer.layerManager;

public class Player implements IDrawable {
    @Override
    public layer draw() {
        return layerManager.INSTANCE.getlayerbyid(fof_game.Player_layer_name);
    }
}
