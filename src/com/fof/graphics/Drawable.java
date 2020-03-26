package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.graphics.ui.DrawableType;

import java.awt.*;

import static com.fof.graphics.ui.DrawableType.DRAWABLE_IMAGE;
import static com.fof.graphics.ui.DrawableType.DRAWABLE_STRING;

public class Drawable implements IDrawable{
    DrawableType Type;
    int pos_X,pos_Y;
    int Size_x,Size_y;
    //DRAWABLE_IMAGE
    Image image;

    //DRAWABLE_STRING
    Font font=null;
    String text;
    public Drawable(Image image){
        Type= DRAWABLE_IMAGE;
        pos_X=0;
        pos_Y=0;
        Size_x=image.getWidth(null);
        Size_y=image.getHeight(null);
    }

    public Drawable(String text){
        Type=DRAWABLE_STRING;
        pos_X=0;
        pos_Y=0;
        this.text=text;
        //font=new FontUIResource(Font.SERIF, Font.PLAIN, 12);
    }

    public Drawable(Font f,String text){
        Type=DRAWABLE_STRING;
        pos_X=0;
        pos_Y=0;
        this.text=text;
        font=f;
    }

    @Override
    public void draw(Display display){
        fof_game.INSTANCE.LOGGER.println(this.toString());
        switch (Type){
            case DRAWABLE_IMAGE:
                display.drawImage(image,pos_X,pos_Y);
                break;
            case DRAWABLE_LINE:
                break;
            case DRAWABLE_RECT:
                break;
            case DRAWABLE_VOID:
                break;
            case DRAWABLE_STRING:
                if(font==null){
                    display.drawString(text,pos_X,pos_Y);
                }else{
                    display.drawString(font,text,pos_X,pos_Y);
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Type:"+this.Type.toString()+",Pos_x:"+this.pos_X+",Pos_y:"+this.pos_Y+",Size_x:"+this.Size_x+",Size_y:"+this.Size_y;
    }
}
