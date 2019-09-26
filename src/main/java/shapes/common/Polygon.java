package shapes.common;

import java.util.List;

/**
 * A closed polygon defined by its points.
 */
public interface Polygon extends Shape {
	List<? extends Point> getPoints();
}
