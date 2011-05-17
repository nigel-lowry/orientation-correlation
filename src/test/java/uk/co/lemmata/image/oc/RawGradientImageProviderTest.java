package uk.co.lemmata.image.oc;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import javax.media.jai.*;

import org.junit.*;

public class RawGradientImageProviderTest {

	private RawGradientImageProvider provider;
	
	private RenderedOp renderedOp = null;
	
	@Before
	public void setUp() throws Exception {
		provider = new JaiRawGradientImageProvider();
	}
	
	@Test
	public void testResultHasTwoBands() throws Exception {
		final RenderedOp complexImage = provider.getRawGradient(renderedOp);
		
		assertThat(complexImage.getNumBands(), is(2));
	}

}
