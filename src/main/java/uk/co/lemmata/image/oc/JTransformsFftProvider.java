package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;
import static com.google.common.base.Preconditions.*;
import edu.emory.mathcs.jtransforms.fft.DoubleFFT_2D;


public class JTransformsFftProvider implements FourierTransformProvider {
	
	@Override
	public ComplexNumber[][] forwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		
		final DoubleFFT_2D fft = new DoubleFFT_2D(height(complexNumbers), width(complexNumbers));
		
		final double[][] doubleArray = JTransformArrayUtils.toDoubleArray(complexNumbers);
		fft.complexForward(doubleArray); // this will modify arg
		
		// now get back to complex array
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNumber[][] backwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		// TODO Auto-generated method stub
		return null;
	}

}
