package com.fof.object.item;

import com.fof.events.RegisterEvent;
import com.fof.graphics.Drawable;
import com.fof.register.IRegistrable;
import com.fof.register.graphics.TextureManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item implements IRegistrable {
    public String name;
    public String id;

    public Item(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Item(String name, String id, Image image) {
        TextureManager.INSTANCE.addTexture(this, image);
        this.name = name;
        this.id = id;
    }

    @Override
    public void register(RegisterEvent event) {
        //register Event
    }

    public Item setTexture(Image image) {
        TextureManager.INSTANCE.addTexture(this, image);
        return this;
    }

    public Item setTexture(BufferedImage image) {
        TextureManager.INSTANCE.addTexture(this, image);
        return this;
    }

    public Drawable getDrawable() {
        return new Drawable(TextureManager.INSTANCE.getTexture(this));
    }
}
