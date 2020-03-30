package com.fof.map;

import com.fof.graphics.*;
import com.fof.map.entity.EntityManager;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.map.pos.PlayerPos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;
import com.fof.register.graphics.TextureManager;

import java.util.HashMap;

public class Map extends layer implements IDrawable {


    public Map(String name, layersProvider provider, long hash) {
        this(name, provider);
        generateMap(hash);
    }


    private Map(String name, layersProvider provider) {
        super(name, provider);
    }


    @Override
    public void draw(Display display) {
        // Draw Method When call time to draw.
        draw(getDrawable(), display);
        EM.draw(display);
    }


    private java.util.Map<ChunkPos, Chunk> ChunkMap = new HashMap<ChunkPos, Chunk>();
    private EntityManager EM = new EntityManager(this);
    private TextureManager TM = TextureManager.INSTANCE;
    private int generateChunk = 10;
    private PlayerPos playerPos;


    private java.util.Map<BlockPos, Drawable> getDrawable() {
        java.util.Map<BlockPos, Drawable> list = new HashMap<BlockPos, Drawable>();
        for (ChunkPos chunk : ChunkMap.keySet()) {
            for (onMapBlock pos : ChunkMap.get(chunk).getBlocks()) {
                list.put(pos.blockPos, getDrawable(pos.blockPos));
            }
        }
        return list;
    }

    public Drawable getDrawable(BlockPos pos) {
        return ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos)).getDrawable(new onMapBlock(ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos)).getBlocks()[ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos)).getIndex(pos)].block, ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos)), pos));
    }


    private void draw(java.util.Map<BlockPos, Drawable> map, Display display) {
        for (Drawable drawable : map.values()) {
            drawable.draw(display);
        }
    }

    private void generateMap(long hash) {
        //TODO
    }

    private void fillMapWith(Block block) {

    }

    public void setBlock(onMapBlock block) {
        ChunkMap.get(block.inChunk.getChunkPos()).setBlock(block);
    }

    public void setBlock(Block block, int x, int y) {
        setBlock(new onMapBlock(block, ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(new BlockPos(x, y))), new BlockPos(x, y)));
    }

    public void setBlock(Block block, BlockPos pos) {
        setBlock(block, pos.getX(), pos.getY());
    }
}
