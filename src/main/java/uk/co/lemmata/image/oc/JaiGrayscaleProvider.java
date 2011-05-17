package uk.co.lemmata.image.oc;

import java.awt.image.*;
import java.io.*;

import javax.media.jai.*;

public class JaiGrayscaleProvider implements GrayscaleProvider {
	
	@Override
	public RenderedOp toGrayscale(File imageFile) {
		final RenderedImage renderedImage = JAI.create("fileload", imageFile.getAbsolutePath());
		return JAI.create("bandcombine", renderedImage, new double[][] { { 0.299, 0.587, 0.114, 0.0 } });
	}

}
