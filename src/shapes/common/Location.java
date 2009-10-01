package shapes.common;

/**
 * A decorator for specifying a shape's location.
 */
public interface Location extends Shape {
	int getX();
	int getY();
	Shape getChild();
}
