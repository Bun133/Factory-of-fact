package com.fof.map.pos;

import com.fof.player.Player;

public class PlayerPos extends EntityPos {
    private Player player;

    public PlayerPos(Player p, double x, double y) {
        super(x, y);
        this.player = p;
    }
}
