package shapes.impl.composite;

import java.util.List;

import shapes.common.Point;
import shapes.common.Visitor;

/** A special case of a group consisting only of DefaultPoints. */
class Polygon extends Group implements shapes.common.Polygon {

  public Polygon(final Point... points) {
    super(toArrayOfDefaultPoints(points));
  }

  protected static DefaultPoint[] toArrayOfDefaultPoints(Point... points) {
    // TODO your job
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<? extends Point> getPoints() {
    return (List<? extends Point>) getChildren();
  }

  @Override
  public <Result> Result accept(final Visitor<Result> v) {
    return v.visitPolygon(this);
  }
}
