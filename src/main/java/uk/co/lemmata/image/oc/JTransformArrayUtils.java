package uk.co.lemmata.image.oc;


public final class JTransformArrayUtils {
	
	private JTransformArrayUtils() {}

	public static double[][] toDoubleArray(final ComplexNumber[][] complexNumbers) {
		final int height = MultiDimensionalArrayUtils.height(complexNumbers);
		final int width = MultiDimensionalArrayUtils.width(complexNumbers);
		
		final double[][] doubles = new double[height][2 * width];
		
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

	public static ComplexNumber[][] toComplexNumberArray(final Double[][] doubles) {
		final int height = MultiDimensionalArrayUtils.height(doubles);
		final int width = MultiDimensionalArrayUtils.width(doubles);
		
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