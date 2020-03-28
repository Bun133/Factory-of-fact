package com.fof.map;

import com.fof.game.main.fof_game;
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
            blocklist[i] = new onMapBlock(block, pos.getChunk_X(), pos.getChunk_Y());
        }
    }

    public onMapBlock getBlock(BlockPos pos) {
        if (!isContain(pos)) throw new IllegalArgumentException("BlockPos not contain in this Chunk.");
        return blocklist[getBlockIndex(pos)];
    }

    private int getBlockIndex(BlockPos pos) {
        return getBlockPosInChunkX(pos) + getBlockPosInChunkY(pos) * fof_game.INSTANCE.CHUNK_SIZE;
    }

    private int getBlockPosInChunkX(BlockPos pos) {
        return Math.max(getStartBlockPos().getPos_x(), pos.getX()) - Math.min(getStartBlockPos().getPos_x(), pos.getX());
    }

    private int getBlockPosInChunkY(BlockPos pos) {
        return Math.max(getStartBlockPos().getPos_y(), pos.getY()) - Math.min(getStartBlockPos().getPos_y(), pos.getY());
    }

    private boolean isContain(BlockPos pos) {
        return PosTransformer.INSTANCE.getChunkPos(pos) == this.chunkPos;
    }

    private onMapBlock getStartBlockPos() {
        return blocklist[0];
    }
}
