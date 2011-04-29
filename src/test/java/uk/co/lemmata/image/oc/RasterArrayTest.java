package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RasterArrayTest {

	private static final ComplexNumber COMPLEX_00 = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
	private static final ComplexNumber COMPLEX_01 = CommonsMathComplexNumberImpl.realImaginary(0.0, 1.0);

	private RasterArray rasterArray;
	
	@Test(expected=NullPointerException.class)
	public void shouldRejectNullArray() throws Exception {
		new RasterArray(null);
	}
	
	@Test
	public void shouldKeepDimensions() throws Exception {
		final int height = 2;
		final int width = 3;
		final ComplexNumber[][] complex2dArray = new ComplexNumber[height][width];
		
		rasterArray = new RasterArray(complex2dArray);
		
		assertThat(rasterArray.getHeight(), is(height));
		assertThat(rasterArray.getWidth(), is(width));
		assertThat(rasterArray.pixelCount(), is(6));
	}
	
	@Test
	public void testAtRowColumn() throws Exception {
		final ComplexNumber[][] complex2dArray = new ComplexNumber[1][2];
		
		complex2dArray[0][0] = COMPLEX_00;
		complex2dArray[0][1] = COMPLEX_01;
		
		rasterArray = new RasterArray(complex2dArray);
		
		assertThat(rasterArray.atRowColumn(0, 0), is(COMPLEX_00));
		assertThat(rasterArray.atRowColumn(0, 1), is(COMPLEX_01));
	}
	
	@Test
	public void testToJTransformArray() throws Exception {
		final ComplexNumber[][] complex2dArray = new ComplexNumber[1][2];
		
		complex2dArray[0][0] = CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0);
		complex2dArray[0][1] = CommonsMathComplexNumberImpl.realImaginary(3.0, 4.0);
		
		rasterArray = new RasterArray(complex2dArray);
		
		final double doubles[][] = rasterArray.to2dDoubleArray(); 
		
		assertThat(doubles[0][0], is(1.0));
		assertThat(doubles[0][1], is(2.0));
		assertThat(doubles[0][2], is(3.0));
		assertThat(doubles[0][3], is(4.0));
	}

}
