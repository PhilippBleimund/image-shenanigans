package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

import com.simonkrampe.listener.ProgressEvent;
import com.simonkrampe.listener.ProgressListener;
import com.simonkrampe.wrapper.requestData;

public abstract class imageEffect extends SwingWorker{
    
    public enum status{
        DONE
    };

    public BufferedImage originalImage;

    public BufferedImage newImage;

    public requestData data;

    private List<ProgressListener> Listeners = new ArrayList<ProgressListener>();

	protected imageEffect(requestData data, renderJob motherJob){
		this.data = data;

		this.originalImage = motherJob.getWorkingImage();
		this.newImage = deepCopy(this.originalImage);
	}

    public void addListener(ProgressListener listener) {
		Listeners.add(listener);
	}
	
	protected void notifyListener(status s) {
		for(ProgressListener L : Listeners) {
			L.changeProgressStatus(new ProgressEvent(s, this));
		}
	}

    protected BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

    public BufferedImage getFinishedRender() {
		if(this.isDone()) {
			return this.newImage;
		}else {
			return null;
		}
	}
}
