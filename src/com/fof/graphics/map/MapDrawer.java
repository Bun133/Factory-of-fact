package com.fof.graphics.map;

import com.fof.graphics.Display;
import com.fof.graphics.IDrawable;
import com.fof.graphics.layer;
import com.fof.graphics.layersProvider;
import com.fof.map.Map;

public class MapDrawer extends layer implements IDrawable {
    public MapDrawer(String name, layersProvider provider, Map MAP) {
        super(name, provider);
        this.map = MAP;
    }

    public Map map;

    @Override
    public void draw(Display display) {
//        map.getDrawable();
        requestUpdate = false;
    }


    private boolean requestUpdate = false;

    @Override
    public boolean requestUpdate() {
        return super.requestUpdate();
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

    public class DrawClass {
        private DrawClass() {
        }

        private int Shift_x = 0, Shift_y = 0;

        private void draw() {

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
    }
}
