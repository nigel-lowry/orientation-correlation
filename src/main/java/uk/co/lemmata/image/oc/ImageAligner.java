package uk.co.lemmata.image.oc;

import java.awt.geom.AffineTransform;
import java.io.File;

public interface ImageAligner {

	AffineTransform multiModal(File imageFile1, File imageFile2);

}
