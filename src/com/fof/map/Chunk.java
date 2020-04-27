package com.fof.map;

import com.fof.game.main.fof_game;
import com.fof.graphics.Drawable;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.map.pos.EntityPos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;
import com.fof.register.Register;

public class Chunk {
    private onMapBlock[] blockList = new onMapBlock[fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE];
    private ChunkPos ChunkPos;
    private Map map;

    public Chunk(Map map, Block block, ChunkPos pos) {
        this.ChunkPos = pos;
        for (int x = 0; x < fof_game.INSTANCE.CHUNK_SIZE; x++) {
            for (int y = 0; y < fof_game.INSTANCE.CHUNK_SIZE; y++) {
                blockList[x * fof_game.INSTANCE.CHUNK_SIZE + y] = new onMapBlock(map, block, this, pos.getChunk_X() * fof_game.INSTANCE.CHUNK_SIZE + x, pos.getChunk_Y() * fof_game.INSTANCE.CHUNK_SIZE + y);
            }
        }


//        for (int i = 0; i < fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE; i++) {
//            blockList[i] = new onMapBlock(map, block, this, pos.getChunk_X(), pos.getChunk_Y());
//        }
        this.map = map;
    }

    public onMapBlock getBlock(BlockPos pos) {
        if (!isContain(pos)) throw new IllegalArgumentException("BlockPos not contain in this Chunk.");
        return blockList[this.Editor.getIndex(pos)];
    }

//    public int getBlockIndex(BlockPos pos) {
//        return getBlockPosInChunkX(pos.getPos_x()) + getBlockPosInChunkY(pos.getPos_y()) * fof_game.INSTANCE.CHUNK_SIZE;
//    }
//
//    private int getBlockPosInChunkX(int x) {
//        return x % fof_game.INSTANCE.CHUNK_SIZE;
//        return Math.max(getStartBlockPos().getPos_x(), pos.blockPos.getX()) - Math.min(getStartBlockPos().getPos_x(), pos.blockPos.getX());
//    }
//
//    private int getBlockPosInChunkY(int y) {
//        return y % fof_game.INSTANCE.CHUNK_SIZE;
//        return Math.max(getStartBlockPos().getPos_y(), pos.blockPos.getY()) - Math.min(getStartBlockPos().getPos_y(), pos.blockPos.getY());
//    }

    private boolean isContain(BlockPos pos) {
        return PosTransformer.INSTANCE.getChunkPos(pos) == this.ChunkPos;
    }

    private onMapBlock getStartBlockPos() {
        return blockList[0];
    }

    public onMapBlock getFromIndex(int index) {
        return blockList[index];
    }

    @Deprecated
    public Drawable getDrawable(BlockPos pos, int x, int y) {
        if (isContain(pos)) {
            return blockList[this.Editor.getIndex(pos)].getDrawable(x, y);
        }
        return null;
    }

    public onMapBlock[] getBlocks() {
        return this.blockList;
    }

//    public int getIndex(BlockPos pos) {
//        return getIndex(pos.getX(), pos.getY());
//    }
//
//    private int getIndex(int x, int y) {
//        return y * fof_game.INSTANCE.CHUNK_SIZE + x;
//    }

    public ChunkPos getChunkPos() {
        return this.ChunkPos;
    }


    public Generator generator = new Generator();

    public class Generator {
        public void Generate() {
            //TODO
            GenerateWithBlock(Register.INSTANCE.getBlock("test_block"));
        }

        public void GenerateWithBlock(Block block) {
            for (int x = 0; x < fof_game.INSTANCE.CHUNK_SIZE; x++) {
                for (int y = 0; y < fof_game.INSTANCE.CHUNK_SIZE; y++) {
                    setBlock(block, new BlockPos(x, y));
                }
            }
        }

        private void setBlock(Block block, BlockPos pos) {
            Chunk.this.Editor.setBlock(new onMapBlock(map, block, Chunk.this, pos));
        }
    }

    public Editor Editor = new Editor();

    public class Editor {
        private Editor() {
        }

        public Chunk UPChunk() {
            return map.Editor.getChunk(Chunk.this.ChunkPos.UPChunkPos());
        }

        public Chunk DownChunk() {
            return map.Editor.getChunk(Chunk.this.ChunkPos.DOWNChunkPos());
        }

        public Chunk LEFTChunk() {
            return map.Editor.getChunk(Chunk.this.ChunkPos.LEFTChunkPos());
        }

        public Chunk RIGHTChunk() {
            return map.Editor.getChunk(Chunk.this.ChunkPos.RIGHTChunkPos());
        }

        public void setBlock(Block block, BlockPos pos) {
            setBlock(new onMapBlock(Chunk.this.map, block, Chunk.this, pos));
        }

        public void setBlock(onMapBlock block) {
            blockList[getIndex(block.blockPos)] = block;
        }

        public boolean isContain(BlockPos pos) {
            return PosTransformer.INSTANCE.getChunkPos(pos) == Chunk.this.ChunkPos;
        }

        public boolean isContain(EntityPos pos) {
            return isContain(PosTransformer.INSTANCE.getBlockPos(pos));
        }

        public int getIndex(BlockPos pos) {
            return (pos.getPos_x() % fof_game.INSTANCE.CHUNK_SIZE) + (pos.getPos_y() % fof_game.INSTANCE.CHUNK_SIZE) * fof_game.INSTANCE.CHUNK_SIZE;
        }
    }


    public Drawer Drawer = new Drawer();

    public class Drawer {
        private Drawer() {

        }

        public Drawable[] getDrawables(int Shift_x, int Shift_y) {
            return getDrawableArray(Shift_x, Shift_y);
        }

        private Drawable[] getDrawableArray(int Shift_x, int Shift_y) {
            Drawable[] returnable = new Drawable[fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE];
            for (int i = 0; i < fof_game.INSTANCE.CHUNK_SIZE * fof_game.INSTANCE.CHUNK_SIZE; i++) {
                returnable[i] = getDrawable(Chunk.this.blockList[i], Shift_x, Shift_y);
            }
            return returnable;
        }

        @Deprecated
        public Drawable getDrawable(onMapBlock block, int x, int y) {
            return block.getDrawable(x, y);
        }
    }
}
