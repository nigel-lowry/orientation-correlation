package uk.co.lemmata.image.oc;


import org.junit.Before;
import org.junit.Test;

public class FourierTransformProviderTest {

	private FourierTransformProvider fftProvider;
	
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
}
