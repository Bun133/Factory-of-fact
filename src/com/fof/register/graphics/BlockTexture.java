package com.fof.register.graphics;

import com.fof.map.pos.BlockPos;
import com.fof.object.block.Block;

import java.awt.*;

public class BlockTexture {
    private Image texture=null;
    private Block Block;
    private BlockPos BlockPos;

    public BlockTexture(BlockPos pos,Block block,Image img){
        this.BlockPos=pos;
        this.Block=block;
        this.texture=img;
    }

    public BlockTexture(int x,int y,Block block,Image img){
        this(new BlockPos(x,y),block,img);
    }
}
