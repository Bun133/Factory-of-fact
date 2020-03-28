package com.fof.object.block.blocks;

import com.fof.events.RegisterEvent;
import com.fof.object.block.Block;
import com.fof.register.IRegistrable;

public class TestBlock extends Block implements IRegistrable {
    public TestBlock(String name, String id) {
        super(name, id);
    }

    @Override
    public void register(RegisterEvent event) {
        super.register(event);
    }
}
