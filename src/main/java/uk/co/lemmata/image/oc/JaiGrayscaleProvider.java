package uk.co.lemmata.image.oc;

import java.awt.image.*;
import java.io.*;

import javax.media.jai.*;

public class JaiGrayscaleProvider implements GrayscaleProvider {
	
	private static final double RED_PROPORTION = 0.299;
	private static final double GREEN_PROPORTION = 0.587;
	private static final double BLUE_PROPORTION = 0.114;
	private static final double ALPHA_PROPORTION = 0.0;
	private static final double[][] COLOR_COMPONENT_PROPORTIONS = {{RED_PROPORTION, GREEN_PROPORTION, BLUE_PROPORTION, ALPHA_PROPORTION}};

	@Override
	public RenderedOp toGrayscale(final File imageFile) {
		final RenderedImage renderedImage = JAI.create("fileload", imageFile.getAbsolutePath());
		return JAI.create("bandcombine", renderedImage, COLOR_COMPONENT_PROPORTIONS);
	}

}
