package com.fof.map.generator;

import com.fof.map.Chunk;
import com.fof.map.Map;
import com.fof.map.pos.ChunkPos;


public interface IGenerator {
    /**
     * Generate Chunk
     *
     * @param map(Current Map)
     * @param chunk(Current Chunk)
     * @return generatedChunk
     */
    Chunk generateChunk(Map map, Chunk chunk, ChunkPos pos, long hash);


    /**
     * @return generatingLevel
     * <p>
     * <p>
     * If it returns High,It will Generate later than when returns Low.
     * <p>
     * The num can be negative.But,I not recommended.
     */
    int level();
}
