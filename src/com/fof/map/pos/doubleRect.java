package com.fof.map.pos;

public class doubleRect {
    protected double left_up_x;
    protected double left_up_y;
    protected double right_down_x;
    protected double right_down_y;

    protected double Size_x;
    protected double Size_y;

    protected doubleRect(double left_up_x, double left_up_y, double right_down_x, double right_down_y) {
        this.left_up_x = left_up_x;
        this.left_up_y = left_up_y;
        this.right_down_x = right_down_x;
        this.right_down_y = right_down_y;
        this.Size_x = Math.max(left_up_x, right_down_x) - Math.min(left_up_x, right_down_x);
        this.Size_y = Math.max(left_up_y, right_down_y) - Math.min(left_up_y, right_down_y);
    }

    protected doubleRect(Pos left_up, Pos right_down) {
        this(left_up.pos_x, left_up.pos_y, right_down.pos_x, right_down.pos_y);
    }

    protected doublePos getLeft_up() {
        return new doublePos(left_up_x, left_up_y);
    }

    protected doublePos getRight_down() {
        return new doublePos(right_down_x, right_down_y);
    }

    protected double getLeft_up_x() {
        return this.left_up_x;
    }

    protected double getLeft_up_y() {
        return this.left_up_y;
    }

    protected double getRight_down_x() {
        return this.right_down_x;
    }

    protected double getRight_down_y() {
        return this.right_down_y;
    }

    protected double getSize_x() {
        return this.Size_x;
    }

    protected double getSize_y() {
        return this.Size_y;
    }


}
