package shapes.common;

/** A visitor on graphical shapes. */
public interface Visitor<Result> {
  Result visitLocation(Location l);

  Result visitCircle(Circle c);

  Result visitRectangle(Rectangle r);

  Result visitPolygon(Polygon p);

  Result visitGroup(Group g);

  Result visitStroke(Stroke c);

  Result visitFilled(Filled c);

  Result visitOutline(Outline o);
}
