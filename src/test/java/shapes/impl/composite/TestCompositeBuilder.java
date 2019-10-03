package shapes.impl.composite;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shapes.common.Builder;
import shapes.common.Equals;
import shapes.common.Shape;

public class TestCompositeBuilder {

  private Builder builder;

  /** @throws java.lang.Exception */
  @Before
  public void setUp() throws Exception {
    builder = new CompositeBuilder();
  }

  /** @throws java.lang.Exception */
  @After
  public void tearDown() throws Exception {
    builder = null;
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#addCircle(int)}. */
  @Test
  public void testAddCircle() {
    builder.addCircle(50);
    assertTrue(Equals.equals(new Circle(50), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#addCircle(int)}. */
  @Test
  public void testAddCircleTwice() {
    builder.addCircle(50);
    try {
      builder.addCircle(50);
      fail("exception expected");
    } catch (IllegalStateException ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#addRectangle(int, int)}. */
  @Test
  public void testAddRectangle() {
    builder.addRectangle(50, 100);
    assertTrue(Equals.equals(new Rectangle(50, 100), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#addCircle(int)}. */
  @Test
  public void testAddRectangleTwice() {
    builder.addRectangle(50, 100);
    try {
      builder.addRectangle(50, 100);
      fail("exception expected");
    } catch (IllegalStateException ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#getProduct()}. */
  @Test
  public void testGetProduct() {
    try {
      builder.getProduct();
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setFilled(boolean)}. */
  @Test
  public void testSetFilled() {
    builder.addCircle(50);
    builder.setFilled(true);
    assertTrue(Equals.equals(new Filled(new Circle(50)), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setFilled(boolean)}. */
  @Test
  public void testSetFilled2() {
    builder.addCircle(50);
    builder.setFilled(false);
    assertTrue(Equals.equals(new Outline(new Circle(50)), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setFilled(boolean)}. */
  @Test
  public void testSetFilledNoShape() {
    try {
      builder.setFilled(true);
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setLocation(int, int)}. */
  @Test
  public void testSetLocation() {
    builder.addCircle(50);
    builder.setLocation(30, 40);
    assertTrue(Equals.equals(new Location(30, 40, new Circle(50)), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setLocation(int, int)}. */
  @Test
  public void testSetLocationNoShape() {
    try {
      builder.setLocation(30, 40);
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setStroke(java.awt.Color)}. */
  @Test
  public void testSetStroke() {
    builder.addCircle(50);
    builder.setStroke(Color.red);
    assertTrue(Equals.equals(new Stroke(Color.RED, new Circle(50)), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#setStroke(java.awt.Color)}. */
  @Test
  public void testSetStrokeNoShape() {
    try {
      builder.setStroke(Color.RED);
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#startGroup()}. */
  @Test
  public void testEndGroupNoGroup() {
    try {
      builder.endGroup();
      fail("exception expected");
    } catch (IllegalStateException ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#startGroup()}. */
  @Test
  public void testGroupEmpty() {
    builder.startGroup();
    builder.endGroup();
    assertTrue(Equals.equals(new Group(), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#startGroup()}. */
  @Test
  public void testGroup() {
    builder.startGroup();
    builder.addCircle(50);
    builder.addRectangle(30, 40);
    builder.endGroup();
    assertTrue(
        Equals.equals(new Group(new Circle(50), new Rectangle(30, 40)), builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#addPoint(int, int)}. */
  @Test
  public void testAddPointNoPolygon() {
    try {
      builder.addPoint(30, 40);
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#endPolygon()}. */
  @Test
  public void testEndPolygonNoPolygon() {
    builder.addCircle(50);
    try {
      builder.endPolygon();
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testStartPolygonTwice() {
    builder.startPolygon();
    try {
      builder.startPolygon();
      fail("exception expected");
    } catch (IllegalStateException ex) {
    }
  }

  @Test
  public void testStartPolygonNoGroup() {
    builder.addCircle(50);
    try {
      builder.startPolygon();
      fail("exception expected");
    } catch (IllegalStateException ex) {
    }
  }

  @Test
  public void testPolygonEmpty() {
    builder.startPolygon();
    builder.endPolygon();
  }

  @Test
  public void testPolygonNonempty() {
    builder.startPolygon();
    builder.addPoint(30, 40);
    builder.addPoint(50, 60);
    builder.addPoint(70, 80);
    builder.endPolygon();
    Polygon p =
        new Polygon(new DefaultPoint(30, 40), new DefaultPoint(50, 60), new DefaultPoint(70, 80));
    assertTrue(Equals.equals(p, builder.getProduct()));
  }

  /** Test method for {@link shapes.impl.composite.CompositeBuilder#reset()}. */
  @Test
  public void testReset() {
    builder.addCircle(50);
    builder.reset();
    try {
      builder.getProduct();
      fail("exception expected");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testComplex() {
    builder.startGroup();
    builder.addCircle(20);
    builder.addRectangle(100, 200);
    builder.startGroup();
    builder.addRectangle(50, 30);
    builder.setFilled(true);
    builder.addRectangle(300, 60);
    builder.addCircle(50);
    builder.setFilled(true);
    builder.setStroke(Color.ORANGE);
    builder.setLocation(100, 200);
    builder.endGroup();
    builder.setStroke(Color.RED);
    builder.setLocation(150, 50);
    builder.endGroup();
    builder.setLocation(50, 100);
    final Shape s1 = builder.getProduct();

    final Shape s2 =
        new Location(
            50,
            100,
            new Group(
                new Circle(20),
                new Rectangle(100, 200),
                new Location(
                    150,
                    50,
                    new Stroke(
                        Color.RED,
                        new Group(
                            new Filled(new Rectangle(50, 30)),
                            new Rectangle(300, 60),
                            new Location(
                                100,
                                200,
                                new Stroke(Color.ORANGE, new Filled(new Circle(50)))))))));

    assertTrue(Equals.equals(s1, s2));
  }

  @Test
  public void testComplex2() {
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
    final Shape s1 = builder.getProduct();

    final Shape s2 =
        new Location(
            50,
            100,
            new Group(
                new Circle(20),
                new Rectangle(100, 200),
                new Location(
                    150,
                    50,
                    new Stroke(
                        Color.RED,
                        new Filled(
                            new Group(
                                new Rectangle(50, 30),
                                new Outline(new Rectangle(300, 60)),
                                new Stroke(
                                    Color.CYAN,
                                    new Polygon(
                                        new DefaultPoint(50, 50),
                                        new DefaultPoint(60, 100),
                                        new DefaultPoint(100, 110),
                                        new DefaultPoint(120, 60))),
                                new Location(
                                    100,
                                    200,
                                    new Stroke(Color.ORANGE, new Outline(new Circle(50))))))))));

    assertTrue(Equals.equals(s1, s2));
  }
}
