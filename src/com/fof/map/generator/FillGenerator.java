package com.fof.map.generator;

import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.ChunkPos;
import com.fof.object.block.Block;


/**
 * Test For generator
 *
 * @see com.fof.map.Map.generator
 */
public class FillGenerator implements IGenerator {
    private Block FillWith;

    public FillGenerator(Block block) {
        this.FillWith = block;
    }

    @Override
    public Chunk generateChunk(Map map, Chunk chunk, ChunkPos pos, long hash) {
        chunk = new Chunk(map, FillWith, pos);
        return chunk;
    }

    @Override
    public int level() {
        return 0;
    }
}
