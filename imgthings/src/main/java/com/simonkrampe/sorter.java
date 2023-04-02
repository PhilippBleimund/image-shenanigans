package com.simonkrampe;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

public class sorter {

    public sorter(){

    }

    /*
     * Takes an image that was converted to a mask and sorts highlights.
     */
    public BufferedImage sortHorizontal(BufferedImage masked, BufferedImage image, String sortOrder, String axisOrder) {

        int[][] mask = convertMask(masked, axisOrder);

        int width = masked.getWidth();
        int height = masked.getHeight();

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++){

                int length = mask[x][y];

                if(length != 0){
                    
                    Integer[] pixelsToSort = new Integer[length];

                    for(int i = 0; i < length; i++) {
                        pixelsToSort[i] = image.getRGB(x+i, y);
                    }

                    switch (sortOrder) {
                        case "asc":
                            Arrays.sort(pixelsToSort);
                            break;
                        case "desc":
                            Arrays.sort(pixelsToSort, Collections.reverseOrder());  
                            break;
                        default:
                            return null;
                    }
                    
                    for(int i = 0; i < length; i++){
                        image.setRGB(x+i, y, pixelsToSort[i]);
                    }

                }

            }
        }

        return image;

    }
    


    public int[][] convertMaskHorizontal(BufferedImage image) {

        int width = image.getWidth();
        int height = image.getHeight();

        int[][] mask = new int[width][height];
        
        int white = Color.white.getRGB();

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++){

                int pixel = image.getRGB(x, y);
                
                if(pixel == white){
                    int start = x;
                    int length = 0;
                    while(pixel == white && x < width){
                        pixel = image.getRGB(x, y);
                        x++;
                        length++;
                    }
                    mask[start][y] = length;
                }

            }

        }

        return mask;

    }

    public int[][] convertMask(BufferedImage image, String axisOrder) {

        int width = image.getWidth();
        int height = image.getHeight();

        int[][] mask = new int[width][height];
        
        int white = Color.white.getRGB();

        class countPixels {

            public void whitePixels(int x, int y) {

                int pixel = image.getRGB(x, y);
                    
                        if(pixel == white){
                            int start = x;
                            int length = 0;
                            while(pixel == white && x < width){
                                pixel = image.getRGB(x, y);
                                x++;
                                length++;
                            }
                            mask[start][y] = length;
                        }

            }



        }

        countPixels count = new countPixels();

        switch(axisOrder){
            case "xy":
                for(int y = 0; y < height; y++){

                    for(int x = 0; x < width; x++){
    
                        count.whitePixels(x, y);
    
                    }
    
                }
                break;
            case "yx":
                for(int x = 0; x < width; x++){

                    for(int y = 0; y < height; y++){
    
                        count.whitePixels(x, y);
    
                    }
    
                }
                break;
            default:
                return null;

        }

        return mask;

    }
    


    
}
