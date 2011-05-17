package uk.co.lemmata.image.oc;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.io.*;

import javax.media.jai.*;

import org.junit.*;

public class GrayscaleProviderTest {
	
	private static final File colorImageFile = new File("src/test/resources/colour.jpg");
	private GrayscaleProvider provider;

	@Before
	public void setUp() throws Exception {
		provider = new JaiGrayscaleProvider();
	}
	
	@Test
	public void resultingImageHasOneColorBand() throws Exception {
		final RenderedOp grayscaleImage = provider.toGrayscale(colorImageFile);
		
		assertThat(grayscaleImage.getNumBands(), is(1));
	}

}
