package uk.co.lemmata.image.oc;

import static java.lang.Math.*;

import org.apache.commons.lang.builder.*;
import org.apache.commons.math.complex.*;

public final class CommonsMathComplexNumberImpl implements ComplexNumber {

	private static final char IMAGINARY_UNIT_SYMBOL = 'i';
	
	private final Complex complex;
	
	public static ComplexNumber realImaginary(final double real, final double imaginary) {
		return new CommonsMathComplexNumberImpl(new Complex(real, imaginary));
	}
	
	private CommonsMathComplexNumberImpl(final Complex complex) {
		this.complex = complex;
	}
	
	public static ComplexNumber phaseInRadiansMagnitude(final double phaseInRadians, final double magnitude) {
		return new CommonsMathComplexNumberImpl(new Complex(magnitude * cos(phaseInRadians), magnitude * sin(phaseInRadians)));
	}

	@Override
	public ComplexNumber signum() {
		return this; // TODO
	}

	@Override
	public String toString() {
		return getReal() + " " + sign(getImaginary()) + " " + abs(getImaginary()) + IMAGINARY_UNIT_SYMBOL;
	}
	
	private String sign(final double d) {
		return d < 0.0 ? "-" : "+";
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public double getReal() {
		return complex.getReal();
	}

	@Override
	public double getImaginary() {
		return complex.getImaginary();
	}

	@Override
	public double getPhaseInRadians() {
		return complex.getArgument();
	}

	@Override
	public double getMagnitude() {
		return complex.abs();
	}
	
}
