package com.fof.game.main;

import com.fof.events.RegisterEvent;
import com.fof.register.Register;

import java.net.MalformedURLException;

public class main {
    //Game Main Class
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        fof_game.INSTANCE.onRegisterEvent(new RegisterEvent(Register.INSTANCE));
    }
}
