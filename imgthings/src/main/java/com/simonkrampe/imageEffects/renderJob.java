package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.SwingWorker;

import com.simonkrampe.listener.JobEvent;
import com.simonkrampe.listener.JobListener;

public class renderJob extends SwingWorker{
    
    public enum status{
        DONE
    };

    private BufferedImage workingImage;

    private BlockingQueue<imageEffect> effects = new LinkedBlockingQueue<imageEffect>();

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

    @Override
    protected Object doInBackground() throws Exception {
        while(!effects.isEmpty()){
            imageEffect effect = effects.poll();
            effect.setImage(workingImage);
            //start rendering
            effect.imageTransformation();
            workingImage = effect.getFinishedRender();
        }

        return null;
    }

    
    @Override
    protected void done() {
        this.notifyListener(status.DONE);
    }
}
