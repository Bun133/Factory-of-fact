package com.fof.map.pos;

public class onDisplayPos extends Pos {
    public onDisplayPos(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPos_x() {
        return super.getPos_x();
    }

    @Override
    public int getPos_y() {
        return super.getPos_y();
    }

    @Override
    public String toString() {
        return "OnDisplayPos: X:" + this.pos_x + " Y:" + this.pos_y;
    }
}
