package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;

import java.awt.geom.AffineTransform;
import java.io.*;

public class OrientationCorrelationImageAligner implements ImageAligner {

	@Override
	public AffineTransform multiModal(final File imageFile1, final File imageFile2) {
		try {
			final ComplexNumber[][] matchingSurface = new JTransformsFftProvider().backwardFft(multiply(new JTransformsFftProvider().forwardFft(new SimpleGradientImageProvider().squaredGradientImage(new ImageIoArrayConverter().toIntensityArray(imageFile1))), conjugate(new JTransformsFftProvider().forwardFft(new SimpleGradientImageProvider().squaredGradientImage(new ImageIoArrayConverter().toIntensityArray(imageFile2))))));
			
			// find peak in real part 
			return peakInRealPartToTranslation(matchingSurface);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new IllegalStateException();
	}
	
	private AffineTransform peakInRealPartToTranslation(final ComplexNumber[][] matchingSurface) {
		final int height = height(matchingSurface);
		final int width = width(matchingSurface);
		
		double max = Double.NEGATIVE_INFINITY;
		final AffineTransform translation = new AffineTransform();
		
		for (int x = 0; x < width - 1; x++) {
			for (int y = 0; y < height - 1; y++) {
				final double realPart = matchingSurface[y][x].getReal();
				
				if (realPart > max) {
					max = realPart;
					translation.setToTranslation(x, y);
				}
			}
		}
		
		return translation;
	}

}
