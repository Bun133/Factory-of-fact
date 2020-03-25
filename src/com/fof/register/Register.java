package com.fof.register;

import com.fof.object.block.Block;
import com.fof.object.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Register {
    public static Register INSTANCE=new Register();
    private Map<Integer, String> itemNameMap=new HashMap<Integer, String>();
    private Map<String, Item> itemMap=new HashMap<String, Item>();
    private Map<Integer, String> blockNameMap=new HashMap<Integer, String>();
    private Map<String, Block> blockMap=new HashMap<>();

    public Block getBlock(String id){return blockMap.get(id);}
    public Block getBlock(int id){return blockMap.get(blockNameMap.get(id));}
    public Item getItem(String id){return itemMap.get(id);}
    public Item getItem(int id){return itemMap.get(itemNameMap.get(id));}

    public void addRegister(Item item,String id_name,int id){
        itemMap.put(id_name,item);
        itemNameMap.put(id,id_name);
    }

    public void addRegister(Block block,String id_name,int id){
        blockMap.put(id_name,block);
        blockNameMap.put(id,id_name);
    }

    public boolean isThereItem(Item item){
        for(Item for_item:itemMap.values()){
            if(for_item==item){
                return true;
            }
        }
        return false;
    }

    public boolean isThereBlock(Block block){
        for(Block for_block:blockMap.values()){
            if(for_block==block){
                return true;
            }
        }
        return false;
    }
}
