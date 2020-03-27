package com.fof.map;

import com.fof.game.main.fof_game;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.object.block.Block;

import java.util.HashMap;
import java.util.Map;

public class Chunk {
    private Map<BlockPos, onMapBlock> blocklist=new HashMap<BlockPos, onMapBlock>();
    private ChunkPos chunkPos;

    public Chunk(Block block, ChunkPos pos){
        for(int i=0;i< fof_game.INSTANCE.CHUNK_SIZE*fof_game.INSTANCE.CHUNK_SIZE;i++){

        }
    }
}
