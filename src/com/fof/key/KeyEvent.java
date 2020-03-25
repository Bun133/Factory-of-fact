package com.fof.key;

import com.fof.game.main.fof_game;

import static java.awt.event.KeyEvent.VK_1;

public class KeyEvent{
    public void run(java.awt.event.KeyEvent event){
        switch (event.getKeyCode()){
            case VK_1:
                fof_game.INSTANCE.LOGGER.println("Exit by pressing key 1");
                System.exit(0);
                break;
        }
    }
}
