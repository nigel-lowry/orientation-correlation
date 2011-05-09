package uk.co.lemmata.image.oc;


import static java.lang.Math.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class CommonsMathComplexNumberImplTest {
	
	private static final double ERROR_DELTA = .0001;
	
	private ComplexNumber complexNumber;
	
	@Test
	public void testCartesianStaticFactory() {
		final double real = 1.0;
		final double imaginary = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		assertThat(complexNumber.getReal(), is(real));
		assertThat(complexNumber.getImaginary(), is(imaginary));
	}
	
	@Test
	public void testPolarStaticFactory() {
		final double thirtyDegreesInRadians = toRadians(30.0);
		final double magnitude = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(thirtyDegreesInRadians, magnitude);
		
		assertThat(complexNumber.getPhaseInRadians(), is(closeTo(thirtyDegreesInRadians, ERROR_DELTA)));
		assertThat(complexNumber.getMagnitude(), is(closeTo(magnitude, ERROR_DELTA)));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeZeroIsIdentical() {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(0.0, 0.0);
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeOneIsIdentical() {
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(PI, 1.0);
		
		assertThat(complexNumber.signum(), is(complexNumber));
	}
	
	@Test
	public void signumOfComplexNumberWithMagnitudeGreaterThanZeroHasMagnitudeOfOneAndSameDirection() {
		final double phaseInRadians = PI;
		
		complexNumber = CommonsMathComplexNumberImpl.phaseInRadiansMagnitude(phaseInRadians, 5.0);
		
		final ComplexNumber signum = complexNumber.signum();
		
		assertThat(signum.getPhaseInRadians(), is(closeTo(phaseInRadians, ERROR_DELTA)));
		assertThat(signum.getMagnitude(), is(closeTo(1.0, ERROR_DELTA)));
	}
	
	@Test
	public void testEquals() {
		final ComplexNumber complex1 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		final ComplexNumber complex2 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		
		assertThat(complex1, is(complex2));
	}
	
	@Test
	public void testNotEquals() {
		final ComplexNumber complex1 = CommonsMathComplexNumberImpl.realImaginary(1.0, 1.0);
		final ComplexNumber complex2 = CommonsMathComplexNumberImpl.realImaginary(2.0, 2.0);
		
		assertThat(complex1, is(not(complex2)));
	}
	
	@Test
	public void testToStringWithPositiveImaginaryPart() {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, 2.0);
		
		assertThat(complexNumber, hasToString(is("1.0 + 2.0i")));
	}
	
	@Test
	public void testToStringWithZeroImaginaryPart() {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, 0.0);
		
		assertThat(complexNumber, hasToString(is("1.0 + 0.0i")));
	}
	
	@Test
	public void testToStringWithNegativeImaginaryPart() {
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(1.0, -2.0);
		
		assertThat(complexNumber, hasToString(is("1.0 - 2.0i")));
	}
	
	@Test
	public void testConjugateFromPositiveToNegative() {
		final double real = 1.0;
		final double imaginary = 2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		final ComplexNumber conjugate = complexNumber.conjugate();
		
		assertThat(conjugate.getReal(), is(real));
		assertThat(conjugate.getImaginary(), is(-imaginary));
	}
	
	@Test
	public void testConjugateFromNegativeToPositive() {
		final double real = 1.0;
		final double imaginary = -2.0;
		
		complexNumber = CommonsMathComplexNumberImpl.realImaginary(real, imaginary);
		
		final ComplexNumber conjugate = complexNumber.conjugate();
		
		assertThat(conjugate.getReal(), is(real));
		assertThat(conjugate.getImaginary(), is(-imaginary));
	}
	
	@Test
	public void testMultiply() {
		final ComplexNumber complexNumberA = CommonsMathComplexNumberImpl.realImaginary(2.0, 3.0);
		final ComplexNumber complexNumberB = CommonsMathComplexNumberImpl.realImaginary(4.0, 7.0);
		final ComplexNumber expectedProduct = CommonsMathComplexNumberImpl.realImaginary(-13.0, 26.0);
		
		assertThat(complexNumberA.multiply(complexNumberB), is(expectedProduct));
	}
	
	@Test
	public void testSquare() {
		final ComplexNumber i = CommonsMathComplexNumberImpl.realImaginary(0.0, 1);
		assertThat(i.square().getReal(), is(closeTo(-1.0, ERROR_DELTA)));
		assertThat(i.square().getImaginary(), is(closeTo(0.0, ERROR_DELTA)));
	}

}
