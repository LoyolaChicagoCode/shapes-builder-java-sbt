package shapes.common;

import java.util.Iterator;
import java.util.List;

public class Equals {
  public static boolean equals(final Shape s1, final Shape s2) {
    if (s1 instanceof Circle && s2 instanceof Circle)
      return ((Circle) s1).getRadius() == ((Circle) s2).getRadius();
    if (s1 instanceof Rectangle && s2 instanceof Rectangle)
      return ((Rectangle) s1).getWidth() == ((Rectangle) s2).getWidth()
          && ((Rectangle) s1).getHeight() == ((Rectangle) s2).getHeight();
    if (s1 instanceof Polygon && s2 instanceof Polygon) {
      final List<? extends Point> p1 = ((Polygon) s1).getPoints();
      final List<? extends Point> p2 = ((Polygon) s2).getPoints();
      if (p1.size() != p2.size()) return false;
      final Iterator<? extends Point> i1 = p1.iterator();
      final Iterator<? extends Point> i2 = p2.iterator();
      while (i1.hasNext()) {
        final Point q1 = i1.next();
        final Point q2 = i2.next();
        if (q1.getX() != q2.getX() || q1.getY() != q2.getY()) return false;
      }
      return true;
    }
    if (s1 instanceof Filled && s2 instanceof Filled)
      return equals(((Filled) s1).getChild(), ((Filled) s2).getChild());
    if (s1 instanceof Outline && s2 instanceof Outline)
      return equals(((Outline) s1).getChild(), ((Outline) s2).getChild());
    if (s1 instanceof Stroke && s2 instanceof Stroke)
      return ((Stroke) s1).getColor().equals(((Stroke) s2).getColor())
          && equals(((Stroke) s1).getChild(), ((Stroke) s2).getChild());
    if (s1 instanceof Location && s2 instanceof Location)
      return ((Location) s1).getX() == ((Location) s2).getX()
          && ((Location) s1).getY() == ((Location) s2).getY()
          && equals(((Location) s1).getChild(), ((Location) s2).getChild());
    if (s1 instanceof Group && s2 instanceof Group) {
      final List<? extends Shape> l1 = ((Group) s1).getChildren();
      final List<? extends Shape> l2 = ((Group) s2).getChildren();
      if (l1.size() != l2.size()) return false;
      final Iterator<? extends Shape> i1 = l1.iterator();
      final Iterator<? extends Shape> i2 = l2.iterator();
      while (i1.hasNext()) {
        final Shape q1 = i1.next();
        final Shape q2 = i2.next();
        if (!equals(q1, q2)) return false;
      }
      return true;
    }
    return false;
  }
}
