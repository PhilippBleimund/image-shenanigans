package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

import com.simonkrampe.imageEffects.imageEffect.status;
import com.simonkrampe.listener.JobEvent;
import com.simonkrampe.listener.JobListener;

public class renderJob{
    
    private BufferedImage workingImage;

    private List<imageEffect> effects = new ArrayList<imageEffect>();

    private List<JobListener> Listeners = new ArrayList<JobListener>();

    public void addListener(JobListener listener) {
		Listeners.add(listener);
	}
	
	protected void notifyListener(status s) {
		for(JobListener L : Listeners) {
			L.changeProgressStatus(new JobEvent(s));
		}
	}

    public void addImageEffect(imageEffect effect){
        effects.add(effect);
    }

    public BufferedImage getWorkingImage(){
        return this.workingImage;
    }

    public void setWorkingImage(BufferedImage workingImage){
        this.workingImage = workingImage;
    }
}
