package uk.co.lemmata.image.oc;


public interface FourierTransformProvider {

	ComplexNumber[][] forwardFft(ComplexNumber[][] complexNumbers);

	ComplexNumber[][] backwardFft(ComplexNumber[][] complexNumbers);

}
