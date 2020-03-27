package com.fof.map.pos;

public class ChunkPos extends Pos{
    public ChunkPos(int x,int y){
        this.pos_x=x;
        this.pos_y=y;
    }

    public ChunkPos(Pos pos){
        super(pos);
    }

    public int getChunk_X(){return this.pos_x;}
    public int getChunk_Y(){return this.pos_y;}
}
