package com.fof.map;

import com.fof.game.main.fof_game;
import com.fof.graphics.Drawable;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;

public class Chunk {
    private onMapBlock[] blocklist = new onMapBlock[fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE];
    private ChunkPos chunkPos;

    public Chunk(Block block, ChunkPos pos) {
        this.chunkPos = pos;
        for (int i = 0; i < fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE; i++) {
            blocklist[i] = new onMapBlock(block, this, pos.getChunk_X(), pos.getChunk_Y());
        }
    }

    public onMapBlock getBlock(onMapBlock pos) {
        if (!isContain(pos)) throw new IllegalArgumentException("BlockPos not contain in this Chunk.");
        return blocklist[getBlockIndex(pos)];
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
        return PosTransformer.INSTANCE.getChunkPos(pos.blockPos) == this.chunkPos;
    }

    private onMapBlock getStartBlockPos() {
        return blocklist[0];
    }

    public onMapBlock getFromIndex(int index) {
        return blocklist[index];
    }

    public Drawable getDrawable(onMapBlock pos) {
        if (isContain(pos)) {
            return blocklist[getBlockIndex(pos)].getDrawable();
        }
        return null;
    }

    public onMapBlock[] getBlocks() {
        return this.blocklist;
    }

    public int getIndex(BlockPos pos) {
        return getIndex(pos.getX(), pos.getY());
    }

    private int getIndex(int x, int y) {
        return y * fof_game.INSTANCE.CHUNK_SIZE + x;
    }

    public ChunkPos getChunkPos() {
        return this.chunkPos;
    }

    public void setBlock(onMapBlock block) {
        blocklist[getIndex(block.blockPos)] = block;
    }
}
