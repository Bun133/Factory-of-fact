package com.fof.game.main;

import com.fof.events.RegisterEvent;
import com.fof.register.Register;

public class main {
    //Game Main Class
    public static void main(String[] args){
        fof_game.INSTANCE.onRegisterEvent(new RegisterEvent(Register.INSTANCE));
    }
}
