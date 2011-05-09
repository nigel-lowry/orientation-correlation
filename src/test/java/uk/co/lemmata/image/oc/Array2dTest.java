package uk.co.lemmata.image.oc;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class Array2dTest {
	
	private static final Double[][] values = {
			{1.0, 2.0, 3.0},
			{4.0, 5.0, 6.0},
			{7.0, 8.0, 9.0}};
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test(expected=NullPointerException.class)
	public void rejectsNullArray() throws Exception {
		new Array2d<Double>(null);
	}

	@Test
	public void testGet() throws Exception {
		final Array2d<Double> array = new Array2d<Double>(values);
		
		assertThat(array.getRowColumn(0, 0), is(1.0));
		assertThat(array.getRowColumn(1, 1), is(5.0));
		assertThat(array.getRowColumn(2, 2), is(9.0));
	}
	
}
