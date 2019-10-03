package shapes.impl.composite;

import java.util.Arrays;
import java.util.List;

import shapes.common.Shape;
import shapes.common.Visitor;

class Group implements shapes.common.Group {

  protected final List<Shape> shapes;

  public Group(Shape... shapes) {
    this.shapes = Arrays.asList(shapes);
  }

  @Override
  public List<? extends Shape> getChildren() {
    return shapes;
  }

  @Override
  public <Result> Result accept(final Visitor<Result> v) {
    return v.visitGroup(this);
  }
}
