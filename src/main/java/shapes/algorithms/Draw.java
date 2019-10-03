package shapes.algorithms;

import java.awt.Color;
import java.awt.Graphics;

import shapes.common.Circle;
import shapes.common.Filled;
import shapes.common.Group;
import shapes.common.Location;
import shapes.common.Outline;
import shapes.common.Point;
import shapes.common.Polygon;
import shapes.common.Rectangle;
import shapes.common.Shape;
import shapes.common.Stroke;
import shapes.common.Visitor;

/** A visitor for drawing a shape to a Java AWT graphics object. */
public class Draw implements Visitor<Void> {

  // TODO entirely your job (except visitCircle)

  protected final Graphics g;

  protected final boolean fill;

  public Draw(final Graphics g) {
    this.g = g;
    this.fill = false;
  }

  public Draw(final Graphics g, final boolean fill) {
    this.g = g;
    this.fill = fill;
  }

  @Override
  public Void visitCircle(final Circle c) {
    final int r = c.getRadius();
    if (fill) g.fillArc(-r, -r, 2 * r, 2 * r, 0, 360);
    else g.drawArc(-r, -r, 2 * r, 2 * r, 0, 360);
    return null;
  }

  @Override
  public Void visitStroke(final Stroke c) {
    return null;
  }

  @Override
  public Void visitFilled(final Filled f) {
    return null;
  }

  @Override
  public Void visitGroup(final Group g) {
    return null;
  }

  @Override
  public Void visitLocation(final Location l) {
    return null;
  }

  @Override
  public Void visitRectangle(final Rectangle r) {
    return null;
  }

  @Override
  public Void visitPolygon(final Polygon s) {
    return null;
  }

  @Override
  public Void visitOutline(final Outline o) {
    return null;
  }
}
