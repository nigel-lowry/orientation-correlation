package uk.co.lemmata.image.oc;

import static com.google.common.base.Preconditions.*;

public class Array2d<E> {
	
	private final E[][] values;

	public Array2d(E[][] values) {
		this.values = checkNotNull(values);
		// TODO Auto-generated constructor stub
	}

	public E getRowColumn(final int row, final int column) {
		return values[row][column];
	}

}
