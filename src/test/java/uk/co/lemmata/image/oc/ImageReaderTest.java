package uk.co.lemmata.image.oc;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class ImageReaderTest {

	private ImageToArrayConverter converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new ImageIoArrayConverter();
	}
	
	@Test(expected=NullPointerException.class)
	public void rejectsNullFile() throws Exception {
		converter.toIntensityArray(null);
	}
	
	@Test
	public void testname() throws Exception {
		final Double[][] array = converter.toIntensityArray(new File("src/test/resources/brightfield.gif"));
		
		assertThat(MultiDimensionalArrayUtils.width(array), is(768));
		assertThat(MultiDimensionalArrayUtils.height(array), is(512));
	}

}
