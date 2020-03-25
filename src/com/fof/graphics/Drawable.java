package com.fof.graphics;

import com.fof.graphics.ui.DrawableType;

import java.awt.*;

import static com.fof.graphics.ui.DrawableType.DRAWABLE_IMAGE;

public class Drawable {
    DrawableType Type;
    int pos_X,pos_Y;
    int Size_x,Size_y;
    Image image;
    public Drawable(Image image){
        Type= DRAWABLE_IMAGE;
        pos_X=0;
        pos_Y=0;
        Size_x=100;
        Size_y=100;
    }

    public void draw(Graphics g){
        switch (Type){
            case DRAWABLE_IMAGE:
                g.drawImage(image,pos_X,pos_Y,null);
                break;
            case DRAWABLE_LINE:
                break;
            case DRAWABLE_RECT:
                break;
            case DRAWABLE_VOID:
                break;
            case DRAWABLE_STRING:
                break;
        }
    }
}
