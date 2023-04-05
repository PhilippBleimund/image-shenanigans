package com.simonkrampe.listener;

import com.simonkrampe.imageEffects.imageEffect;
import com.simonkrampe.imageEffects.renderJob.status;

public class ProgressEvent {
    private status status;
    private imageEffect imageEffect;

    public ProgressEvent(status status, imageEffect imageEffect){
        this.status = status;
        this.imageEffect = imageEffect;
    }

    public status getStatus(){
        return this.status;
    }

    public imageEffect getImageEffect(){
        return this.imageEffect;
    }
}
