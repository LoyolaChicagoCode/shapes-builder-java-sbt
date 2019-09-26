package shapes.common;

import java.util.List;

/**
 * A composite for grouping shapes.impl.composite.
 */
public interface Group extends Shape {
	List<? extends Shape> getChildren();
}
