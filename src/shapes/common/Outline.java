package shapes.common;

/**
 * A decorator indicating that a shape
 * should be drawn as an outlined shape
 * instead of a filled one.
 */
public interface Outline extends Shape {
	Shape getChild();
}
