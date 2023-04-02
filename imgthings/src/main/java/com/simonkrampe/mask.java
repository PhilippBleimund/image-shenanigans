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

    public int generateThresholdRough(BufferedImage image) {

        long allPixelData = 0;

        for(int y = 0; y < image.getHeight(); y++) {

            for(int x = 0; x < image.getWidth(); x++) {

                allPixelData = allPixelData + image.getRGB(x, y);

            }

        }

        long threshold = allPixelData / (image.getHeight() * image.getWidth());
        return (int)threshold;

    }

    public int generateThresholdAccurate(BufferedImage image){

        long blueValues = 0;
        long redValues = 0;
        long greenValues = 0;

        for(int y = 0; y < image.getHeight(); y++){

            for(int x = 0; x < image.getWidth(); x++) {

                Color currentPixel = new Color(image.getRGB(x, y));

                blueValues = blueValues + currentPixel.getBlue();
                redValues = redValues + currentPixel.getRed();
                greenValues = greenValues + currentPixel.getGreen();

            }

        }
        int totalPixels = image.getHeight() * image.getWidth();
        redValues = redValues / totalPixels;
        greenValues = greenValues / totalPixels;
        blueValues = blueValues / totalPixels;

        Color averageColor = new Color((int)redValues, (int)greenValues, (int)blueValues);
        return  averageColor.getRGB();

    }

    

}
