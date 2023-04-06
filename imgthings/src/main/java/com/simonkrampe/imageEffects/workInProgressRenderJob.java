package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.SwingWorker;

import com.simonkrampe.imageEffects.renderJob.status;
import com.simonkrampe.listener.JobEvent;
import com.simonkrampe.listener.JobListener;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

public class workInProgressRenderJob{

    private BufferedImage workingImage;

    private List<imageEffect> effects = new ArrayList<imageEffect>();

    public void addImageEffect(imageEffect effect){
        effects.add(effect);
    }

    public imageEffect getSpecificEffect(int index){
        return effects.get(index);
    }

    public void setWorkingImage(BufferedImage workingImage){
        BufferedImage scaledDownImage = Scalr.resize(workingImage, Scalr.Method.SPEED, Scalr.Mode.FIT_EXACT, workingImage.getWidth() / 3, workingImage.getHeight() / 3);
        this.workingImage = scaledDownImage;
    }

    public renderJob getAsRenderJob(){
        renderJob job = new renderJob();
        job.addImageEffect(effects);
        return job;
    }
}
