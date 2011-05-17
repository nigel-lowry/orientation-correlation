package uk.co.lemmata.image.oc;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.*;

import javax.media.jai.*;

import org.junit.*;

public class RawGradientImageProviderTest {

	private RawGradientImageProvider provider;
	
	private RenderedOp renderedOp = null;
	
	@Before
	public void setUp() throws Exception {
		provider = new JaiRawGradientImageProvider();
		renderedOp = new JaiGrayscaleProvider().toGrayscale(new File("src/test/resources/colour.jpg"));
	}
	
	@Test
	public void testResultHasTwoBands() throws Exception {
		final RenderedOp complexImage = provider.getRawGradient(renderedOp);
		
		assertThat(complexImage.getNumBands(), is(2));
	}
	
	@Test
	public void convolvedImageHasSameDimensions() throws Exception {
		final RenderedOp complexImage = provider.getRawGradient(renderedOp);
		
		assertThat(complexImage.getWidth(), is(renderedOp.getWidth()));
		assertThat(complexImage.getHeight(), is(renderedOp.getHeight()));
	}

}
