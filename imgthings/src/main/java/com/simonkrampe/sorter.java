package com.simonkrampe;

import java.awt.image.BufferedImage;

public class sorter {

    sortingUtils sU;

    public sorter(){

        sU = new sortingUtils();

    }

    /*
     * Takes an image that was converted to a mask and sorts highlights.
     */
    public BufferedImage sortHorizontalDescending(BufferedImage masked, BufferedImage image) {

        int[][] mask = sU.convertMaskHorizontal(masked);

        int width = masked.getWidth();
        int height = masked.getHeight();

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++){

                int length = mask[x][y];

                if(length != 0){
                    
                    int[] pixelsToSort = new int[length];

                    for(int i = 0; i < length; i++) {
                        pixelsToSort[i] = image.getRGB(x+i, y);
                    }

                    int[] sorted = sU.sortDescending(pixelsToSort);

                    for(int i = 0; i < length; i++){
                        image.setRGB(x+i, y, sorted[i]);
                    }

                }

            }
        }

        return image;

    }

    


    
}
