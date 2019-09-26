package shapes.impl.composite;

import shapes.common.Visitor;

class Rectangle implements shapes.common.Rectangle {

	protected final int width, height;
	
	public Rectangle(final int width, final int height) {
		if (width < 0)
			throw new IllegalArgumentException("width < 0");
		if (height < 0)
			throw new IllegalArgumentException("height < 0");
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getWidth() { return width; }
	
	@Override
	public int getHeight() { return height; }
	
	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.visitRectangle(this);
	}
}
