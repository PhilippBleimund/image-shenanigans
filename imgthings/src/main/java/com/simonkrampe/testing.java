package com.simonkrampe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class testing {
    
    public static void main (String[] args) {

        handler h = new handler();
        mask m = new mask();
        sorter s = new sorter();

        BufferedImage image = h.bufferImage("C:\\Users\\smnkr\\GitHub\\image-shenanigans\\imgthings\\src\\main\\java\\com\\simonkrampe\\test2.jpg");
        BufferedImage masked = m.byColor(image, -13000000);

        
        try {
            File outputfile = new File("mask.jpg");
            ImageIO.write(masked, "jpg", outputfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedImage ogImage = h.bufferImage("C:\\Users\\smnkr\\GitHub\\image-shenanigans\\imgthings\\src\\main\\java\\com\\simonkrampe\\test2.jpg");
        BufferedImage sorted = s.sortHorizontalDescending(masked, ogImage);

        try {
            File savefile = new File("sorted.jpg");
            ImageIO.write(sorted, "jpg", savefile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
