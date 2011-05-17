package uk.co.lemmata.image.oc;

import java.awt.image.renderable.*;

import javax.media.jai.*;

public class JaiRawGradientImageProvider implements RawGradientImageProvider {
	
	private static final float[] kernelData = {-1.0f, 0.0f, 1.0f};
	private static final KernelJAI dx = new KernelJAI(3, 1, kernelData);
	private static final KernelJAI dy = new KernelJAI(1, 3, kernelData);

	@Override
	public RenderedOp getRawGradient(RenderedOp renderedOp) {
		final RenderedOp x = JAI.create("convolve", renderedOp, dx);
		final RenderedOp y = JAI.create("convolve", renderedOp, dy);
		
		// TODO not sure what this does with edge pixels
		
		final ParameterBlock pb = new ParameterBlock();
		pb.addSource(x);
		pb.addSource(y);
		
		return JAI.create("bandmerge", pb);
	}

}
