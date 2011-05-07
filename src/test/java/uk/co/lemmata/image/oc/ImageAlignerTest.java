package uk.co.lemmata.image.oc;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.awt.geom.AffineTransform;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class ImageAlignerTest {
	
	private ImageAligner aligner;

	@Before
	public void setUp() throws Exception {
		aligner = new OrientationCorrelationImageAligner();
	}
	
	@Test
	public void testMultimodalRegistration() throws Exception {
		assertThat(aligner.multiModal(new File("src/test/resources/brightfield.gif"), new File("src/test/resources/phasecontrast.gif")), is(AffineTransform.getTranslateInstance(100, 200)));
	}

}
