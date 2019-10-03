package shapes.algorithms;

import shapes.common.Outline;
import shapes.common.Polygon;
import shapes.common.Shape;
import shapes.common.Visitor;
import shapes.common.Circle;
import shapes.common.Filled;
import shapes.common.Group;
import shapes.common.Location;
import shapes.common.Rectangle;
import shapes.common.Stroke;
import shapes.common.Point;

/**
 * A shape visitor for calculating the bounding box, that is, the smallest rectangle containing the
 * shape. The resulting bounding box is returned as a rectangle at a specific location.
 */
public class BoundingBox implements Visitor<Location> {

  // TODO entirely your job (except visitCircle)

  @Override
  public Location visitCircle(final Circle c) {
    final int radius = c.getRadius();
    return createBoundingBox(-radius, -radius, 2 * radius, 2 * radius);
  }

  @Override
  public Location visitFilled(final Filled f) {
    return null;
  }

  @Override
  public Location visitGroup(final Group g) {
    return null;
  }

  @Override
  public Location visitLocation(final Location l) {
    return null;
  }

  @Override
  public Location visitRectangle(final Rectangle r) {
    return null;
  }

  @Override
  public Location visitStroke(final Stroke c) {
    return c.getChild().accept(this);
  }

  @Override
  public Location visitPolygon(final Polygon s) {
    return null;
  }

  @Override
  public Location visitOutline(final Outline o) {
    return o.getChild().accept(this);
  }

  protected Location createBoundingBox(
      final int x, final int y, final int width, final int height) {
    // TODO create a rectangle at a location
    // using anonymous inner classes that implement
    // the corresponding interfaces
    // (do not use the implementation classes!)
    return null;
  }
}
