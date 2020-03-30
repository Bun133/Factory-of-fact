package com.fof.map.pos;

public class onDisplayRect extends Rect {
    public onDisplayRect(int left_up_x, int left_up_y, int right_down_x, int right_down_y) {
        super(left_up_x, left_up_y, right_down_x, right_down_y);
    }

    public onDisplayRect(onDisplayPos pos, onDisplayPos pos1) {
        this(pos.pos_x, pos.pos_y, pos1.pos_x, pos1.pos_y);
    }

    @Override
    public onDisplayPos getLeft_up() {
        return super.getLeft_up();
    }

    @Override
    public onDisplayPos getRight_down() {
        return super.getRight_down();
    }

    @Override
    public int getLeft_up_x() {
        return super.getLeft_up_x();
    }

    @Override
    public int getLeft_up_y() {
        return super.getLeft_up_y();
    }

    @Override
    public int getRight_down_x() {
        return super.getRight_down_x();
    }

    @Override
    public int getRight_down_y() {
        return super.getRight_down_y();
    }

    @Override
    public int getSize_x() {
        return super.getSize_x();
    }

    @Override
    public int getSize_y() {
        return super.getSize_y();
    }
}
