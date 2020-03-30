package com.fof.map.pos;

public class Rect {
    protected int left_up_x;
    protected int left_up_y;
    protected int right_down_x;
    protected int right_down_y;

    protected int Size_x;
    protected int Size_y;

    protected Rect(int left_up_x, int left_up_y, int right_down_x, int right_down_y) {
        this.left_up_x = Math.min(left_up_x, right_down_x);
        this.left_up_y = Math.max(left_up_y, right_down_y);
        this.right_down_x = Math.max(left_up_x, right_down_x);
        this.right_down_y = Math.min(left_up_y, right_down_y);
        this.Size_x = Math.max(left_up_x, right_down_x) - Math.min(left_up_x, right_down_x);
        this.Size_y = Math.max(left_up_y, right_down_y) - Math.min(left_up_y, right_down_y);
    }

    protected Rect(Pos left_up, Pos right_down) {
        this(left_up.pos_x, left_up.pos_y, right_down.pos_x, right_down.pos_y);
    }

    protected onDisplayPos getLeft_up() {
        return new onDisplayPos(left_up_x, left_up_y);
    }

    protected onDisplayPos getRight_down() {
        return new onDisplayPos(right_down_x, right_down_y);
    }

    protected int getLeft_up_x() {
        return this.left_up_x;
    }

    protected int getLeft_up_y() {
        return this.left_up_y;
    }

    protected int getRight_down_x() {
        return this.right_down_x;
    }

    protected int getRight_down_y() {
        return this.right_down_y;
    }

    protected int getSize_x() {
        return this.Size_x;
    }

    protected int getSize_y() {
        return this.Size_y;
    }
}
