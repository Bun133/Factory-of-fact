package com.fof.graphics.ui;

import com.fof.game.main.fof_game;
import com.fof.register.ui.UIRegister;

import javax.swing.*;

public interface IUI {

    boolean isDisplay = false;
    void update(fof_game game);
    void init(UIManager manager);
    void add(UIRegister register);
}
