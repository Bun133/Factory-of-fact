package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.graphics.ui.DrawableType;
import com.fof.map.pos.BlockPos;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import static com.fof.graphics.ui.DrawableType.*;

public class Drawable implements IDrawable {
    DrawableType Type;
    int pos_X, pos_Y;
    int Size_x, Size_y;
    //DRAWABLE_IMAGE
    Image image;

    //DRAWABLE_STRING
    Font font = null;
    String text;

    //DRAWABLE_RECT
    Color c;

    public Drawable(Image image) {
        Type = DRAWABLE_IMAGE;
        pos_X = 0;
        pos_Y = 0;
        Size_x = image.getWidth(null);
        Size_y = image.getHeight(null);
        this.image = image;
    }

    public Drawable(String text, int pos_X, int pos_Y) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos_Y;
        this.pos_X = pos_X;
        this.text = text;
        //font=new FontUIResource(Font.SERIF, Font.PLAIN, 12);
        //setSizeFromFont(font,text);
    }

    public Drawable(Font f, String text, int pos_X, int pos_Y) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos_Y;
        this.pos_X = pos_X;
        this.text = text;
        font = f;
        setSizeFromFont(font, text);
    }

    public Drawable(int pos_x, int pos_y, int width, int height) {
        Type = DRAWABLE_FILL_RECT;
        this.pos_X = pos_x;
        this.pos_Y = pos_y;
        this.Size_x = width;
        this.Size_y = height;
        c = new Color(0, 0, 0);
    }

    public Drawable(Color c, int pos_x, int pos_y, int width, int height) {
        Type = DRAWABLE_FILL_RECT;
        this.pos_X = pos_x;
        this.pos_Y = pos_y;
        this.Size_x = width;
        this.Size_y = height;
        this.c = c;
    }

    @Override
    public void draw(Display display) {
        fof_game.INSTANCE.LOGGER.debug(this.toString());
        switch (Type) {
            case DRAWABLE_IMAGE:
                display.drawImage(image, pos_X, pos_Y);
                break;
            case DRAWABLE_LINE:
                break;
            case DRAWABLE_FILL_RECT:
                display.fillRect(c, pos_X, pos_Y, Size_x, Size_y);
                break;
            case DRAWABLE_STRING:
                display.drawString(font, text, pos_X, pos_Y);
                break;
            case DRAWABLE_VOID:
                break;
        }
    }

    @Override
    public String toString() {
        return "Type:" + this.Type.toString() + ",Pos_x:" + this.pos_X + ",Pos_y:" + this.pos_Y + ",Size_x:" + this.Size_x + ",Size_y:" + this.Size_y;
    }

    public Drawable setPos(int pos_X, int pos_Y) {
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        return this;
    }

    public Drawable setPos(BlockPos pos) {
        this.pos_X = pos.getX() * fof_game.INSTANCE.BLOCK_SIZE;
        this.pos_Y = pos.getY() * fof_game.INSTANCE.BLOCK_SIZE;
        return this;
    }

    private Rectangle2D getSizeFromFont(Font f, String text) {
        return f.getStringBounds(text, new FontRenderContext(null, false, false));
    }

    private void setSizeFromFont(Font f, String text) {
        this.Size_x = (int) getSizeFromFont(f, text).getWidth();
        this.Size_y = (int) getSizeFromFont(f, text).getHeight();
    }
}
