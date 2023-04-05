package com.simonkrampe.manager;

public class jobManager {
    
    public jobManager INSTANCE;



    
    public jobManager getInstance(){
        if(this.INSTANCE == null)
            this.INSTANCE = new jobManager();

        return INSTANCE;
    }
}
