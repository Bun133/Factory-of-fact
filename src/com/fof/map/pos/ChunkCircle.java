package com.fof.map.pos;

import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.util.Helper.MapHelper;

public class ChunkCircle {
    public Chunk[] Chunks;

    /**
     * @param Center
     * @param range
     * @param map
     * @return
     * @apiNote {@code Center}を中心に、{@code range}分の円状の{@link com.fof.map.Chunk}を返します。{@code range}は中心のChunkを0,半径1増えるごとに1上がります。
     */
    public ChunkCircle(Map map, ChunkPos Center, int range) {
        Chunks = new Chunk[MapHelper.getCircleChunksLong(range)];
        setChunks(map, Center, range);
    }


    private void setChunks(Map map, ChunkPos Center, int range) {

    }


}
