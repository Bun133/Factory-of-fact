package com.fof.game.main;

import com.fof.events.RegisterEvent;
import com.fof.register.Register;
import com.fof.util.annotation.Version;

import java.io.IOException;

public class main {
    //Game Main Class
    @Version(ver = "1.0", ver_int = 1)
    public static void main(String[] args) throws IOException, InterruptedException {
        fof_game.INSTANCE.onRegisterEvent(new RegisterEvent(Register.INSTANCE));
    }
}
