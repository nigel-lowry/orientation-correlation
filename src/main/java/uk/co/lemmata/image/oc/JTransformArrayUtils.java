package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;


public final class JTransformArrayUtils {
	
	private JTransformArrayUtils() {}

	public static Double[][] toDoubleArray(final ComplexNumber[][] complexNumbers) {
		final int height = height(complexNumbers);
		final int width = width(complexNumbers);
		
		final Double[][] doubles = new Double[height][2 * width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				doubles[row][realPartColumnIndex(column)] = complexNumbers[row][column].getReal();
				doubles[row][imaginaryPartColumnIndex(column)] = complexNumbers[row][column].getImaginary();
			}
		}
		
		return doubles;
	}

	private static int imaginaryPartColumnIndex(int column) {
		return realPartColumnIndex(column) + 1;
	}

	private static int realPartColumnIndex(int column) {
		return 2 * column;
	}
	
	public static ComplexNumber[][] toComplexNumberArray(final double[][] doubles) {
		// TODO think about going with 1D array for 2D transform
		final int height = doubles.length;
		final int width = doubles[0].length;
		final Double[][] wrappers = new Double[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				wrappers[row][column] = doubles[row][column];
			}
		}
		
		return toComplexNumberArray(wrappers);
	}

	public static ComplexNumber[][] toComplexNumberArray(final Double[][] doubles) {
		final int height = height(doubles);
		final int width = width(doubles);
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width / 2];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width / 2; column++) {
				final double real = doubles[row][realPartColumnIndex(column)];
				final double imaginary = doubles[row][imaginaryPartColumnIndex(column)];
				complexNumbers[row][column] = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
			}
		}
		
		return complexNumbers;
	}

}