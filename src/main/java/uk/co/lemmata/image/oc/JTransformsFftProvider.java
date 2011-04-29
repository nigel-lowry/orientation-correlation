package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;
import static com.google.common.base.Preconditions.*;

import org.apache.commons.lang.ArrayUtils;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_2D;


public class JTransformsFftProvider implements FourierTransformProvider {
	
	@Override
	public ComplexNumber[][] forwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		
		final DoubleFFT_2D fft = new DoubleFFT_2D(height(complexNumbers), width(complexNumbers));
		final double[][] primitives = toPrimitiveArray(JTransformArrayUtils.toDoubleArray(complexNumbers));
		fft.complexForward(primitives);
		
		return JTransformArrayUtils.toComplexNumberArray(primitives);
	}
	
	private double[][] toPrimitiveArray(final Double[][] wrappers) {
		final int height = height(wrappers);
		final int width = width(wrappers);
		final double[][] primitiveArray = new double[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				primitiveArray[row][column] = wrappers[row][column];
			}
		}
		
		return primitiveArray;
	}

	@Override
	public ComplexNumber[][] backwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		// TODO Auto-generated method stub
		return null;
	}

}
