package uk.co.lemmata.image.oc;


import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class CommonsMathComplexNumberImplTest {
	
	private ComplexNumber complexNumber;
	
	@Before
	public void setUp() throws Exception {
//		complexNumber = new CommonsMathComplexNumberImpl();
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeZeroIsIdentical() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeOneIsIdentical() throws Exception {
		final double square_root_of_two = Math.sqrt(2.0);
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
