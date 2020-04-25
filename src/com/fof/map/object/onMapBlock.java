package com.fof.map.object;

import com.fof.graphics.Drawable;
import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.Pos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;

public class onMapBlock extends Pos {
    public Block block;
    public BlockPos blockPos;
    public Chunk inChunk;
    public Map inMap;

    public onMapBlock(Map map, Block block, Chunk chunk, BlockPos pos) {
        this.block = block;
        this.blockPos = pos;
        this.inChunk = chunk;
        this.inMap = map;
    }

    public onMapBlock(Map map, Block block, Chunk chunk, int x, int y) {
        this(map, block, chunk, new BlockPos(x, y));
    }

    public Drawable getDrawable(int shift_x, int shift_y) {
        return block.getDrawable().setPos(PosTransformer.INSTANCE.getOnDisplay(blockPos, shift_x, shift_y));
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
