package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class JTransformArrayUtilsTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldRejectNullComplexArray() {
		JTransformArrayUtils.toDoubleArray(null);
	}
	
	@Test
	public void testToDoubleArray() {
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
	public void testToComplexNumberArray() {
		final double[] doubles = {1.0, 2.0, 3.0, 4.0};
		final ComplexNumber complexNumbers[][] = JTransformArrayUtils.toComplexNumberArray(doubles, 2, 1);
		
		assertThat(complexNumbers[0][0], is(CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0)));
		assertThat(complexNumbers[0][1], is(CommonsMathComplexNumberImpl.realImaginary(3.0, 4.0)));
	}

}
