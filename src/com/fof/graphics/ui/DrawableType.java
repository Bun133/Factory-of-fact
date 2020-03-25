package com.fof.graphics.ui;


public enum DrawableType {
    DRAWABLE_VOID(0),DRAWABLE_IMAGE(1),DRAWABLE_STRING(2),DRAWABLE_RECT(3),DRAWABLE_LINE(4);

    int meta;
    private DrawableType(int i){
        meta=i;
    }

    public int getMeta(){return meta;}
}
