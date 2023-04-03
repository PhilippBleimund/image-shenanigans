package com.simonkrampe.wrapper;

public class imageSorterData extends requestData{
    
    private int threshold;


    public imageSorterData(int threshold){
        this.threshold = threshold;
    }

    public int getThreshold(){
        return this.threshold;
    }
}
