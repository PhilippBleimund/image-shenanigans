package com.simonkrampe;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class mask {


    /*
     * Masks a given Image by color. Colors above threshold are white and rest is black.
     */
    public BufferedImage byColor(BufferedImage image, int threshold) {

        BufferedImage mask = image;

        int width = mask.getWidth();
        int height = mask.getHeight();
        int black = Color.black.getRGB();
        int white = Color.white.getRGB();

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++) {

                int pixel = mask.getRGB(x, y);
                if(pixel < threshold){

                    mask.setRGB(x, y, black);

                }
                else {

                    mask.setRGB(x, y, white);

                }

            }

        }

        return mask;

    }

    public int generateThreshold(BufferedImage image) {

        int totalPixels = image.getWidth() * image.getHeight();
        int threshold = 0;

        for(int y = 0; y < image.getHeight(); y++) {

            for(int x = 0; x < image.getWidth(); x++) {

                threshold = threshold + (image.getRGB(x, y) / totalPixels);

            }

        }

        return threshold;

    }

    

}
