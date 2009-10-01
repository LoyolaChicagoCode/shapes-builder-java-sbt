package shapes.impl.composite;

import shapes.common.Visitor;

class Circle implements shapes.common.Circle {

	protected final int radius;

	public Circle(int radius) {
		if (radius < 0)
			throw new IllegalArgumentException("radius < 0");
		this.radius = radius;
	}
	
	@Override
	public int getRadius() {
		return radius;
	}
	
	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.visitCircle(this);
	}
}
