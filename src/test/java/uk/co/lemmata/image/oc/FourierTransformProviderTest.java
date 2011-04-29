package uk.co.lemmata.image.oc;


import org.junit.Before;
import org.junit.Test;

public class FourierTransformProviderTest {

	private FourierTransformProvider fftProvider;
	private ComplexNumber[][] complexNumbers;
	
	@Before
	public void setUp() throws Exception {
		fftProvider = new JTransformsFftProvider();
	}
	
	@Test(expected=NullPointerException.class)
	public void rejectsNullArrayForForwardFft() throws Exception {
		fftProvider.forwardFft(null);
	}

	@Test(expected=NullPointerException.class)
	public void rejectsNullArrayForBackwardFft() throws Exception {
		fftProvider.backwardFft(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void rejectsEmptyArrayForForwardsFft() throws Exception {
		complexNumbers = new ComplexNumber[0][0];
		
		fftProvider.forwardFft(complexNumbers);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void rejectsEmptyArrayForBackwardsFft() throws Exception {
		complexNumbers = new ComplexNumber[0][0];
		
		fftProvider.backwardFft(complexNumbers);
	}
}
