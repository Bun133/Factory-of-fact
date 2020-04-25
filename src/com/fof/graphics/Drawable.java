package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.graphics.ui.DrawableType;
import com.fof.map.pos.onDisplayPos;
import com.fof.map.pos.onDisplayRect;

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
    private boolean requestUpdate = true;

    public Drawable() {
        Type = DRAWABLE_VOID;
    }

    public Drawable(Image image) {
        Type = DRAWABLE_IMAGE;
        pos_X = 0;
        pos_Y = 0;
        Size_x = image.getWidth(null);
        Size_y = image.getHeight(null);
        this.image = image;
    }

    public Drawable(Image image, onDisplayPos pos) {
        Type = DRAWABLE_IMAGE;
        pos_X = pos.getPos_x();
        pos_Y = pos.getPos_y();
        Size_x = image.getWidth(null);
        Size_y = image.getHeight(null);
        this.image = image;
    }

    public Drawable(String text, onDisplayPos pos) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos.getPos_x();
        this.pos_X = pos.getPos_y();
        this.text = text;
        //font=new FontUIResource(Font.SERIF, Font.PLAIN, 12);
        //setSizeFromFont(font,text);
    }

    public Drawable(Font f, String text, onDisplayPos pos) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos.getPos_x();
        this.pos_X = pos.getPos_y();
        this.text = text;
        font = f;
        setSizeFromFont(font, text);
    }

    public Drawable(onDisplayRect rect) {
        Type = DRAWABLE_FILL_RECT;
        this.pos_X = rect.getLeft_up_x();
        this.pos_Y = rect.getLeft_up_y();
        this.Size_x = rect.getSize_x();
        this.Size_y = rect.getSize_y();
        c = new Color(0, 0, 0);
    }

    public Drawable(Color c, onDisplayRect rect) {
        this(rect);
        this.c = c;
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    @Override
    public void draw(Display display) {
        fof_game.INSTANCE.LOGGER.debug("Drawing: " + this.toString());
        switch (Type) {
            case DRAWABLE_IMAGE:
                requestUpdate = false;
                display.drawImage(image, pos_X, pos_Y);
                break;
            case DRAWABLE_LINE:
                //TODO
                requestUpdate = false;
                break;
            case DRAWABLE_FILL_RECT:
                requestUpdate = false;
                display.fillRect(c, pos_X, pos_Y, Size_x, Size_y);
                break;
            case DRAWABLE_STRING:
                requestUpdate = false;
                display.drawString(font, text, pos_X, pos_Y);
                break;
            case DRAWABLE_VOID:
                requestUpdate = false;
                break;
            default:
                fof_game.INSTANCE.LOGGER.printWarn("Unknown Type in Drawable.");
                break;
        }
    }

    @Override
    public boolean requestUpdate() {
        fof_game.INSTANCE.LOGGER.println("Requesting:" + this.requestUpdate + "  :" + this.toString());

        return this.requestUpdate;
    }

    @Override
    public String toString() {
        return c == null ? "Type:" + this.Type.toString() + ",Pos_x:" + this.pos_X + ",Pos_y:" + this.pos_Y + ",Size_x:" + this.Size_x + ",Size_y:" + this.Size_y : "Type:" + this.Type.toString() + ",Pos_x:" + this.pos_X + ",Pos_y:" + this.pos_Y + ",Size_x:" + this.Size_x + ",Size_y:" + this.Size_y + ",Color:" + this.c;
    }

    public Drawable setPos(int pos_X, int pos_Y) {
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        requestUpdate = true;
        return this;
    }

    public Drawable setPos(onDisplayPos pos) {
        this.pos_X = pos.getPos_x();
        this.pos_Y = pos.getPos_y();
        this.Size_x = fof_game.INSTANCE.BLOCK_SIZE;
        this.Size_y = fof_game.INSTANCE.BLOCK_SIZE;
        requestUpdate = true;
        return this;
    }

    private Rectangle2D getSizeFromFont(Font f, String text) {
        return f.getStringBounds(text, new FontRenderContext(null, false, false));
    }

    private void setSizeFromFont(Font f, String text) {
        this.Size_x = (int) getSizeFromFont(f, text).getWidth();
        this.Size_y = (int) getSizeFromFont(f, text).getHeight();
    }

    public Drawable setRequestUpdate(boolean requestUpdate) {
        this.requestUpdate = true;
        return this;
    }
}
