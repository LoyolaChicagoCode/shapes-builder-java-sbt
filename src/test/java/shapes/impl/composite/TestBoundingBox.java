package shapes.impl.composite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shapes.algorithms.BoundingBox;
import shapes.common.Shape;

public class TestBoundingBox {

	private BoundingBox v;
	
	@Before
	public void setUp() throws Exception {
		v = new BoundingBox();
	}

	@After
	public void tearDown() throws Exception {
		v = null;
	}

	@Test
	public void testCircle() {
		shapes.common.Location b = new Circle(50).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(-50, b.getX());
		assertEquals(-50, b.getY());
		assertEquals(100, r.getWidth());
		assertEquals(100, r.getHeight());
		assertFalse(b instanceof Location);
		assertFalse(r instanceof Rectangle);
	}

	@Test
	public void testRectangle() {
		shapes.common.Location b = new Rectangle(80, 120).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}
	
	@Test
	public void testLocation() {
		shapes.common.Location b = new Location(70, 30, new Rectangle(80, 120)).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(70, b.getX());
		assertEquals(30, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}
	
	@Test
	public void testFilled() {
		shapes.common.Location b = new Filled(new Rectangle(80, 120)).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}
	
	@Test
	public void testStroke() {
		shapes.common.Location b = new Stroke(Color.RED, new Rectangle(80, 120)).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}
	
	@Test
	public void testGroupSimple() {
		Shape s = new Group(
			new Location(200, 100, new Circle(50)),
			new Location(400, 300, new Rectangle(100, 50))
		);
		shapes.common.Location b = s.accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(150, b.getX());
		assertEquals(50, b.getY());
		assertEquals(350, r.getWidth());
		assertEquals(300, r.getHeight());
	}
	
	@Test
	public void testGroupComplex() {
		final Shape s = new Location(50, 100, 
			new Group(
				new Circle(20),
				new Rectangle(100, 200),
				new Location(150, 50,
					new Stroke(Color.RED,
						new Filled(
							new Group(
								new Rectangle(50, 30),
								new Outline(new Rectangle(300, 60)),
				  			new Stroke(Color.CYAN,
				  				new Polygon(
					  		  	new DefaultPoint(50, 50),
					  		  	new DefaultPoint(60, 100),
					  		  	new DefaultPoint(100, 110),
					  		  	new DefaultPoint(120, 60)
					  		  )
				  			),
								new Location(100, 200, 
									new Stroke(Color.ORANGE,
										new Outline(new Circle(50))
									)
								)
							)
						)
					)
				)
			)
		);
		shapes.common.Location b = s.accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(30, b.getX());
		assertEquals(80, b.getY());
		assertEquals(470, r.getWidth());
		assertEquals(320, r.getHeight());
	}
	
	@Test
	public void testOutline() {
		shapes.common.Location b = new Outline(new Rectangle(80, 120)).accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}
	
	@Test
	public void testPolygon() {
		Shape s = new Polygon(
			new DefaultPoint(50, 50),
			new DefaultPoint(60, 100),
			new DefaultPoint(100, 110),
			new DefaultPoint(120, 60)
		);
		shapes.common.Location b = s.accept(v);
		shapes.common.Rectangle r = (shapes.common.Rectangle) b.getChild();
		assertEquals(50, b.getX());
		assertEquals(50, b.getY());
		assertEquals(70, r.getWidth());
		assertEquals(60, r.getHeight());
	}
}
