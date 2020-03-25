package com.fof.graphics;

import com.fof.game.main.fof_game;

public class Display implements IDrawer {
    private layersProvider provider;

    public Display(layersProvider provider){
        this.provider=provider;
    }
    @Override
    public void draw() {
        //draw Method
        draw(provider.getlayers());
    }

    public void draw(layer[] layers){
        for(int i=0;i>layers.length;i++){
            draw(layers[i]);
        }
    }

    private void draw(layer layer) {
        if(layer instanceof IDrawable){
            ((IDrawable) layer).draw();
        }else{
            fof_game.LOGGER.print("in Display,layer not include IDrawable");
        }
    }
}
