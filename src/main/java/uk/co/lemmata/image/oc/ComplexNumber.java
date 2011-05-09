package uk.co.lemmata.image.oc;

interface ComplexNumber {

	ComplexNumber square();
	
	ComplexNumber signum();

	double getReal();

	double getImaginary();

	double getPhaseInRadians();

	double getMagnitude();

	ComplexNumber conjugate();

	ComplexNumber multiply(ComplexNumber other);

}
