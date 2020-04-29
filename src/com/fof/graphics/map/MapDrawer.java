package com.fof.graphics.map;

import com.fof.game.main.fof_game;
import com.fof.graphics.*;
import com.fof.graphics.camera.Camera;
import com.fof.map.Map;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.Rect;
import com.fof.map.pos.onDisplayPos;
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
        fof_game.INSTANCE.LOGGER.debug("Draw Called...");
        this.draw(display, this.camera.getDrawRect());
    }

    private void draw(Display display, onDisplayRect rect) {
        this.drawer.draw(display, drawer.getMapRect(rect), rect);
    }


    private boolean requestUpdate = true;

    @Override
    public boolean requestUpdate() {
        return requestUpdate;
    }

    /**
     * @apiNote KeyInput感度(だと思う)
     */
    public final int Key_Pos = 8;//8*8=64=fof_game.instance.Block_size

    public void upKey() {
        fof_game.INSTANCE.LOGGER.debug("UP Key Pressed.");
        requestUpdate = true;
        drawer.inqShift_y(Key_Pos);
        fof_game.INSTANCE.LOGGER.println("Shift_x:" + this.drawer.Shift_x + " Shift_Y:" + this.drawer.Shift_y);
    }

    public void downKey() {
        fof_game.INSTANCE.LOGGER.debug("DOWN Key Pressed.");
        requestUpdate = true;
        drawer.deqShift_y(Key_Pos);
        fof_game.INSTANCE.LOGGER.println("Shift_x:" + this.drawer.Shift_x + " Shift_Y:" + this.drawer.Shift_y);
    }

    public void leftKey() {
        fof_game.INSTANCE.LOGGER.debug("LEFT Key Pressed.");
        requestUpdate = true;
        drawer.deqShift_x(Key_Pos);
        fof_game.INSTANCE.LOGGER.println("Shift_x:" + this.drawer.Shift_x + " Shift_Y:" + this.drawer.Shift_y);
    }

    public void rightKey() {
        fof_game.INSTANCE.LOGGER.debug("RIGHT Key Pressed.");
        requestUpdate = true;
        drawer.inqShift_x(Key_Pos);
        fof_game.INSTANCE.LOGGER.println("Shift_x:" + this.drawer.Shift_x + " Shift_Y:" + this.drawer.Shift_y);
    }

    private DrawClass drawer = new DrawClass();

    @SuppressWarnings("SameParameterValue")
    public class DrawClass {
        private DrawClass() {
        }

        public int Shift_x, Shift_y;

        private void draw(Display display, Rect mapRect, onDisplayRect rect) {
            fof_game.INSTANCE.LOGGER.debug("Map Drawing....");
            if (mapRect.equalSize(rect)) {
                //拡大縮小必要なし
                List<onMapBlock> drawList = map.Editor.getBlockinAABB(mapRect);
                List<Drawable> drawables = new ArrayList<>();
                for (onMapBlock block : drawList) {
                    drawables.add(block.block.getDrawable().setPos(MapDrawer.this.util.convertPos(block)));
                }

                //MapDrawerが再描画要求時(全て強制的に更新)
                if (MapDrawer.this.requestUpdate()) {
                    fof_game.INSTANCE.LOGGER.debug("MapDrawer Requested Draw Update.");
                    for (Drawable drawable : drawables) {
                        drawable.draw(display);
                    }
                    return;
                }

                for (Drawable drawable : drawables) {
                    if (drawable.requestUpdate()) {
                        fof_game.INSTANCE.LOGGER.debug("Drawable: " + drawable.toString() + " requested Update.");
                        drawable.draw(display);
                    }
                }
            } else {
                //拡大縮小が必要
                //TODO
            }


            //正常終了時

            MapDrawer.this.requestUpdate = false;
        }

        private void setShift_x(int shift_x) {
            this.Shift_x = shift_x;
        }

        private void setShift_y(int shift_y) {
            this.Shift_y = shift_y;
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


    public Util util = new Util();

    public class Util {

        public Util() {
        }

        public onDisplayPos convertPos(onMapBlock Block) {
            return convertPos(Block.blockPos);
        }

        public onDisplayPos convertPos(BlockPos pos) {
            onDisplayPos Onpos = new onDisplayPos(pos.getPixelPos_x() + MapDrawer.this.drawer.Shift_x, pos.getPixelPos_y() + MapDrawer.this.drawer.Shift_y);
            fof_game.INSTANCE.LOGGER.println("ConvertPos:" + "Shift_X:" + MapDrawer.this.drawer.Shift_x);
            fof_game.INSTANCE.LOGGER.println("ConvertPos:" + "Shift_Y:" + MapDrawer.this.drawer.Shift_y);
            return Onpos;
        }
    }
}
