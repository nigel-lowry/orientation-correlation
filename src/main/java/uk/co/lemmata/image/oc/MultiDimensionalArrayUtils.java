package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;

import java.awt.*;

public final class MultiDimensionalArrayUtils {
	
	private MultiDimensionalArrayUtils() {}
	
	public static boolean isEmpty(final Object[][] array) {
		return size(array) == 0;
	}
	
	public static int size(final Object[][] array) {
		return height(array) * width(array);
	}

	public static int height(final Object[][] array) {
		return array.length;
	}
	
	public static int width(final Object[][] array) {
		return zeroIfHeightIsZeroElseReturnWidth(array);
	}

	private static int zeroIfHeightIsZeroElseReturnWidth(
			final Object[][] array) {
		return height(array) == 0 ? 0 : array[0].length;
	}

	public static <T> T atRowColumn(final T[][] array,
			final int row, final int column) {
		checkPositionIndex(row, height(array));
		checkPositionIndex(column, width(array));
		
		return array[row][column];
	}

	public static ComplexNumber[][] multiply(final ComplexNumber[][] array1,
			final ComplexNumber[][] array2) {
		checkArgument(getDimensions(array1).equals(getDimensions(array2)));
		
		final int height = height(array1);
		final int width = width(array1);
		final ComplexNumber product[][] = new ComplexNumber[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				product[row][column] = array1[row][column].multiply(array2[row][column]);
			}
		}
		
		return product;
	}
	
	private static Dimension getDimensions(final Object[][] array) {
		return new Dimension(width(array), height(array));
	}

	public static ComplexNumber[][] conjugate(final ComplexNumber[][] array) {
		final int height = height(array);
		final int width = width(array);
		final ComplexNumber[][] conjugates = new ComplexNumber[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				conjugates[row][column] = array[row][column].conjugate();
			}
		}
		
		return conjugates;
	}

	public static Double[][] toWrappers(final double[][] primitives) {
		final int height = primitives.length; // TODO need methods for these
		final int width = primitives[0].length;
		final Double[][] wrappers = new Double[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				wrappers[row][column] = primitives[row][column];
			}
		}
		
		return wrappers;
	}

	public static double get(final double[][] array, final int row, final int column) {
		return array[row][column];
	}

}
