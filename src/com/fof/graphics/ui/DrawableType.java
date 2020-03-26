package com.fof.graphics.ui;


public enum DrawableType {
    DRAWABLE_VOID(0),DRAWABLE_IMAGE(1),DRAWABLE_STRING(2),DRAWABLE_FILL_RECT(3),DRAWABLE_LINE(4);

    int meta;
    private DrawableType(int i){
        meta=i;
    }

    public int getMeta(){return meta;}


    @Override
    public String toString() {
        switch (getMeta()){
            case 0:
                return "Drawable_Void";

            case 1:
                return "Drawable_Image";

            case 2:
                return "Drawable_String";

            case 3:
                return "Drawable_Rect";

            case 4:
                return "Drawable_Line";

            default:
                return "Unknown";

        }
    }
}
