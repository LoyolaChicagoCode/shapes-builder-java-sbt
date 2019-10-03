package shapes.impl.composite;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import shapes.common.Builder;
import shapes.common.Point;
import shapes.common.Shape;

/** A builder that uses the default implementations of the composite interfaces. */
public class CompositeBuilder implements Builder {

  // TODO your job (except addCircle and setLocation)
  // remove instance variables at end

  @Override
  public void addCircle(final int radius) {
    if (!stack.isEmpty() && groupLevel == 0) throw new IllegalStateException("not in a group");
    stack.push(new Circle(radius));
  }

  @Override
  public void startPolygon() {}

  @Override
  public void addRectangle(final int width, final int height) {}

  @Override
  public void endGroup() {}

  @Override
  public Shape getProduct() {

    return stack.lastElement();
  }

  @Override
  public void setFilled(final boolean filled) {}

  @Override
  public void setLocation(final int x, final int y) {
    stack.push(new Location(x, y, stack.pop()));
  }

  @Override
  public void setStroke(Color color) {}

  @Override
  public void startGroup() {}

  @Override
  public void addPoint(final int x, final int y) {}

  @Override
  public void endPolygon() {}

  @Override
  public void reset() {}

  private final Stack<Shape> stack = new Stack<Shape>();

  private int groupLevel = 0;
}
