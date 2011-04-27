package uk.co.lemmata.image.oc;

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

}
