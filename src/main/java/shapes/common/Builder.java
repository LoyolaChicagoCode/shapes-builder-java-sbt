package shapes.common;

import java.awt.Color;

/**
 * A builder for creating a complex shape without
 * needing to know how to instantiate the implementation
 * classes of the composite.  
 */
public interface Builder {
	
	/**
	 * Starts over.
	 */
	void reset();
	
	/**
	 * Adds a circle as the current shape.
	 * @param radius the radius of the circle
	 * @throws IllegalStateException if this is not the first shape to be 
	 * 		added but there is no current group
	 */
	void addCircle(int radius);
	
	/**
	 * Adds a rectangle as the current shape.
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @throws IllegalStateException if this is not the first shape to be 
	 * 		added but there is no current group
	 */
	void addRectangle(int width, int height);
	
	/**
	 * Starts a group of several shapes to be treated 
	 * as a single shape. Between now and the first
	 * invocation of endGroup(), all new shapes
	 * will be added to this current group.
	 * Without starting a group, only the most
	 * recently added shape is returned as the product.
	 */
	void startGroup();

	/**
	 * Ends a group of several shapes to be treated 
	 * as a single shape.
	 * @throws IllegalStateException if there is no current group
	 */
	void endGroup();
	
	/**
	 * Starts a polygon consisting of several points 
	 * as the current shape.
	 * @throws IllegalStateException if this is not the first shape to be 
	 * 		added but there is no current group,
	 * 		or if there is already a current polygon
	 */
	void startPolygon();

	/**
	 * Closes the current polygon.
	 * @throws IllegalStateException if there is no current polygon
	 */
	void endPolygon();

	/**
	 * Adds a point to the current polygon.
	 * @throws Exception if there is no current polygon
	 */
	void addPoint(int x, int y);
	
	/**
	 * Sets the location of the current shape. 
	 * @param x the x coordinate of the location
	 * @param y the y coordinate of the location
	 * @throws Exception if there is no current shape
	 */
	void setLocation(int x, int y);
	
	/**
	 * Sets the fill mode (filled or outline) of the current shape.
	 * @param filled the fill mode (filled or outline)
	 * @throws Exception if there is no current shape
	 */
	void setFilled(boolean filled);
	
	/**
	 * Sets the stroke (foreground color) of the current shape.
	 * @param color the foreground color
	 * @throws Exception if there is no current shape
	 */
	void setStroke(Color color);
	
	/**
	 * Returns the finished complex shape.
	 * @return the finished complex shape
	 * @throws Exception if no product is available
	 */
	Shape getProduct();
}
