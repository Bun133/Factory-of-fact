package com.fof.object.block.ores;

import com.fof.object.block.Block;
import com.fof.register.VanillaRegister;

public enum Ores {
    Copper(0, VanillaRegister.Copper);

    int meta;
    Block block;

    Ores(int meta, Block block) {

    }
}
