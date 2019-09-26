package shapes.impl.composite;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shapes.algorithms.Size;
import shapes.common.Shape;

public class TestSize {

	private Size v;

	@Before
	public void setUp() throws Exception {
		v = new Size();
	}

	@After
	public void tearDown() throws Exception {
		v = null;
	}

	@Test
	public void testCircle() {
		int s = new Circle(50).accept(v);
		assertEquals(1, s);
	}

	@Test
	public void testRectangle() {
		int s = new Rectangle(80, 120).accept(v);
		assertEquals(1, s);
	}
	
	@Test
	public void testLocation() {
		int s = new Location(70, 30, new Rectangle(80, 120)).accept(v);
		assertEquals(1, s);
	}
	
	@Test
	public void testFilled() {
		int s = new Filled(new Rectangle(80, 120)).accept(v);
		assertEquals(1, s);
	}
	
	@Test
	public void testStroke() {
		int s = new Stroke(Color.RED, new Rectangle(80, 120)).accept(v);
		assertEquals(1, s);
	}
	
	@Test
	public void testGroupSimple() {
		Shape s = new Group(
			new Location(200, 100, new Circle(50)),
			new Location(400, 300, new Rectangle(100, 50))
		);
		int r = s.accept(v);
		assertEquals(2, r);
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
		int r = s.accept(v);
		assertEquals(6, r);
	}
	
	@Test
	public void testOutline() {
		int s = new Outline(new Rectangle(80, 120)).accept(v);
		assertEquals(1, s);
	}
	
	@Test
	public void testPolygon() {
		Shape s = new Polygon(
	  	new DefaultPoint(50, 50),
	  	new DefaultPoint(60, 100),
	  	new DefaultPoint(100, 110),
	  	new DefaultPoint(120, 60)
	  );
		int r = s.accept(v);
		assertEquals(1, r);
	}
}
