package com.fof.object.itemblock;

import com.fof.object.block.Block;
import com.fof.object.item.Item;

public class ItemBlock extends Item {

    private ItemBlock(Block block) {
        super(block.name, block.id);
    }

    public static ItemBlock ItemBlockGenelator(Block block) {
        return new ItemBlock(block);
    }
}
