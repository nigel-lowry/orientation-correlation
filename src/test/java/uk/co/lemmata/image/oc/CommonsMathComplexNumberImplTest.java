package uk.co.lemmata.image.oc;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static java.lang.Math.*;

import org.junit.*;

public class CommonsMathComplexNumberImplTest {
	
	private static final double ERROR_DELTA = .0001;
	
	private ComplexNumber complexNumber;
	
	@Test
	public void testCartesianStaticFactory() throws Exception {
		final double real = 1.0;
		final double imaginary = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		assertThat(complexNumber.getReal(), is(real));
		assertThat(complexNumber.getImaginary(), is(imaginary));
	}
	
	@Test
	public void testPolarStaticFactory() throws Exception {
		final double thirtyDegreesInRadians = toRadians(30.0);
		final double magnitude = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(thirtyDegreesInRadians, magnitude);
		
		assertThat(complexNumber.getPhaseInRadians(), is(closeTo(thirtyDegreesInRadians, ERROR_DELTA)));
		assertThat(complexNumber.getMagnitude(), is(closeTo(magnitude, ERROR_DELTA)));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeZeroIsIdentical() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeOneIsIdentical() throws Exception {
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(PI, 1.0);
		
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeGreaterThanZeroHasMagnitudeOfOneAndSameDirection() throws Exception {
		final double phaseInRadians = PI;
		
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(phaseInRadians, 5.0);
		
		final ComplexNumber signum = complexNumber.signum();
		
		assertThat(signum.getPhaseInRadians(), is(closeTo(phaseInRadians, ERROR_DELTA)));
		assertThat(signum.getMagnitude(), is(closeTo(1.0, ERROR_DELTA)));
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
	
	@Test
	public void testConjugateFromPositiveToNegative() throws Exception {
		final double real = 1.0;
		final double imaginary = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		final ComplexNumber conjugate = complexNumber.conjugate();
		
		assertThat(conjugate.getReal(), is(real));
		assertThat(conjugate.getImaginary(), is(-imaginary));
	}
	
	@Test
	public void testConjugateFromNegativeToPositive() throws Exception {
		final double real = 1.0;
		final double imaginary = -2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		final ComplexNumber conjugate = complexNumber.conjugate();
		
		assertThat(conjugate.getReal(), is(real));
		assertThat(conjugate.getImaginary(), is(-imaginary));
	}
	
	@Test
	public void testMultiply() throws Exception {
		final ComplexNumber complexNumberA = CommonsMathComplexNumberImpl.realImaginary(2.0, 3.0);
		final ComplexNumber complexNumberB = CommonsMathComplexNumberImpl.realImaginary(4.0, 7.0);
		final ComplexNumber expectedProduct = CommonsMathComplexNumberImpl.realImaginary(-13.0, 26.0);
		
		assertThat(complexNumberA.multiply(complexNumberB), is(expectedProduct));
	}

}
