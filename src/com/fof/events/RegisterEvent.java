package com.fof.events;

import com.fof.register.Register;

public class RegisterEvent {
    private Register register;
    public RegisterEvent(Register register){
        this.register=register;
    }

    public Register getRegister(){return this.register;}
}
