package com.fof.graphics.camera;

import com.fof.game.main.fof_game;
import com.fof.graphics.Display;
import com.fof.graphics.IDrawable;
import com.fof.graphics.layersProvider;
import com.fof.graphics.map.MapDrawer;
import com.fof.key.KeyEvent;
import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.onDisplayPos;
import com.fof.map.pos.onDisplayRect;
import com.fof.player.Player;

/**
 * @see com.fof.graphics.map.MapDrawer
 */
public class Camera extends KeyEvent implements IDrawable {
    public int Center_x;
    public int Center_y;

    public Player Player;

    public int Draw_Chunks = 10;
    public Chunk[] Drawn_Chunks;

    public MapDrawer MD;
    public Map map;
    public int cansee = 3;

    private Display display;

    public Camera(layersProvider layersProvider, Map map, Player player, Display display) {
        this.map = map;
        this.MD = new MapDrawer("MapDrawer", layersProvider, map, this);
        this.Player = player;
        this.display = display;
        this.Center_x = display.getWidth() / 2;
        this.Center_y = display.getHeight() / 2;
        fof_game.INSTANCE.KM.addclass(this);
    }

    @Override
    public void run(java.awt.event.KeyEvent event) {
        switch (event.getKeyCode()) {
            case java.awt.event.KeyEvent.VK_UP:
                this.MD.upKey();
                break;
            case java.awt.event.KeyEvent.VK_DOWN:
                this.MD.downKey();
                break;
            case java.awt.event.KeyEvent.VK_LEFT:
                this.MD.leftKey();
                break;
            case java.awt.event.KeyEvent.VK_RIGHT:
                this.MD.rightKey();
                break;
        }
    }

    @Override
    public void draw(Display display) {
        requestUpdate = false;
        MD.draw(display);
    }


    private boolean requestUpdate = true;

    @Override
    public boolean requestUpdate() {
        //TODO
        if (MD.requestUpdate()) {
            return true;
        }
        return requestUpdate;
    }

    public MapDrawer getMD() {
        return this.MD;
    }

//    private void setDrawn_Chunks() {
//        PosTransformer.INSTANCE.getChunkPos(Player.pos);
//    }

    public double FOV = 1;
    public double Zoom = 1;

    /**
     * 画面サイズと相対的に計算し、ズームなどの情報も含めます
     */

    public onDisplayRect getDrawRect() {
        return new onDisplayRect(left_up(), right_down());
    }


    public onDisplayPos left_up() {
        return new onDisplayPos((int) ((Center_x - FOV * display.getWidth() / 2) * Zoom), (int) ((Center_y - FOV * display.getHeight() / 2) * Zoom));
    }

    public onDisplayPos right_down() {
        return new onDisplayPos((int) ((Center_x + FOV * display.getWidth() / 2) * Zoom), (int) ((Center_y + FOV * display.getHeight() / 2) * Zoom));
    }

}
