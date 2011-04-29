package uk.co.lemmata.image.oc;

public final class MultiDimensionalArrayUtils {
	
	private MultiDimensionalArrayUtils() {}
	
	public static boolean isEmpty(final Object[][] array) {
		return size(array) == 0;
	}
	
	public static int size(final Object[][] array) {
		return height(array) * width(array);
	}

	public static int height(final Object[][] array) {
		return array.length;
	}
	
	public static int width(final Object[][] array) {
		return height(array) == 0 ? 0 : array[0].length;
	}

	public static <T> T atRowColumn(final T[][] array,
			final int row, final int column) {
		return array[row][column];
	}

}
