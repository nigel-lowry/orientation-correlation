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
		
		final int width = width(complexNumbers);
		final int height = height(complexNumbers);
		final double[] primitives = JTransformArrayUtils.toDoubleArray(complexNumbers);
		new DoubleFFT_2D(height, width).complexForward(primitives);
		
		return JTransformArrayUtils.toComplexNumberArray(primitives, width, height);
	}

	@Override
	public ComplexNumber[][] backwardFft(final ComplexNumber[][] complexNumbers) {
		checkArgument(!isEmpty(complexNumbers));
		
		final int width = width(complexNumbers);
		final int height = height(complexNumbers);
		final double[] doubles = JTransformArrayUtils.toDoubleArray(complexNumbers);
		new DoubleFFT_2D(height, width).complexInverse(doubles, true);
		
		return JTransformArrayUtils.toComplexNumberArray(doubles, width, height);
	}

}
