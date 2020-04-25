package com.fof.map;

import com.fof.graphics.Drawable;
import com.fof.map.entity.EntityManager;
import com.fof.map.object.onMapBlock;
import com.fof.map.pos.*;
import com.fof.object.block.Block;
import com.fof.register.graphics.TextureManager;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map {


    public Map(String name, long hash) {
        this(name);
        generator.INSTANCE.generateMap(hash);
    }


    private Map(String name) {
        this.MapName = name;
    }


//    public void draw(Display display) {
//        Draw Method When call time to draw.
//        draw(getDrawable(), display);
//        EM.draw(display);
//    }


    java.util.Map<ChunkPos, Chunk> ChunkMap = new HashMap<ChunkPos, Chunk>();
    EntityManager EM = new EntityManager(this);
    TextureManager TM = TextureManager.INSTANCE;
    final int GENERATE_CHUNK = 10;
    List<PlayerPos> Players = new ArrayList<PlayerPos>();
    //private int shift_x = 0;
    //private int shift_y = 0;
    String MapName = "";

//    private java.util.Map<BlockPos, Drawable> getDrawable() {
//        java.util.Map<BlockPos, Drawable> list = new HashMap<BlockPos, Drawable>();
//        for (ChunkPos chunkPos : ChunkMap.keySet()) {
//            for (onMapBlock pos : ChunkMap.get(chunkPos).getBlocks()) {
//                list.put(pos.blockPos, getDrawable(pos.blockPos));
//            }
//        }
//        return list;
//    }

    public Drawable getDrawable(BlockPos pos, int shift_x, int shift_y) {
        Chunk ParentChunk = ChunkMap.get(PosTransformer.INSTANCE.getChunkPos(pos));
        return ParentChunk.getDrawable(pos, shift_x, shift_y);
    }

//    public void setShift_x(int x) {
//        shift_x = x;
//    }
//
//    public void setShift_y(int y) {
//        shift_y = y;
//    }


    //    private void draw(java.util.Map<BlockPos, Drawable> map, Display display) {
//        for (BlockPos pos : map.keySet()) {
//            Drawable drawable = map.get(pos);
//            drawable.draw(display);
//        }
//    }

    /**
     * @author Bun133
     * @apiNote It's MapGenerator. It's going on.
     */
    private static class generator {
        public static generator INSTANCE = new generator();

        private generator() {
        }

        public void generateMap(long hash) {
            //TODO
        }

        public void generateMap(int Chunk_Size) {

        }

        private boolean isFilled = false;
        private Block FilledBlock = null;

        private void fillMapWith(Block block) {
            isFilled = true;
            this.FilledBlock = block;
        }
    }


    public String getMapName() {
        return this.MapName;
    }

    public boolean isEqual(Map map) {
        return this == map;
    }


    public MapEditor Editor = new MapEditor(this);


    /**
     * @author Bun133
     * @apiNote It's MapEditor.
     * @see com.fof.map.Map
     */
    public class MapEditor {
        private Map map;

        public MapEditor(Map map) {
            this.map = map;
        }

        public Map getMap() {
            return map;
        }

        @Nullable
        public Chunk getChunk(ChunkPos pos) {
            return map.ChunkMap.getOrDefault(pos, null);
        }

        @Nullable
        public Chunk getChunk(int x, int y) {
            return getChunk(new ChunkPos(x, y));
        }

        public List<Chunk> getAllChunk() {
            return (List<Chunk>) map.ChunkMap.values();
        }

        public List<onMapBlock> getAllBlock() {
            List<onMapBlock> returnable = new ArrayList<>();
            for (Chunk chunk : getAllChunk()) {
                returnable.addAll(Arrays.asList(chunk.getBlocks()));
            }
            return returnable;
        }

        @Nullable
        public ChunkPos getChunkPos(Chunk chunk) {
            if (!map.ChunkMap.containsValue(chunk)) return null;
            for (java.util.Map.Entry<ChunkPos, Chunk> entry : map.ChunkMap.entrySet()) {
                if (entry.getValue() == chunk) {
                    return entry.getKey();
                }
            }
            return null;
        }

        public boolean isContain(ChunkPos pos) {
            return map.ChunkMap.containsKey(pos);
        }

        public ChunkPos getChunkPos(BlockPos pos) {
            return PosTransformer.INSTANCE.getChunkPos(pos);
        }

        public BlockPos getBlockPos(EntityPos pos) {
            return PosTransformer.INSTANCE.getBlockPos(pos);
        }

        public ChunkPos getChunkPos(EntityPos pos) {
            return getChunkPos(getBlockPos(pos));
        }

        public void setBlock(onMapBlock block) {
            getChunk(getChunkPos(block.blockPos)).Editor.setBlock(block);
        }

        public void setBlock(Block block, int x, int y) {
            setBlock(new onMapBlock(this.map, block, getChunk(x, y), new BlockPos(x, y)));
        }

        public void setBlock(Block block, BlockPos pos) {
            setBlock(block, pos.getPos_x(), pos.getPos_y());
        }

        public List<onMapBlock> getBlockinAABB(Rect rect) {
            List<onMapBlock> inAABBBlocks = new ArrayList<>();
            for (onMapBlock block : getAllBlock()) {
                if (block.blockPos.InInAABB(rect)) {
                    inAABBBlocks.add(block);
                }
            }
            return inAABBBlocks;
        }
    }

}
