package uk.co.lemmata.image.oc;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static java.lang.Math.*;

import org.junit.*;

public class CommonsMathComplexNumberImplTest {
	
	private ComplexNumber complexNumber;
	
	@Test
	public void signumOfComplexNumberWithMagnitudeZeroIsIdentical() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeOneIsIdentical() throws Exception {
		final double square_root_of_two = sqrt(2.0);
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(square_root_of_two, square_root_of_two);
		
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void testEquals() throws Exception {
		final ComplexNumber complex1 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		final ComplexNumber complex2 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		
		assertThat(complex1, is(complex2));
	}
	
	@Test
	public void testNotEquals() throws Exception {
		final ComplexNumber complex1 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		final ComplexNumber complex2 = CommonsMathComplexNumberImpl.realImaginary(2.0, 2.0);
		
		assertThat(complex1, is(not(complex2)));
	}
	
	@Test
	public void testToStringWithPositiveImaginaryPart() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0);
		
		assertThat(complexNumber, hasToString(is("1.0 + 2.0i")));
	}
	
	@Test
	public void testToStringWithZeroImaginaryPart() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, 0.0);
		
		assertThat(complexNumber, hasToString(is("1.0 + 0.0i")));
	}
	
	@Test
	public void testToStringWithNegativeImaginaryPart() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, -2.0);
		
		assertThat(complexNumber, hasToString(is("1.0 - 2.0i")));
	}

}
