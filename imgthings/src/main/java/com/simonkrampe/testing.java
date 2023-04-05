package com.simonkrampe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.simonkrampe.sorter.SortMethod;

public class testing {
    
    public static void main (String[] args) {

        handler h = new handler();
        mask m = new mask();
        sorter s = new sorter();

        File f = new File(System.getProperty("user.dir") + "/imgthings/src/main/java/com/simonkrampe/test2.jpg");

        BufferedImage image = h.bufferImage(f.toString());
        BufferedImage masked = m.byColor(image, -13000000);

        
        try {
            File outputfile = new File("mask.jpg");
            ImageIO.write(masked, "jpg", outputfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedImage ogImage = h.bufferImage(f.toString());
        BufferedImage sorted = s.sortHorizontal(masked, ogImage, SortMethod.DESCENDING);

        try {
            File savefile = new File("sorted.jpg");
            ImageIO.write(sorted, "jpg", savefile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
