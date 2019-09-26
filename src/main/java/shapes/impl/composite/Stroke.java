package shapes.impl.composite;

import java.awt.Color;

import shapes.common.Shape;
import shapes.common.Visitor;

class Stroke implements shapes.common.Stroke {
	
	// TODO entirely your job

	public Stroke(Color color, Shape shape) {

	}
	
	@Override
	public Color getColor() {
		return null;
	}
	
	@Override
	public Shape getChild() {
		return null;
	}
	
	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return null;
	}
}
