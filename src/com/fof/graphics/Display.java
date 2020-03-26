package com.fof.graphics;

import com.fof.game.main.fof_game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame implements IDrawer {
    private layersProvider provider;
    private BufferStrategy bfi;
    private Graphics g;
    public Display(int Size_x,int Size_y,layersProvider provider){
        this.provider=provider;
        this.setTitle("Fof");
        this.setVisible(true);
        this.setBounds(0, 0, Size_x, Size_y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        this.setIgnoreRepaint(false);
        this.createBufferStrategy(2);
        bfi = getBufferStrategy();
        g=super.getGraphics();
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
        this.createBufferStrategy(2);
        bfi = getBufferStrategy();
        g=super.getGraphics();
    }


    public Graphics getGraphics(){return g;}

    @Override
    public void draw() {
        //draw Method
        draw(provider.getlayers());
    }

    public void draw(layer[] layers){
        for(int i=0;i<layers.length;i++){
            draw(layers[i]);
        }
    }

    private void draw(layer layer) {
        if(layer instanceof IDrawable){
            ((IDrawable) layer).draw(this);
        }else{
            fof_game.INSTANCE.LOGGER.print("in Display,layer not include IDrawable");
        }
    }

    public void drawImage(Image img,int pos_x,int pos_y){
        getGraphics().drawImage(img,pos_x,pos_y,null);
    }

    public void drawString(String text,int pos_x,int pos_y){
        getGraphics().drawString(text,pos_x,pos_y);
    }

    public void drawString(Font f,String text,int pos_x,int pos_y){
        Font ff=getFont();
        setFont(f);
        getGraphics().drawString(text,pos_x,pos_y);
        setFont(ff);
    }

    @Override
    public void setFont(Font f) {
        super.setFont(f);
    }

    @Override
    public Font getFont() {
        return super.getFont();
    }


    public Color getColor() {
        return getGraphics().getColor();
    }

    public int getColor_R() {
        return getGraphics().getColor().getRed();
    }

    public int getColor_G() {
        return getGraphics().getColor().getGreen();
    }

    public int getColor_B() {
        return getGraphics().getColor().getBlue();
    }
}
