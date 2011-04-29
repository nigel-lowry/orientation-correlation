package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class JTransformArrayUtilsTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldRejectNullComplexArray() throws Exception {
		JTransformArrayUtils.toDoubleArray(null);
	}
	
	@Test
	public void testToDoubleArray() throws Exception {
		final ComplexNumber[][] complexNumbers = new ComplexNumber[1][2];
		
		complexNumbers[0][0] = CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0);
		complexNumbers[0][1] = CommonsMathComplexNumberImpl.realImaginary(3.0, 4.0);
		
		final double doubles[] = JTransformArrayUtils.toDoubleArray(complexNumbers);
		
		assertThat(doubles[0], is(1.0));
		assertThat(doubles[1], is(2.0));
		assertThat(doubles[2], is(3.0));
		assertThat(doubles[3], is(4.0));
	}
	
	@Test
	public void testToComplexNumberArray() throws Exception {
		final double[] doubles = {1.0, 2.0, 3.0, 4.0};
		final ComplexNumber complexNumbers[][] = JTransformArrayUtils.toComplexNumberArray(doubles, 2, 1);
		
		assertThat(complexNumbers[0][0], is(CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0)));
		assertThat(complexNumbers[0][1], is(CommonsMathComplexNumberImpl.realImaginary(3.0, 4.0)));
	}

}
