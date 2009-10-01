package shapes.impl.composite;

import shapes.common.Point;

/**
 * A point, implemented as a location
 * without a shape.
 */
class DefaultPoint extends Location implements Point {
	
	// TODO your job
	// HINT: use a circle with radius 0 as the shape!
	
	public DefaultPoint(final int x, final int y) {
		super(-1, -1, null);
		
	}
}
