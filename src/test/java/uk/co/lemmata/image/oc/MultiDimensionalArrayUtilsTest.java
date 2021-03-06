package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;


public class MultiDimensionalArrayUtilsTest {
	
	private static final ComplexNumber COMPLEX_00 = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
	private static final ComplexNumber COMPLEX_01 = CommonsMathComplexNumberImpl.realImaginary(0.0, 1.0);
	private static final ComplexNumber COMPLEX_02 = CommonsMathComplexNumberImpl.realImaginary(0.0, 2.0);
	private static final ComplexNumber COMPLEX_03 = CommonsMathComplexNumberImpl.realImaginary(0.0, 3.0);
	
	@Test
	public void testWidth() {
		final int height = 2;
		final int width = 3;
		
		assertThat(MultiDimensionalArrayUtils.width(new ComplexNumber[height][width]), is(width));
	}
	
	@Test
	public void testHeight() {
		final int height = 2;
		final int width = 3;
		
		assertThat(MultiDimensionalArrayUtils.height(new ComplexNumber[height][width]), is(height));
	}
	
	@Test
	public void testSizeZero() {
		assertThat(MultiDimensionalArrayUtils.size(new ComplexNumber[0][0]), is(0));
	}
	
	@Test
	public void testIsEmpty() {
		assertThat(MultiDimensionalArrayUtils.isEmpty(new ComplexNumber[0][0]), is(true));
	}
	
	@Test
	public void testWhenHeightIsZeroCannotGetWidthAccuratelySoReturnZero() {
		final int height = 0;
		final int width = 5;
		final ComplexNumber[][] array = new ComplexNumber[height][width];
		
		assertThat(MultiDimensionalArrayUtils.width(array), is(0));
		assertThat(MultiDimensionalArrayUtils.height(array), is(0));
		assertThat(MultiDimensionalArrayUtils.size(array), is(0));
	}
	
	@Test
	public void testWhenWidthIsZero() {
		final int height = 5;
		final int width = 0;
		final ComplexNumber[][] array = new ComplexNumber[height][width];
		
		assertThat(MultiDimensionalArrayUtils.width(array), is(width));
		assertThat(MultiDimensionalArrayUtils.height(array), is(height));
		assertThat(MultiDimensionalArrayUtils.size(array), is(0));
	}
	
	@Test
	public void testNotEmpty() {
		assertThat(MultiDimensionalArrayUtils.isEmpty(new ComplexNumber[1][1]), is(false));
	}
	
	@Test
	public void testSize() {
		final int height = 2;
		final int width = 3;
		
		assertThat(MultiDimensionalArrayUtils.size(new ComplexNumber[height][width]), is(6));
	}
	
	@Test
	public void testAt() {
		final ComplexNumber[][] array = new ComplexNumber[1][2];
		
		array[0][0] = COMPLEX_00;
		array[0][1] = COMPLEX_01;
		
		assertThat(MultiDimensionalArrayUtils.atRowColumn(array, 0, 0), is(COMPLEX_00));
		assertThat(MultiDimensionalArrayUtils.atRowColumn(array, 0, 1), is(COMPLEX_01));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAtNegative() {
		final ComplexNumber[][] array = new ComplexNumber[1][2];
		
		array[0][0] = COMPLEX_00;
		array[0][1] = COMPLEX_01;
		
		MultiDimensionalArrayUtils.atRowColumn(array, -1, -1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAtOutside() {
		final ComplexNumber[][] array = new ComplexNumber[1][2];
		
		array[0][0] = COMPLEX_00;
		array[0][1] = COMPLEX_01;
		
		MultiDimensionalArrayUtils.atRowColumn(array, 1, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void multiplyRejectsDifferentDimensions() {
		final ComplexNumber[][] array1 = new ComplexNumber[1][2];
		final ComplexNumber[][] array2 = new ComplexNumber[2][1];
		
		MultiDimensionalArrayUtils.multiply(array1, array2);
	}
	
	@Test
	public void multiplyOkayWhenGotSameDimensions() {
		final ComplexNumber[][] array1 = new ComplexNumber[1][2];
		final ComplexNumber[][] array2 = new ComplexNumber[1][2];
		
		array1[0][0] = COMPLEX_00;
		array1[0][1] = COMPLEX_01;
		
		array2[0][0] = COMPLEX_02;
		array2[0][1] = COMPLEX_03;
		
		final ComplexNumber[][] product = MultiDimensionalArrayUtils.multiply(array1, array2);
		
		assertThat(MultiDimensionalArrayUtils.atRowColumn(product, 0, 0), is(COMPLEX_00.multiply(COMPLEX_02)));
		assertThat(MultiDimensionalArrayUtils.atRowColumn(product, 0, 1), is(COMPLEX_01.multiply(COMPLEX_03)));
	}
	
	@Test
	public void toConjugateArray() {
		final ComplexNumber[][] array = new ComplexNumber[1][2];
		
		array[0][0] = COMPLEX_00;
		array[0][1] = COMPLEX_01;
		
		final ComplexNumber[][] conjugates = MultiDimensionalArrayUtils.conjugate(array);
		
		assertThat(MultiDimensionalArrayUtils.atRowColumn(conjugates, 0, 0), is(COMPLEX_00.conjugate()));
		assertThat(MultiDimensionalArrayUtils.atRowColumn(conjugates, 0, 1), is(COMPLEX_01.conjugate()));
	}
	
	@Test
	public void toPrimitives() {
		final double[][] primitives = {{1.0, 2.0}};
		final Double[][] wrappers = {{1.0, 2.0}};
		
		assertThat(MultiDimensionalArrayUtils.toWrappers(primitives), is(wrappers));
	}
	
	@Test
	public void testGet() {
		final double double00 = 1.0;
		final double double01 = 2.0;
		final double[][] primitives = {{double00, double01}};
		
		assertThat(MultiDimensionalArrayUtils.get(primitives, 0, 0), is(double00));
		assertThat(MultiDimensionalArrayUtils.get(primitives, 0, 1), is(double01));
	}

}
