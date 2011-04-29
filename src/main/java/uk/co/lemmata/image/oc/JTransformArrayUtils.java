package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;
import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;


public final class JTransformArrayUtils {
	
	private JTransformArrayUtils() {}

	public static double[] toDoubleArray(final ComplexNumber[][] complexNumbers) {
		final int height = height(complexNumbers);
		final int width = width(complexNumbers);
		
		final double[] doubles = new double[arrayLength(width, height)];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				doubles[realPartIndex(width, row, column)] = complexNumbers[row][column].getReal();
				doubles[imaginaryPartIndex(width, row, column)] = complexNumbers[row][column].getImaginary();
			}
		}
		
		return doubles;
	}

	private static int arrayLength(final int width, final int height) {
		return height * 2 * width;
	}
	
	private static int realPartIndex(final int width, int row, int column) {
		return row * 2 * width + 2 * column;
	}

	private static int imaginaryPartIndex(final int width, int row, int column) {
		return realPartIndex(width, row, column) + 1;
	}

	public static ComplexNumber[][] toComplexNumberArray(final double[] doubles, final int width, final int height) {
		checkArgument(doubles.length == arrayLength(width, height));
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				final double real = doubles[realPartIndex(width, row, column)];
				final double imaginary = doubles[imaginaryPartIndex(width, row, column)];
				complexNumbers[row][column] = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
			}
		}
		
		return complexNumbers;
	}

}