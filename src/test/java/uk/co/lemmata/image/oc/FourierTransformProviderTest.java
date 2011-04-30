package uk.co.lemmata.image.oc;


import org.junit.*;

public class FourierTransformProviderTest {

	private FourierTransformProvider fftProvider;
	private ComplexNumber[][] complexNumbers;
	
	@Before
	public void setUp() {
		fftProvider = new JTransformsFftProvider();
	}
	
	@Test(expected=NullPointerException.class)
	public void rejectsNullArrayForForwardFft() {
		fftProvider.forwardFft(null);
	}

	@Test(expected=NullPointerException.class)
	public void rejectsNullArrayForBackwardFft() {
		fftProvider.backwardFft(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void rejectsEmptyArrayForForwardsFft() {
		complexNumbers = new ComplexNumber[0][0];
		
		fftProvider.forwardFft(complexNumbers);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void rejectsEmptyArrayForBackwardsFft() {
		complexNumbers = new ComplexNumber[0][0];
		
		fftProvider.backwardFft(complexNumbers);
	}
}
