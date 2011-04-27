package uk.co.lemmata.image.oc;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class CommonsMathComplexNumberImpl implements ComplexNumber {

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
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
}
