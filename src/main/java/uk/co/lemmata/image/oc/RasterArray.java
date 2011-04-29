package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;

public class RasterArray {
	
	private final ComplexNumber[][] complex2dArray;

	public RasterArray(final ComplexNumber[][] complex2dArray2) {
		this.complex2dArray = checkNotNull(complex2dArray2);
	}

	public int getHeight() {
		return complex2dArray.length;
	}

	public int getWidth() {
		return complex2dArray[0].length;
	}

	public ComplexNumber atRowColumn(final int row, final int column) {
		return complex2dArray[row][column];
	}

	public double[][] to2dDoubleArray() {
		final double[][] doubles = new double[getHeight()][2 * getWidth()];
		
		for (int row = 0; row < getHeight(); row++) {
			for (int column = 0; column < getWidth(); column++) {
				doubles[row][2 * column] = complex2dArray[row][column].getReal();
				doubles[row][2 * column + 1] = complex2dArray[row][column].getImaginary();
			}
		}
		
		return doubles;
	}

}