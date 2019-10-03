package shapes.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shapes.algorithms.BoundingBox;
import shapes.algorithms.Draw;
import shapes.algorithms.Size;
import shapes.common.Builder;
import shapes.common.Location;
import shapes.common.Rectangle;
import shapes.common.Shape;
import shapes.impl.composite.CompositeBuilder;

public class Main2 {

  public static void main(String[] args) {
    // (see also shapes.impl.composite.Main)
    // define a complex group of shapes.impl.composite
    Builder builder = new CompositeBuilder();
    builder.startGroup();
    builder.addCircle(20);
    builder.addRectangle(100, 200);
    builder.startGroup();
    builder.addRectangle(50, 30);
    builder.addRectangle(300, 60);
    builder.setFilled(false);
    builder.startPolygon();
    builder.addPoint(50, 50);
    builder.addPoint(60, 100);
    builder.addPoint(100, 110);
    builder.addPoint(120, 60);
    builder.endPolygon();
    builder.setStroke(Color.CYAN);
    builder.addCircle(50);
    builder.setFilled(false);
    builder.setStroke(Color.ORANGE);
    builder.setLocation(100, 200);
    builder.endGroup();
    builder.setFilled(true);
    builder.setStroke(Color.RED);
    builder.setLocation(150, 50);
    builder.endGroup();
    builder.setLocation(50, 100);
    final Shape s = builder.getProduct();
    System.out.println(s.accept(new Size()) + " basic shapes");

    // calculate the bounding box
    final Location b = s.accept(new BoundingBox());
    final Rectangle r = (Rectangle) b.getChild();

    // draw it in a frame centered around the bounding box
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final int padding = 20;
    @SuppressWarnings("serial")
    JPanel p =
        new JPanel() {
          @Override
          public void paintComponent(Graphics g) {
            g.translate(-b.getX() + padding, -b.getY() + padding);
            s.accept(new Draw(g));
            s.accept(new BoundingBox()).accept(new Draw(g));
          }
        };
    p.setPreferredSize(new Dimension(r.getWidth() + 2 * padding, r.getHeight() + 2 * padding));
    f.setContentPane(p);
    f.pack();
    f.setVisible(true);

    // now draw the same complex group of shapes.impl.composite by hand
    // (without the bounding box)
    JFrame h = new JFrame();
    h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    @SuppressWarnings("serial")
    JPanel q =
        new JPanel() {
          @Override
          public void paintComponent(Graphics g) {
            g.translate(-10, -60);
            g.translate(50, 100);
            g.drawArc(-20, -20, 40, 40, 0, 360);
            g.drawRect(0, 0, 100, 200);
            g.setColor(Color.RED);
            g.fillRect(150, 50, 50, 30);
            g.drawRect(150, 50, 300, 60);
            g.setColor(Color.CYAN);
            g.fillPolygon(new int[] {200, 210, 250, 270}, new int[] {100, 150, 160, 110}, 4);
            g.setColor(Color.ORANGE);
            g.translate(250, 250);
            g.drawArc(-50, -50, 100, 100, 0, 360);
          }
        };
    q.setPreferredSize(new Dimension(470 + 2 * padding, 320 + 2 * padding));
    h.setContentPane(q);
    h.pack();
    h.setVisible(true);
  }
}
