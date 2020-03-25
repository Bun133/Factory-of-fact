package com.fof.object.block;

import com.fof.events.RegisterEvent;
import com.fof.graphics.Drawable;
import com.fof.object.item.Item;
import com.fof.register.IRegistrable;
import com.fof.register.graphics.TextureManager;

import java.awt.*;

public class Block implements IRegistrable {
    public Item BlockItem;
    @Override
    public void register(RegisterEvent event) {
        //register Event
    }

    public Block setTexture(Image image){
        TextureManager.INSTANCE.addTexture(this,image);
        return this;
    }

    public Drawable getDrawable(){
        return new Drawable(TextureManager.INSTANCE.getTexture(this));
    }
}
