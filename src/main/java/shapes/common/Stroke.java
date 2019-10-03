package shapes.common;

import java.awt.Color;

/** A decorator for specifying the stroke (foreground) color for drawing the shape. */
public interface Stroke extends Shape {
  Color getColor();

  Shape getChild();
}
