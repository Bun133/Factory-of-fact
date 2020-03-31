package com.fof.map;

import com.fof.graphics.Display;
import com.fof.graphics.Drawable;
import com.fof.graphics.IDrawable;
import com.fof.map.entity.EntityManager;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.ChunkPos;
import com.fof.map.pos.PlayerPos;
import com.fof.map.pos.PosTransformer;
import com.fof.object.block.Block;
import com.fof.register.graphics.TextureManager;

import java.util.HashMap;

public class Map implements IDrawable {


    public Map(String name, long hash) {
        this(name);
        generateMap(hash);
    }


    private Map(String name) {
        this.MapName = name;
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
    private int shift_x = 0;
    private int shift_y = 0;
    private String MapName = "";

    private java.util.Map<BlockPos, Drawable> getDrawable() {
        java.util.Map<BlockPos, Drawable> list = new HashMap<BlockPos, Drawable>();
        for (ChunkPos chunkPos : ChunkMap.keySet()) {
            for (onMapBlock pos : ChunkMap.get(chunkPos).getBlocks()) {
                list.put(pos.blockPos, getDrawable(pos.blockPos));
            }
        }
        return list;
    }

    public Drawable getDrawable(BlockPos pos) {
        Chunk ParentChunk = ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos));
        return ParentChunk.getDrawable(new onMapBlock(ParentChunk.getBlocks()[ParentChunk.getIndex(pos)].block, ParentChunk, pos), shift_x, shift_y);
    }


    private void draw(java.util.Map<BlockPos, Drawable> map, Display display) {
        for (BlockPos pos : map.keySet()) {
            Drawable drawable = map.get(pos);
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

    public String getMapName() {
        return this.MapName;
    }
}
