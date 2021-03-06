package com.fof.graphics;

import com.fof.game.main.fof_game;
import com.fof.graphics.util.FPSGetter;
import com.fof.graphics.util.IMonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Display extends JFrame implements IDrawer {
    public FPSGetter FPSGetter = new FPSGetter();
    //public Skipper Skipper = new Skipper(FPSGetter);
    public String Title;
    protected layersProvider provider;
    protected boolean ForceBanSkip = false;
    private BufferStrategy bfi;
    private VolatileImage image;
    private boolean isPreparation = true;

    //private Graphics g;
    @Deprecated
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
        Title = "Fof";
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
        Title = name;

        //g=bfi.getDrawGraphics();
    }

    public Display(String name, int Size_x, int Size_y, layersProvider provider, boolean ForceBanSkip) {
        this(name, Size_x, Size_y, provider);
        this.ForceBanSkip = ForceBanSkip;
        //g=bfi.getDrawGraphics();
    }


    @Override
    public Graphics getGraphics() {
        return bfi.getDrawGraphics();
        //return super.getGraphics();
    }

    @Override
    public void draw() {
        //noinspection deprecation
        FPSGetter.tick();
        if (this.isPreparation) {
            fof_game.INSTANCE.LOGGER.println("Display is preparing.....");
            this.fillRect(0, 0, getWidth(), getHeight());
            repaint();
            this.isPreparation = false;
            return;
        }

        if (!this.isVisible()) return;
        /*if (ForceBanSkip) {
            draw(provider.getlayers());
            repaint();
            return;
        }*/
//        boolean isUpdate=false;
        if (needUpdate()) {
            clear();
            draw(provider.getlayers());
            this.monitors.Draw(this);
            repaint();
//            isUpdate=true;
        }
        /*if (!Skipper.isSkip()) {
            //draw Method
            draw(provider.getlayers());
            repaint();
        } else {
            fof_game.INSTANCE.LOGGER.printWarn("Frame:" + this.toString() + " took " + FPSGetter.getLastTime() + " ns. It's" + FPSGetter.getFPS() + "FPS. " + "So Skipped.");
        }*/
    }

    private void clear() {
        this.fillRect(this.getBackground(), 0, this.getWidth(), 0, this.getHeight());
    }

    protected void draw(List<layer> list) {
        draw(list.toArray(new layer[0]));
    }


    private void draw(layer[] layers) {
        for (layer layer : layers) {
            draw(layer);
        }
    }

    private void draw(layer layer) {
        if (layer != null) {
            ((IDrawable) layer).draw(this);
        } else {
            fof_game.INSTANCE.LOGGER.print("in Display,layer not include IDrawable");
        }
    }

    @Override
    public void repaint() {
        fof_game.INSTANCE.LOGGER.debug("Frame:" + this.toString() + " is Repainting....");
        if (!bfi.contentsLost()) bfi.show();
        Toolkit.getDefaultToolkit().sync();
        getGraphics().dispose();
    }

    private boolean needUpdate() {
        return this.provider.requestUpdate();
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
    public Font getFont() {
        return super.getFont();
    }

    @Override
    public void setFont(Font f) {
        super.setFont(f);
    }

    public Color getColor() {
        return getGraphics().getColor();
    }

    public void setColor(Color c) {
        getGraphics().setColor(c);
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
        Graphics g = getGraphics();
        g.setColor(c);
        g.drawRect(pos_x, pos_y, size_x, size_y);
    }

    public void drawRect(int pos_x, int pos_y, int size_x, int size_y) {
        getGraphics().drawRect(pos_x, pos_y, size_x, size_y);
    }

    public void fillRect(int pos_x, int pos_y, int width, int height) {
        getGraphics().fillRect(pos_x, pos_y, width, height);
    }

    public void fillRect(Color c, int pos_x, int pos_y, int width, int height) {
        Graphics g = getGraphics();
        g.setColor(c);
        g.fillRect(pos_x, pos_y, width, height);
    }

    private void asColor(Color c, Runnable runnable) {
        Color cc = getColor();
        setColor(c);
        runnable.run();
        setColor(cc);
    }

    private void Color_Set_Test() {
        fof_game.INSTANCE.LOGGER.println("Now Color is:" + getColor().getRGB());
        setColor(new Color(new Random().nextInt()));
        fof_game.INSTANCE.LOGGER.println("After Color is:" + getColor().getRGB());
    }


    public Font getfont() {
        return getGraphics().getFont();
    }

    public void setfont(Font f) {
        getGraphics().setFont(f);
    }

    @Override
    public String toString() {
        return "Title:" + Title;
    }

    public Monitors monitors = new Monitors();

    public class Monitors {
        private Monitors() {
        }

        private List<IMonitor> monitors = new ArrayList<>();

        public Monitors addMonitor(IMonitor monitor) {
            this.monitors.add(monitor);
            return this;
        }

        public void Draw(Display display) {
            for (IMonitor monitor : this.monitors) {
                monitor.getDrawable().draw(display);
            }
        }
    }
}
