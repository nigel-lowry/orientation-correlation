package uk.co.lemmata.image.oc;

import java.io.File;
import java.io.IOException;

public interface ImageToArrayConverter {

	Double[][] toIntensityArray(File file) throws IOException;

}
