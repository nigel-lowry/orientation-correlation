package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;


public class MultiDimensionalArrayUtilsTest {
	
	private static final ComplexNumber COMPLEX_00 = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
	private static final ComplexNumber COMPLEX_01 = CommonsMathComplexNumberImpl.realImaginary(0.0, 1.0);
	
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

}
