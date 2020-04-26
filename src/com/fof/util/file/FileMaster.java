package com.fof.util.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileMaster {
    public static FileMaster INSTANCE = new FileMaster();

    public static Image OhNO_Image = getImage("src\\assets\\textures\\blocks\\OhNo.png");

    public static Image getImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return OhNO_Image;
    }
}
