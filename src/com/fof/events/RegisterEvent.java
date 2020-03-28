package com.fof.events;

import com.fof.object.block.Block;
import com.fof.object.item.Item;
import com.fof.register.Register;

public class RegisterEvent<T> {
    private Register Register;

    public RegisterEvent(Register register) {
        this.Register = register;
    }

    public void register(Item item) {
        Register.addRegister(item);
    }

    public void register(Block block) {
        Register.addRegister(block);
    }


}
