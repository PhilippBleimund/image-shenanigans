package com.simonkrampe.imageEffects;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import com.simonkrampe.wrapper.requestData;

public abstract class imageEffect{
    
    public BufferedImage originalImage;

    public BufferedImage newImage;

    public requestData data;

	public long renderTimeTaken;

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

	public String getRenderTime(){
		StringBuilder buf = new StringBuilder(20);
		String sgn = "";

		if (renderTimeTaken < 0) {
			sgn = "-";
			renderTimeTaken = Math.abs(renderTimeTaken);
		}

		append(buf, sgn, 0, (renderTimeTaken / 3600000));
		renderTimeTaken %= 3600000;
		append(buf, ":", 2, (renderTimeTaken / 60000));
		renderTimeTaken %= 60000;
		append(buf, ":", 2, (renderTimeTaken / 1000));
		renderTimeTaken %= 1000;
		append(buf, ".", 3, (renderTimeTaken));
		return buf.toString();
	}

	/**
	 * Append a right-aligned and zero-padded numeric value to a `StringBuilder`.
	 */
	static private void append(StringBuilder tgt, String pfx, int dgt, long val) {
		tgt.append(pfx);
		if (dgt > 1) {
			int pad = (dgt - 1);
			for (long xa = val; xa > 9 && pad > 0; xa /= 10) {
				pad--;
			}
			for (int xa = 0; xa < pad; xa++) {
				tgt.append('0');
			}
		}
		tgt.append(val);
	}
}
