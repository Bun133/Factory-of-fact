package com.fof.map;

import com.fof.graphics.*;
import com.fof.map.entity.EntityManager;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.BlockPos;
import com.fof.map.pos.PlayerPos;
import com.fof.object.block.Block;
import com.fof.register.graphics.TextureManager;

import java.util.HashMap;

public class Map extends layer implements IDrawable {
    private java.util.Map<BlockPos, onMapBlock> BlockMap = new HashMap<BlockPos, onMapBlock>();
    private EntityManager EM = new EntityManager(this);
    private TextureManager TM = TextureManager.INSTANCE;
    private int generateChunk = 10;
    private PlayerPos playerPos;

    public Map(String name, long hash) {
        this(name);
        generateMap(hash);
    }


    private Map(String name) {
        super(name, layersProvider.INSTANCE);
    }


    @Override
    public void draw(Display display) {
        // Draw Method When call time to draw.
        draw(getDrawable(), display);
        EM.draw(display);
    }

    private java.util.Map<BlockPos, Drawable> getDrawable() {
        java.util.Map<BlockPos, Drawable> list = new HashMap<BlockPos, Drawable>();
        for (BlockPos pos : BlockMap.keySet()) {
            list.put(pos, getDrawable(pos));
        }
        return list;
    }

    public Drawable getDrawable(BlockPos pos) {
        return BlockMap.get(pos).getDrawable();
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
        BlockMap.put(block.blockPos, block);
    }

    public void setBlock(Block block, int x, int y) {
        setBlock(new onMapBlock(block, x, y));
    }

    public void setBlock(Block block, BlockPos pos) {
        setBlock(new onMapBlock(block, pos));
    }
}
