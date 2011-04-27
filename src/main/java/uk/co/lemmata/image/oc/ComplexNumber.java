package uk.co.lemmata.image.oc;

public interface ComplexNumber {

	ComplexNumber signum();

	double getReal();

	double getImaginary();

	double getPhaseInRadians();

	double getMagnitude();

	ComplexNumber conjugate();

}
