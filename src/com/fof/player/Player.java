package com.fof.player;

import com.fof.map.Map;
import com.fof.map.pos.PlayerPos;

public class Player {
    public PlayerPos pos;
    public Map inMap;

    public Player(Map map) {
        this.pos = new PlayerPos(this, 0.0D, 0.0D);
        this.inMap = map;
    }
}
