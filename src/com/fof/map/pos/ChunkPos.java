package com.fof.map.pos;

public class ChunkPos extends Pos{
    public ChunkPos(int x,int y){
        this.pos_x = x;
        this.pos_y = y;
    }

    public ChunkPos(Pos pos) {
        super(pos);
    }

    public int getChunk_X() {
        return this.pos_x;
    }

    public int getChunk_Y() {
        return this.pos_y;
    }

    public ChunkPos UPChunkPos() {
        return new ChunkPos(this.getChunk_X(), this.getChunk_Y() - 1);
    }

    public ChunkPos DOWNChunkPos() {
        return new ChunkPos(this.getChunk_X(), this.getChunk_Y() + 1);
    }

    public ChunkPos LEFTChunkPos() {
        return new ChunkPos(this.getChunk_X() - 1, this.getChunk_Y());
    }

    public ChunkPos RIGHTChunkPos() {
        return new ChunkPos(this.getChunk_X() + 1, this.getChunk_Y());
    }
}
