package uk.co.lemmata.image.oc;


public interface FourierTransformProvider {

	ComplexNumber[][] forwardFft(ComplexNumber[][] input);

	ComplexNumber[][] backwardFft(ComplexNumber[][] input);

}
