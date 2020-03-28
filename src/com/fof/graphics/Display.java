package com.fof.graphics;

import com.fof.game.main.fof_game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame implements IDrawer {
    private layersProvider provider;
    private BufferStrategy bfi;

    //private Graphics g;
    public Display(int Size_x, int Size_y, layersProvider provider) {
        this.provider = provider;
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
        //g=bfi.getDrawGraphics();
    }

    public Display(String name, int Size_x, int Size_y, layersProvider provider) {
        this.provider = provider;
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
        //g=bfi.getDrawGraphics();
    }

    @Override
    public Graphics getGraphics() {
        return bfi.getDrawGraphics();
    }

    @Override
    public void draw() {
        if (!Skipper.INSTANCE.isSkip()) {
            //draw Method
            draw(provider.getlayers());
            repaint();
        } else {
            fof_game.INSTANCE.LOGGER.println("The Frame took longer.So Skipped");
        }
    }

    private void draw(layer[] layers) {
        for (layer layer : layers) {
            draw(layer);
        }
    }

    private void draw(layer layer) {
        if (layer instanceof IDrawable) {
            ((IDrawable) layer).draw(this);
        } else {
            fof_game.INSTANCE.LOGGER.print("in Display,layer not include IDrawable");
        }
    }

    @Override
    public void update(Graphics g) {
        if (!Skipper.INSTANCE.isSkip()) {
            super.update(g);
        } else {
            fof_game.INSTANCE.LOGGER.println("The Frame took longer.So Skipped");
        }
    }

    @Override
    public void repaint() {
        if (!bfi.contentsLost()) bfi.show();
        Toolkit.getDefaultToolkit().sync();
    }


    public void setFull() {
        setUndecorated(true);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        device.setFullScreenWindow(this);
    }

    public void disableFull() {
        setUndecorated(false);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        device.setFullScreenWindow(null);
    }

    public void setUndecorated(Boolean b) {
        dispose();
        this.setUndecorated(b);
        this.setVisible(true);
    }


    @Override
    public void setFont(Font f) {
        super.setFont(f);
    }

    @Override
    public Font getFont() {
        return super.getFont();
    }


    public void setColor(Color c) {
        getGraphics().setColor(c);
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


    public void drawImage(Image img, int pos_x, int pos_y) {
        getGraphics().drawImage(img, pos_x, pos_y, null);
    }

    public void drawImage(Image image, int x, int y, int w, int h) {
        getGraphics().drawImage(image, x, y, w, y, null);
    }

    public void drawImage(Image image, int x, int y, double image_x, double image_y) {
        drawImage(image, x, y, (int) image_x, (int) image_y);
    }

    public void drawImage(Image image, int x, int y, double d) {
        int image_x = 0;
        int image_y = 0;
        image_x = image.getWidth(null);
        image_y = image.getHeight(null);
        drawImage(image, x, y, image_x * d, image_y * d);
    }


    public void drawString(String text, int pos_x, int pos_y) {
        getGraphics().drawString(text, pos_x, pos_y);
    }

    public void drawString(Font f, String text, int pos_x, int pos_y) {
        Font ff = getFont();
        setFont(f);
        getGraphics().drawString(text, pos_x, pos_y);
        setFont(ff);
    }

    public void drawRect(Color c, int pos_x, int pos_y, int size_x, int size_y) {
        Color cc = getColor();
        setColor(c);
        getGraphics().drawRect(pos_x, pos_y, size_x, size_y);
        setColor(cc);
    }

    public void fillRect(int pos_x, int pos_y, int width, int height) {
        getGraphics().fillRect(pos_x, pos_y, width, height);
    }

    public void fillRect(Color c, int pos_x, int pos_y, int width, int height) {
        Color cc = getColor();
        setColor(c);
        getGraphics().fillRect(pos_x, pos_y, width, height);
        setColor(cc);
    }


    public Font getfont() {
        return getGraphics().getFont();
    }

    public void setfont(Font f) {
        getGraphics().setFont(f);
    }
}