package com.fof.map.pos;

public class Pos {
    protected int pos_x;
    protected int pos_y;
    protected Pos(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    protected Pos(Pos pos){
        this(pos.pos_x,pos.pos_y);
    }

    protected Pos(){}

    public int getPos_x(){return pos_x;}
    public int getPos_y(){return pos_y;}
}
