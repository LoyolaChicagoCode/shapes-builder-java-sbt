package shapes.impl.composite;

import shapes.common.Shape;
import shapes.common.Visitor;

class Filled implements shapes.common.Filled {

	protected final Shape shape;
	
	public Filled(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public Shape getChild() {
		return shape;
	}
	
	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.visitFilled(this);
	}
}
