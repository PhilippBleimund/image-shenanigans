package com.simonkrampe.wrapper;

public class imageSorterData extends requestData{
    
    private int threshold;


    public imageSorterData(String id, int threshold){
        super(id);
        this.threshold = threshold;
    }

    public int getThreshold(){
        return this.threshold;
    }
}
