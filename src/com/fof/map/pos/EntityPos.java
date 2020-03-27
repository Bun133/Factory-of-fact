package com.fof.map.pos;

public class EntityPos{
    private double pos_X;
    private double pos_Y;

    public EntityPos(double x, double y) {
        this.pos_X = x;
        this.pos_Y = y;
    }

    public double getPos_X() {
        return this.pos_X;
    }

    public double getPos_Y() {
        return this.pos_Y;
    }
}
