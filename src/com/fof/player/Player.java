package com.fof.player;

import com.fof.graphics.camera.Camera;
import com.fof.graphics.layersProvider;
import com.fof.map.Map;
import com.fof.map.pos.PlayerPos;

public class Player {
    public PlayerPos pos;
    public Map inMap;
    public Camera main_cam = null;

    public Player(Map map) {
        this.pos = new PlayerPos(this, 0.0D, 0.0D);
        this.inMap = map;
    }

    public Camera getCamera(layersProvider provider) {
        if (main_cam == null) main_cam = new Camera(provider, inMap, this);
        return main_cam;
    }

    public void upKey() {

    }

    public void downKey() {

    }

    public void leftKey() {

    }

    public void rightKey() {

    }
}
