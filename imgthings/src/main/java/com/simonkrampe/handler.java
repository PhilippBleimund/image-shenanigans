package com.simonkrampe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class handler {
    
    public BufferedImage bufferImage(String path) {

        BufferedImage picture = null;
        try {
            picture = ImageIO.read(new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return picture;

    }

}
