package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class MultiDimensionalArrayUtilsTest {
	
	private static final ComplexNumber COMPLEX_00 = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
	private static final ComplexNumber COMPLEX_01 = CommonsMathComplexNumberImpl.realImaginary(0.0, 1.0);
	
	@Test
	public void testWidth() throws Exception {
		final int height = 2;
		final int width = 3;
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width]; 
		
		assertThat(MultiDimensionalArrayUtils.width(complexNumbers), is(width));
	}
	
	@Test
	public void testHeight() throws Exception {
		final int height = 2;
		final int width = 3;
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width]; 
		
		assertThat(MultiDimensionalArrayUtils.height(complexNumbers), is(height));
	}
	
	@Test
	public void testSizeZero() throws Exception {
		final ComplexNumber[][] complexNumbers = new ComplexNumber[0][0];
		
		assertThat(MultiDimensionalArrayUtils.size(complexNumbers), is(0));
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		final ComplexNumber[][] complexNumbers = new ComplexNumber[0][0];
		
		assertThat(MultiDimensionalArrayUtils.isEmpty(complexNumbers), is(true));
	}
	
	@Test
	public void testNotEmpty() throws Exception {
		final ComplexNumber[][] complexNumbers = new ComplexNumber[1][1];
		
		assertThat(MultiDimensionalArrayUtils.isEmpty(complexNumbers), is(false));
	}
	
	@Test
	public void testSize() throws Exception {
		final int height = 2;
		final int width = 3;
		
		final ComplexNumber[][] complexNumbers = new ComplexNumber[height][width];
		
		assertThat(MultiDimensionalArrayUtils.size(complexNumbers), is(6));
	}
	
	@Test
	public void testAt() throws Exception {
		final ComplexNumber[][] complex2dArray = new ComplexNumber[1][2];
		
		complex2dArray[0][0] = COMPLEX_00;
		complex2dArray[0][1] = COMPLEX_01;
		
		assertThat(MultiDimensionalArrayUtils.atRowColumn(complex2dArray, 0, 0), is(COMPLEX_00));
		assertThat(MultiDimensionalArrayUtils.atRowColumn(complex2dArray, 0, 1), is(COMPLEX_01));
	}

}
