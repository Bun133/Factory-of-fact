package com.fof.graphics;

import com.fof.game.main.fof_game;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame implements IDrawer {
    private layersProvider provider;

    public Display(int Size_x,int Size_y,layersProvider provider){
        this.provider=provider;
        //this.setTitle(Title);
        this.setVisible(true);
        this.setBounds(0, 0, Size_x, Size_y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        this.setIgnoreRepaint(false);
        //this.createBufferStrategy(2);
        //bfi = J.getBufferStrategy();
        //g=J.getGraphics();
    }

    public Display(String name,int Size_x,int Size_y,layersProvider provider){
        this.provider=provider;
        this.setTitle(name);
        this.setVisible(true);
        this.setBounds(0, 0, Size_x, Size_y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        this.setIgnoreRepaint(false);
        //this.createBufferStrategy(2);
        //bfi = J.getBufferStrategy();
        //g=J.getGraphics();
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
            ((IDrawable) layer).draw(this.getGraphics());
        }else{
            fof_game.INSTANCE.LOGGER.print("in Display,layer not include IDrawable");
        }
    }
}
