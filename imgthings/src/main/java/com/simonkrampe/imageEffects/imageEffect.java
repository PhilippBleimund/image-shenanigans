package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import com.simonkrampe.wrapper.requestData;

public abstract class imageEffect{
    
    public BufferedImage originalImage;

    public BufferedImage newImage;

    public requestData data;

	public abstract void imageTransformation();

	protected imageEffect(requestData data, renderJob motherJob){
		this.data = data;

		this.originalImage = motherJob.getWorkingImage();
		this.newImage = deepCopy(this.originalImage);
	}

    protected BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

	public void setImage(BufferedImage image){
		this.originalImage = image;
	}

    public BufferedImage getFinishedRender() {
		return this.newImage;
	}
}
