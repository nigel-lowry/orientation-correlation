package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.MultiDimensionalArrayUtils.*;

public class SimpleGradientImageProvider implements GradientImageProvider {

	@Override
	public ComplexNumber[][] gradientImage(final Double[][] intensity) {
		final double[][] real = real(intensity);
		final double[][] imag = imaginary(intensity);
		
		final int height = height(intensity);
		final int width = width(intensity);
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				complexNumbers[row][column] = CommonsMathComplexNumberImpl.realImaginary(real[row][column], imag[row][column]).signum();
			}
		}
		
		return complexNumbers;
	}
	
	private double[][] real(final Double[][] intensity) {
		final int height = height(intensity);
		final int width = width(intensity);
		
		final double[][] reals = new double[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (column == 0) {
					reals[row][column] = intensity[row][column + 1] - intensity[row][column];
				} else if (column == width - 1) {
					reals[row][column] = intensity[row][column] - intensity[row][column - 1];
				} else {
					reals[row][column] = (intensity[row][column + 1] - intensity[row][column - 1]) / 2.0; 
				}
			}
		}
		
		return reals;
	}
	
	private double[][] imaginary(final Double[][] intensity) {
		final int height = height(intensity);
		final int width = width(intensity);
		
		final double[][] imaginaries = new double[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (row == 0) {
					imaginaries[row][column] = intensity[row + 1][column] - intensity[row][column];
				} else if (row == height - 1) {
					imaginaries[row][column] = intensity[row][column] - intensity[row - 1][column];
				} else {
					imaginaries[row][column] = (intensity[row + 1][column] - intensity[row - 1][column]) / 2.0; 
				}
			}
		}
		
		return imaginaries;
	}

	@Override
	public ComplexNumber[][] squaredGradientImage(Double[][] intensity) {
		final ComplexNumber[][] gradientImage = gradientImage(intensity);
		final int height = height(intensity);
		final int width = width(intensity);
		
		final ComplexNumber[][] squared = new ComplexNumber[height][width];
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				squared[row][column] = gradientImage[row][column].square();
			}
		}
		
		return squared;
	}

}
