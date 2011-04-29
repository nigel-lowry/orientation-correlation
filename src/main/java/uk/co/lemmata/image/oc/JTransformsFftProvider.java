package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;
import edu.emory.mathcs.jtransforms.fft.DoubleFFT_2D;


public class JTransformsFftProvider implements FourierTransformProvider {
	
	@Override
	public ComplexNumber[][] forwardFft(final ComplexNumber[][] input) {
		checkArgument(input.length > 0);
		
		final RasterArray rasterArray = new RasterArray(input);
		
		final DoubleFFT_2D fft = new DoubleFFT_2D(rasterArray.getHeight(), rasterArray.getWidth());
		
		final double[][] doubleArray = rasterArray.to2dDoubleArray();
		fft.complexForward(doubleArray); // this will modify arg
		
		// now get back to complex array
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNumber[][] backwardFft(final ComplexNumber[][] input) {
		checkArgument(input.length > 0);
		// TODO Auto-generated method stub
		return null;
	}

}
