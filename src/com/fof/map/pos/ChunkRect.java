package com.fof.map.pos;

import com.fof.map.Chunk;
import com.fof.map.Map;

import java.util.ArrayList;
import java.util.List;

public class ChunkRect extends Rect {
    private ChunkRect(int left_up_x, int left_up_y, int right_down_x, int right_down_y) {
        super(left_up_x, left_up_y, right_down_x, right_down_y);
    }

    public ChunkRect(ChunkPos left_up, ChunkPos right_down) {
        super(left_up, right_down);
    }

    public List<Chunk> getChunk(Map map) {
        List<Chunk> ChunkList = new ArrayList<>();
        for (int x = this.left_up_x; x < this.right_down_x; x++) {
            for (int y = this.right_down_y; y < this.left_up_y; y++) {
                ChunkList.add(map.Editor.getChunk(x, y));
            }
        }
        return ChunkList;
    }
}
