package com.fof.register.graphics;

import com.fof.game.main.fof_game;
import com.fof.object.block.Block;
import com.fof.object.item.Item;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TextureManager {
    public static TextureManager INSTANCE=new TextureManager();
    public Map<Item, Image> ItemTexture=new HashMap<>();

    public void addTexture(Item item,Image image){
        ItemTexture.put(item, image);
    }

    public void addTexture(Block block, Image image){
        ItemTexture.put(block.BlockItem, image);
    }

    public Image getTexture(Item item){
        fof_game.INSTANCE.LOGGER.println(item.name+":"+ItemTexture.get(item).toString());
        return ItemTexture.get(item);
    }

    public Image getTexture(Block block){
        return ItemTexture.get(block.BlockItem);
    }
}
