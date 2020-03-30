package com.fof.map.object;

import com.fof.graphics.Drawable;
import com.fof.map.Chunk;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.Pos;
import com.fof.object.block.Block;

public class onMapBlock extends Pos {
    public Block block;
    public BlockPos blockPos;
    public Chunk inChunk;

    public onMapBlock(Block block, Chunk chunk, BlockPos pos) {
        this.block = block;
        this.blockPos = pos;
        this.inChunk = chunk;
    }

    public onMapBlock(Block block, Chunk chunk, int x, int y) {
        this(block, chunk, chunk.getBlocks()[chunk.getIndex(new BlockPos(x, y))].blockPos);
    }

    public Drawable getDrawable() {
        return block.getDrawable().setPos(blockPos);
    }

    public onMapBlock setPos(int x, int y) {
        this.pos_x = x;
        this.pos_y = y;
        return this;
    }

    public onMapBlock setBlock(Block block) {
        this.block = block;
        return this;
    }
}
