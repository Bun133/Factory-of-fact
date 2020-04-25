package com.fof.graphics.map;

import com.fof.graphics.*;
import com.fof.graphics.camera.Camera;
import com.fof.map.Map;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.Rect;
import com.fof.map.pos.onDisplayRect;

import java.util.ArrayList;
import java.util.List;

public class MapDrawer extends layer implements IDrawable {
    public MapDrawer(String name, layersProvider provider, Map MAP, Camera camera) {
        super(name, provider);
        this.map = MAP;
        this.camera = camera;
    }

    private Map map;
    private Camera camera;

    @Override
    public void draw(Display display) {
        this.draw(display, this.camera.getDrawRect());
    }

    private void draw(Display display, onDisplayRect rect) {
        this.drawer.draw(display, drawer.getMapRect(rect), rect);
    }


    private boolean requestUpdate = false;

    @Override
    public boolean requestUpdate() {
        return requestUpdate;
    }

    /**
     * @apiNote KeyInput感度(だと思う)
     */
    public final int Key_Pos = 100;

    public void upKey() {
        requestUpdate = true;
        drawer.inqShift_y(Key_Pos);
    }

    public void downKey() {
        requestUpdate = true;
        drawer.deqShift_y(Key_Pos);
    }

    public void leftKey() {
        requestUpdate = true;
        drawer.deqShift_x(Key_Pos);
    }

    public void rightKey() {
        requestUpdate = true;
        drawer.inqShift_x(Key_Pos);
    }

    private DrawClass drawer = new DrawClass();

    @SuppressWarnings("SameParameterValue")
    public class DrawClass {
        private DrawClass() {
        }

        private int Shift_x = 0, Shift_y = 0;

        private void draw(Display display, Rect mapRect, onDisplayRect rect) {
            if (mapRect.equalSize(rect)) {
                //拡大縮小必要なし
                List<onMapBlock> drawList = map.Editor.getBlockinAABB(mapRect);
                List<Drawable> drawables = new ArrayList<>();
                for (onMapBlock block : drawList) {
                    drawables.add(block.getDrawable(Shift_x, Shift_y));
                }


                if (MapDrawer.this.requestUpdate()) {
                    for (Drawable drawable : drawables) {
                        drawable.draw(display);
                    }
                    return;
                }

                for (Drawable drawable : drawables) {
                    if (drawable.requestUpdate()) {
                        drawable.draw(display);
                    }
                }
            } else {
                //拡大縮小が必要
                //TODO
            }
        }

        private void setShift_x(int shift_x) {
            this.Shift_x = shift_x;
        }

        private void setShift_y(int shift_y) {
            this.Shift_x = shift_y;
        }

        private void deqShift_x(int deq_int) {
            this.Shift_x -= deq_int;
        }

        private void deqShift_y(int deq_int) {
            this.Shift_y -= deq_int;
        }

        private void inqShift_x(int inq_int) {
            this.Shift_x += inq_int;
        }

        private void inqShift_y(int inq_int) {
            this.Shift_y += inq_int;
        }

        private Rect getMapRect(onDisplayRect rect) {
            return new Rect(rect.getLeft_up_x() + Shift_x, rect.getLeft_up_y() + Shift_y, rect.getRight_down_x() + Shift_x, rect.getRight_down_y() + Shift_y);
        }
    }
}
