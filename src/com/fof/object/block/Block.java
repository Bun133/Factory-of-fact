package com.fof.object.block;

import com.fof.events.RegisterEvent;
import com.fof.graphics.Drawable;
import com.fof.object.itemblock.ItemBlock;
import com.fof.register.IRegistrable;
import com.fof.register.graphics.TextureManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block implements IRegistrable {
    public ItemBlock ItemBlock;
    public String name;
    public String id;

    public Block(String name, String id) {
        ItemBlock = com.fof.object.itemblock.ItemBlock.ItemBlockGenelator(this);
        this.name = name;
        this.id = id;
    }

    @Override
    public void register(RegisterEvent event) {
        event.register(this);
    }

    public Block setTexture(Image image) {
        TextureManager.INSTANCE.addTexture(this, image);
        return this;
    }

    public Block setTexture(BufferedImage image) {
        TextureManager.INSTANCE.addTexture(this, image);
        return this;
    }

    public Drawable getDrawable() {
        return new Drawable(TextureManager.INSTANCE.getTexture(this));
    }

    @Override
    public String toString() {
        return "ID:" + this.id + " Name:" + this.name;
    }
}
