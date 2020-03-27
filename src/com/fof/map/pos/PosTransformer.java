package com.fof.map.pos;

import com.fof.game.main.fof_game;

public class PosTransformer {
    public static PosTransformer INSTANCE = new PosTransformer();

    private PosTransformer() {
    }

    public ChunkPos getChunkPos(EntityPos pos) {
        return getChunkPos(getBlockPos(pos));
    }

    public ChunkPos getChunkPos(BlockPos blockPos) {
        double chunk_x = (double) blockPos.getX() / (double) fof_game.INSTANCE.CHUNK_SIZE;
        double chunk_y = (double) blockPos.getY() / (double) fof_game.INSTANCE.CHUNK_SIZE;

        return new ChunkPos(getNormalizedPos(chunk_x, chunk_y));
    }

    public BlockPos getBlockPos(EntityPos pos) {
        return new BlockPos(getNormalizedPos(pos.getPos_X(), pos.getPos_Y()));
    }


    private Pos getNormalizedPos(double x, double y) {
        int pos_x = 0;
        int pos_y = 0;
        if (x > 0.0D) {
            pos_x = (int) Math.ceil(x);
        } else if (x < 0.0D) {
            pos_x = (int) Math.floor(x);
        } else if (x == 0.0D) {
            pos_x = 1;
        }

        if (y > 0.0D) {
            pos_y = (int) Math.ceil(y);
        } else if (y < 0.0D) {
            pos_x = (int) Math.floor(x);
        } else if (y == 0.0D) {
            y = 1;
        }

        return new Pos(pos_x, pos_y);
    }
}
