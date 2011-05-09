package uk.co.lemmata.image.oc;

import static uk.co.lemmata.image.oc.CommonsMathComplexNumberImpl.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class GradientImageProviderTest {

	private GradientImageProvider gradientImageProvider;
	
	@Before
	public void setUp() {
		gradientImageProvider = new SimpleGradientImageProvider();
	}
	
	@Test
	public void test3by3() {
		final Double[][] doubles = {
				{1.0, 2.0, 4.0},
				{8.0, 16.0, 32.0},
				{64.0, 128.0, 256.0}
				};
		
		final ComplexNumber[][] rawComplexNumbers = {
				{realImaginary(1.0, 7.0).signum(), realImaginary(1.5, 14.0).signum(), realImaginary(2.0, 28.0).signum()},
				{realImaginary(8.0, 31.5).signum(), realImaginary(12.0, 63.0).signum(), realImaginary(16.0, 126.0).signum()},
				{realImaginary(64.0, 56.0).signum(), realImaginary(96.0, 112.0).signum(), realImaginary(128.0, 224.0).signum()}
				};	
		
		assertThat(gradientImageProvider.gradientImage(doubles), is(rawComplexNumbers));
	}

}
