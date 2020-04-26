package com.fof.map.object;

import com.fof.graphics.Drawable;
import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.Pos;
import com.fof.map.pos.onDisplayPos;
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


    /**
     * @param x
     * @param y
     * @return
     * @apiNote ブロック単体による描画処理がある場合のみtrueをセットしてください(アニメーションなど)
     */
    public Drawable getDrawable(int x, int y) {
        return block.getDrawable().setPos(new onDisplayPos(x, y));
    }

    public Drawable getDrawable(onDisplayPos pos) {
        return block.getDrawable().setPos(pos);
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
