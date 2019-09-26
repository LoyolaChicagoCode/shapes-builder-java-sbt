package shapes.impl.composite;

import shapes.common.Shape;
import shapes.common.Visitor;

class Location implements shapes.common.Location {

	protected final int x, y;
	
	protected final Shape shape;
	
	public Location(final int x, final int y, final Shape shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}

	@Override
	public Shape getChild() { 
		return shape; 
	}
	
	@Override
	public int getX() { 
		return x; 
	}
	
	@Override
	public int getY() { 
		return y; 
	}
	
	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.visitLocation(this);
	}
}
