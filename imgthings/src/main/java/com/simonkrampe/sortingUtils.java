package com.simonkrampe;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class sortingUtils {
    
    public int[] sortDescending(int[] pixelsToSort) {

        boolean sorted = false;
        while(sorted == false){
            boolean correctStreak = true;
            for(int i = 0; i < pixelsToSort.length-1; i++){

                if(pixelsToSort[i] < pixelsToSort[i + 1]){

                    int Position1 = pixelsToSort[i];
                    int Position2 = pixelsToSort[i + 1];

                    pixelsToSort[i] = Position2;
                    pixelsToSort[i + 1] = Position1;

                    correctStreak = false;
                
                }
            }
            if(correctStreak == true)
                sorted = true;
        }

        return pixelsToSort;

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

}
