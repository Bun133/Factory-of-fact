package com.fof.util.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileMaster {
    public static FileMaster INSTANCE = new FileMaster();

    public Image getImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }
}
