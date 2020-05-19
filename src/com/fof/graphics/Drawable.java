package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.graphics.ui.DrawableType;
import com.fof.map.pos.onDisplayPos;
import com.fof.map.pos.onDisplayRect;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    //DRAWABLE_MULTI
    List<Drawable> drawableList = new ArrayList<>();
    //DRAWABLE_RUNNABLE
    DrawableRunnable Runnable;

    private boolean requestUpdate = true;

    //DRAWABLE_VOID
    public Drawable() {
        Type = DRAWABLE_VOID;
    }

    //DRAWABLE_IMAGE
    public Drawable(Image image) {
        Type = DRAWABLE_IMAGE;
        pos_X = 0;
        pos_Y = 0;
        Size_x = image.getWidth(null);
        Size_y = image.getHeight(null);
        this.image = image;
    }

    //DRAWABLE_IMAGE
    public Drawable(Image image, onDisplayPos pos) {
        Type = DRAWABLE_IMAGE;
        pos_X = pos.getPos_x();
        pos_Y = pos.getPos_y();
        Size_x = image.getWidth(null);
        Size_y = image.getHeight(null);
        this.image = image;
    }

    //DRAWABLE_STRING
    public Drawable(String text, onDisplayPos pos) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos.getPos_x();
        this.pos_X = pos.getPos_y();
        this.text = text;
        //font=new FontUIResource(Font.SERIF, Font.PLAIN, 12);
        //setSizeFromFont(font,text);
    }

    //DRAWABLE_STRING
    public Drawable(Font f, String text, onDisplayPos pos) {
        Type = DRAWABLE_STRING;
        this.pos_Y = pos.getPos_x();
        this.pos_X = pos.getPos_y();
        this.text = text;
        font = f;
        setSizeFromFont(font, text);
    }

    //DRAWABLE_FILL_RECT
    public Drawable(onDisplayRect rect) {
        Type = DRAWABLE_FILL_RECT;
        this.pos_X = rect.getLeft_up_x();
        this.pos_Y = rect.getLeft_up_y();
        this.Size_x = rect.getSize_x();
        this.Size_y = rect.getSize_y();
        c = new Color(0, 0, 0);
    }

    //DRAWABLE_FILL_RECT
    public Drawable(Color c, onDisplayRect rect) {
        this(rect);
        this.c = c;
    }

    //DRAWABLE_MULTI
    @SuppressWarnings("SpellCheckingInspection")
    public Drawable(Drawable... drawable) {
        this.Type = DRAWABLE_MULTI;
        this.drawableList.addAll(Arrays.asList(drawable));
    }
    //DRAWABLE_RUNNABLE

    /**
     * @param runnable
     * @apiNote NotRecommended
     */
    public Drawable(DrawableRunnable runnable) {
        this.Type = DRAWABLE_RUNNABLE;
        this.Runnable = runnable;
    }


    @SuppressWarnings("DuplicateBranchesInSwitch")
    @Override
    public void draw(Display display) {
        fof_game.INSTANCE.LOGGER.debug("Drawing: " + this.toString());
        switch (Type) {
            case DRAWABLE_IMAGE:
                requestUpdate = false;
                display.drawImage(image, pos_X, pos_Y);
                if (fof_game.debug_config.isDebug) {
                    drawDebugRect(display);
                }
                break;
            case DRAWABLE_LINE:
                //TODO
                requestUpdate = false;
                break;
            case DRAWABLE_FILL_RECT:
                requestUpdate = false;
                display.fillRect(c, pos_X, pos_Y, Size_x, Size_y);
                if (fof_game.debug_config.isDebug) {
                    drawDebugRect(display);
                }
                break;
            case DRAWABLE_STRING:
                requestUpdate = false;
                display.drawString(font, text, pos_X, pos_Y);
                if (fof_game.debug_config.isDebug) {
                    drawDebugRect(display);
                }
                break;
            case DRAWABLE_VOID:
                requestUpdate = false;
                break;
            case DRAWABLE_MULTI:
                requestUpdate = false;
                for (Drawable drawable : this.drawableList) {
                    drawable.draw(display);
                }
                break;
            case DRAWABLE_RUNNABLE:
                this.Runnable.Draw(display);
            default:
                fof_game.INSTANCE.LOGGER.printWarn("Unknown Type in Drawable.");
                break;
        }
    }

    @Override
    public boolean requestUpdate() {
        switch (this.Type) {
            case DRAWABLE_MULTI:
                for (Drawable drawable : this.drawableList) {
                    if (drawable.requestUpdate) {
                        return true;
                    }
                }
            case DRAWABLE_RUNNABLE:
                return this.Runnable.requestUpdate();
        }

        fof_game.INSTANCE.LOGGER.debug("Requesting:" + this.requestUpdate + "  :" + this.toString());

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
        this.requestUpdate = requestUpdate;
        return this;
    }

    public Drawable setColor(Color c) {
        this.c = c;
        return this;
    }


    private void setSize() {
        switch (this.Type) {
            case DRAWABLE_IMAGE:
                this.Size_x = this.image.getWidth(null);
                this.Size_y = this.image.getHeight(null);
                break;
            case DRAWABLE_STRING:
                setSizeFromFont(this.font, this.text);
                break;
            case DRAWABLE_FILL_RECT:
                /**
                 * Nothing To Do......(Is it right?).......
                 */
                break;
            case DRAWABLE_VOID:
                this.Size_x = 0;
                this.Size_y = 0;
                break;
            case DRAWABLE_LINE:
                //TODO
                break;
            default:
                fof_game.INSTANCE.LOGGER.printWarn("UnKnown Drawable Type....");
                break;
        }
    }

    private void drawDebugRect(Display display) {
        display.drawRect(new Color(255, 0, 215), this.pos_X, this.pos_Y, this.Size_x, this.Size_y);
    }
}
