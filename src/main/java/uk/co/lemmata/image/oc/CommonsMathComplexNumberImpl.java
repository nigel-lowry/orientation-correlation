package uk.co.lemmata.image.oc;

import static java.lang.Math.*;

import org.apache.commons.lang.builder.*;

public final class CommonsMathComplexNumberImpl implements ComplexNumber {

	private static final char IMAGINARY_UNIT_SYMBOL = 'i';
	
	private final double real;
	private final double imaginary;

	public static ComplexNumber realImaginary(final double real, final double imaginary) {
		return new CommonsMathComplexNumberImpl(real, imaginary);
	}
	
	private CommonsMathComplexNumberImpl(final double real, final double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	@Override
	public ComplexNumber signum() {
		return this;
	}

	@Override
	public String toString() {
		return real + " " + sign(imaginary) + " " + abs(imaginary) + IMAGINARY_UNIT_SYMBOL;
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
	
}
