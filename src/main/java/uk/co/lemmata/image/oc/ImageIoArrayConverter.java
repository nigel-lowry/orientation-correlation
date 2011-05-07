package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIoArrayConverter implements ImageToArrayConverter {

	private static final double RED_WEIGHTING = .25;
	private static final double GREEN_WEIGHTING = .5;
	private static final double BLUE_WEIGHTING = .25;

	@Override
	public Double[][] toIntensityArray(final File file) throws IOException {
		final BufferedImage image = ImageIO.read(checkNotNull(file));
		
		if (image == null) {
			throw new IllegalArgumentException("Could not find image type reader for " + file);
		}
		
		final int height = image.getHeight();
		final int width = image.getWidth();
		
		final Double[][] intensities = new Double[height][width];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				intensities[y][x] = toIntensity(new Color(image.getRGB(x, y)));
			}
		}

		return intensities;
	}

	private double toIntensity(final Color color) {
		return RED_WEIGHTING * color.getRed() + GREEN_WEIGHTING * color.getGreen() + BLUE_WEIGHTING * color.getBlue();
	}

}
