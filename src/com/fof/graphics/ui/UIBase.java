package com.fof.graphics.ui;

import com.fof.game.main.fof_game;
import com.fof.register.ui.UIRegister;

import javax.swing.*;

public class UIBase implements IUI {
    //State
    int pos_x = 0;
    int pos_y = 0;
    int size_x = 100;
    int size_y = 100;

    @Override
    public void update(fof_game game) {
        //Update called each tick.
    }

    @Override
    public void init(UIManager manager) {
        // init called during init
        //(actually it called before add(UIRegister register))
    }

    @Override
    public void add(UIRegister register) {
        //Registry Event
        register.register(this);
    }
}
