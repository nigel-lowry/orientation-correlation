package uk.co.lemmata.image.oc;

import java.awt.image.*;
import java.io.*;

import javax.media.jai.*;

public interface GrayscaleProvider {

	RenderedOp toGrayscale(File imageFile);

}
