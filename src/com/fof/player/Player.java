package com.fof.player;

import com.fof.graphics.camera.Camera;
import com.fof.map.Map;
import com.fof.map.pos.PlayerPos;

public class Player {
    public PlayerPos pos;
    public Map inMap;
    public Camera main_cam = null;

    public Player(Map map, Camera camera) {
        this.pos = new PlayerPos(this, 0.0D, 0.0D);
        this.inMap = map;
        this.main_cam = camera;
    }

    public Camera getCamera() {
        return main_cam;
    }
}
