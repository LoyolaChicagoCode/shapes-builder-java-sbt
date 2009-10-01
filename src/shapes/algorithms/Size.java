package shapes.algorithms;

import shapes.common.Shape;
import shapes.common.Circle;
import shapes.common.Filled;
import shapes.common.Group;
import shapes.common.Location;
import shapes.common.Outline;
import shapes.common.Polygon;
import shapes.common.Rectangle;
import shapes.common.Stroke;
import shapes.common.Visitor;

/**
 * A visitor to compute the number of
 * basic shapes in a (possibly complex) shape.
 */
public class Size implements Visitor<Integer> {

	// TODO entirely your job

	@Override
	public Integer visitPolygon(final Polygon p) {
		return -1;
	}

	@Override
	public Integer visitCircle(final Circle c) {
		return -1;
	}

	@Override
	public Integer visitGroup(final Group g) {
		return -1;
	}

	@Override
	public Integer visitRectangle(final Rectangle q) {
		return -1;
	}

	@Override
	public Integer visitOutline(final Outline o) {
		return -1;
	}

	@Override
	public Integer visitFilled(final Filled c) {
		return -1;
	}

	@Override
	public Integer visitLocation(final Location l) {
		return -1;
	}

	@Override
	public Integer visitStroke(final Stroke c) {
		return -1;
	}
}
