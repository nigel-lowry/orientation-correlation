package uk.co.lemmata.image.oc;

import org.apache.commons.math.complex.Complex;

public interface FourierTransformProvider {

	Complex[][] forwardFft(Complex[][] input);

	Complex[][] backwardFft(Complex[][] input);

}
