package com.simonkrampe.listener;

import com.simonkrampe.imageEffects.imageEffect.status;

public class JobEvent {
    private status status;

    public JobEvent(status status){
        this.status = status;
    }

    public status getStatus(){
        return this.status;
    }
}