package shapes.common;

/**
 * A decorator indicating that a shape
 * should be drawn as a filled shape
 * instead of an outlined one.
 */
public interface Filled extends Shape {
	Shape getChild();
}
