package com.fof.map.object;

import com.fof.graphics.Drawable;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.Pos;
import com.fof.object.block.Block;

public class onMapBlock extends Pos {
    public Block block;
    public BlockPos blockPos;

    public onMapBlock(Block block,BlockPos pos){
        this.block=block;
        this.blockPos=pos;
    }

    public onMapBlock(Block block,int x,int y){
        this(block,new BlockPos(x,y));
    }

    public Drawable getDrawable() {
        return block.getDrawable().setPos(blockPos);
    }
}
