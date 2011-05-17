package uk.co.lemmata.image.oc;

import java.io.*;

import javax.media.jai.*;

public interface GrayscaleProvider {

	RenderedOp toGrayscale(File imageFile);

}
