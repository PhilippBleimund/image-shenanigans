package com.simonkrampe.manager;

import java.util.ArrayList;
import java.util.List;

import com.simonkrampe.imageEffects.renderJob;

public class jobManager {
    
    public jobManager INSTANCE;

    public List<renderJob> preloadJobs = new ArrayList<renderJob>();

    public List<renderJob> QueuedJobs = new ArrayList<renderJob>();



    public jobManager getInstance(){
        if(this.INSTANCE == null)
            this.INSTANCE = new jobManager();

        return INSTANCE;
    }
}
