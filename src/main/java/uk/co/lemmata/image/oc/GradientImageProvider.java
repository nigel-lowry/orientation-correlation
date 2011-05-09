package uk.co.lemmata.image.oc;

public interface GradientImageProvider {

	ComplexNumber[][] gradientImage(Double[][] intensity);
	
	ComplexNumber[][] squaredGradientImage(Double[][] intensity);

}
