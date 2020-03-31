package com.fof.map;

import com.fof.game.main.fof_game;
import com.fof.graphics.Drawable;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;

public class Chunk {
    private onMapBlock[] blockList = new onMapBlock[fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE];
    private ChunkPos ChunkPos;

    public Chunk(Block block, ChunkPos pos) {
        this.ChunkPos = pos;
        for (int i = 0; i < fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE; i++) {
            blockList[i] = new onMapBlock(block, this, pos.getChunk_X(), pos.getChunk_Y());
        }
    }

    public onMapBlock getBlock(onMapBlock pos) {
        if (!isContain(pos)) throw new IllegalArgumentException("BlockPos not contain in this Chunk.");
        return blockList[getBlockIndex(pos)];
    }

    private int getBlockIndex(onMapBlock pos) {
        return getBlockPosInChunkX(pos) + getBlockPosInChunkY(pos) * fof_game.INSTANCE.CHUNK_SIZE;
    }

    private int getBlockPosInChunkX(onMapBlock pos) {
        return Math.max(getStartBlockPos().getPos_x(), pos.blockPos.getX()) - Math.min(getStartBlockPos().getPos_x(), pos.blockPos.getX());
    }

    private int getBlockPosInChunkY(onMapBlock pos) {
        return Math.max(getStartBlockPos().getPos_y(), pos.blockPos.getY()) - Math.min(getStartBlockPos().getPos_y(), pos.blockPos.getY());
    }

    private boolean isContain(onMapBlock pos) {
        return PosTransformer.INSTANCE.getChunkPos(pos.blockPos) == this.ChunkPos;
    }

    private onMapBlock getStartBlockPos() {
        return blockList[0];
    }

    public onMapBlock getFromIndex(int index) {
        return blockList[index];
    }

    public Drawable getDrawable(onMapBlock pos, int shift_x, int shift_y) {
        if (isContain(pos)) {
            return blockList[getBlockIndex(pos)].getDrawable(shift_x, shift_y);
        }
        return null;
    }

    public onMapBlock[] getBlocks() {
        return this.blockList;
    }

    public int getIndex(BlockPos pos) {
        return getIndex(pos.getX(), pos.getY());
    }

    private int getIndex(int x, int y) {
        return y * fof_game.INSTANCE.CHUNK_SIZE + x;
    }

    public ChunkPos getChunkPos() {
        return this.ChunkPos;
    }

    public void setBlock(onMapBlock block) {
        blockList[getIndex(block.blockPos)] = block;
    }
}
