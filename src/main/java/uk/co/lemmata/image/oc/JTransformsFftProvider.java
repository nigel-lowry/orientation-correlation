package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.checkArgument;
import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.height;
import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.isEmpty;
import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.width;
import edu.emory.mathcs.jtransforms.fft.DoubleFFT_2D;


public class JTransformsFftProvider implements FourierTransformProvider {
	
	@Override
	public ComplexNumber[][] forwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		
		final double[][] primitives = toPrimitiveArray(JTransformArrayUtils.toDoubleArray(complexNumbers));
		new DoubleFFT_2D(height(complexNumbers), width(complexNumbers)).complexForward(primitives);
		
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
		
		final double[][] primitives = toPrimitiveArray(JTransformArrayUtils.toDoubleArray(complexNumbers));
		new DoubleFFT_2D(height(complexNumbers), width(complexNumbers)).complexInverse(primitives, true);
		
		return JTransformArrayUtils.toComplexNumberArray(primitives);
	}

}
