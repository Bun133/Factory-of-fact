package com.fof.graphics.camera;

import com.fof.game.main.fof_game;
import com.fof.graphics.Display;
import com.fof.graphics.IDrawable;
import com.fof.graphics.layersProvider;
import com.fof.graphics.map.MapDrawer;
import com.fof.key.KeyEvent;
import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.PosTransformer;
import com.fof.player.Player;

/**
 * @see com.fof.graphics.map.MapDrawer
 */
public class Camera extends KeyEvent implements IDrawable {
    public int Shift_x;
    public int Shift_y;

    public Player Player;

    public int Draw_Chunks = 10;
    public Chunk[] Drawn_Chunks;

    public MapDrawer MD;
    public Map map;

    @Deprecated
    public Camera(layersProvider layersProvider, Map map, Player player) {
        this.map = map;
        this.MD = new MapDrawer("MapDrawer", layersProvider, map);
        this.Player = player;
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

    private void setDrawn_Chunks() {
        PosTransformer.INSTANCE.getChunkPos(Player.pos);
    }
}
