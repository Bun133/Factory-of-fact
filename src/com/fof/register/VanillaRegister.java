package com.fof.register;

import com.fof.object.block.Block;
import com.fof.object.item.Item;
import com.fof.util.file.FileMaster;

public class VanillaRegister {
    //"src\\assets\\textures\\blocks\\OhNo.png"
    public static Block OhNoBlock = new Block("OhNoBlock", "OhNo_Block").setTexture(FileMaster.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
    public static Block Sand = new Block("OhNoBlock", "OhNo_Block").setTexture(FileMaster.getImage("src\\assets\\textures\\blocks\\sand.png"));
    public static Block Stone = new Block("OhNoBlock", "OhNo_Block").setTexture(FileMaster.getImage("src\\assets\\textures\\blocks\\stone.png"));
    public static Block Water = new Block("OhNoBlock", "OhNo_Block").setTexture(FileMaster.getImage("src\\assets\\textures\\blocks\\water.png"));
    public static Item OhNoItem = new Item("OhNoItem", "OhNo_Item").setTexture(FileMaster.getImage("src\\assets\\textures\\blocks\\OhNo.png"));
    public static Block Copper;
}
