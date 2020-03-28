package com.fof.register.graphics;

import com.fof.game.main.fof_game;
import com.fof.object.block.Block;
import com.fof.object.item.Item;
import com.fof.object.itemblock.ItemBlock;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TextureManager {
    public static TextureManager INSTANCE = new TextureManager();
    public Map<Item, Image> ItemTexture = new HashMap<>();
    public Map<Block, Image> BlockTexture = new HashMap<>();
    public Map<ItemBlock, Image> ItemBlockTexture = new HashMap<>();

    public void addTexture(Item item, Image image) {
        ItemTexture.put(item, image);
    }

    public void addTexture(Block block, Image image) {
        BlockTexture.put(block, image);
        addTexture(block.ItemBlock, image);
    }

    private void addTexture(ItemBlock itemBlock, Image image) {
        ItemBlockTexture.put(itemBlock, image);
    }

    public Image getTexture(Item item) {
        fof_game.INSTANCE.LOGGER.println(item.name + ":" + ItemTexture.get(item).toString());
        return ItemTexture.get(item);
    }

    public Image getTexture(Block block) {
        return BlockTexture.get(block);
    }

    public Image getTexture(ItemBlock block) {
        return ItemBlockTexture.get(block);
    }
}
