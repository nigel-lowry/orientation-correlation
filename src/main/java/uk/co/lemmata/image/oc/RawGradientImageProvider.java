package uk.co.lemmata.image.oc;

import javax.media.jai.*;

public interface RawGradientImageProvider {

	RenderedOp getRawGradient(RenderedOp renderedOp);

}
