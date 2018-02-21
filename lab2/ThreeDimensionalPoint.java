/*
 *	Lab 2 
 *	The objectives of this lab are:
 * 	 review the Java language
 *	 use methods in the math API
 * 	 design and run unit tests
 * 	 apply some principles of programming and software engineering 
 *
 *
 *	finished by 2018/1/24 18:43
 *	Author:Sean Yan/ Alex	  
 */
public class ThreeDimensionalPoint {
	
	// define the 3 coordinate
	private double x, y, z;
	// default constructor sets the origin at (0,0,0)
	public ThreeDimensionalPoint()
	{
		x = 0;
		y = 0;
		z = 0;
		
	}
	// constructor allows the (x,y,z) coordinates to be specified.
	public ThreeDimensionalPoint(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// 3 getter methods return x,y,z.
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getZ()
	{
		return z;
	}
	
	// 3 shift methods giving new coordinate.
	public double shiftX(double amount)
	{
		this.x = x + amount;
		return x;
	}
	
	public double shiftY(double amount)
	{
		this.y = y + amount;
		return y;
	}
	
	public double shiftZ(double amount)
	{
		this.z = z + amount;
		return z;
	}
	
	// 3 rotate methods
	public void rotateX(double theta)
	{	
		x = getX();
		double new_y = (y * Math.cos(theta)) - (z * Math.sin(theta));
		double new_z = (y * Math.sin(theta)) + (z * Math.cos(theta));
		y = new_y;
		z = new_z;
	}
	
	public void rotateY(double theta)
	{
		double new_x = x * Math.cos(theta) + z * Math.sin(theta);
		y = getY();
		double new_z = -x * Math.sin(theta) + z * Math.cos(theta);
		x = new_x;
		z = new_z;
	}
	
	public void rotateZ(double theta)
	{
		double new_x = x * Math.cos(theta) - y * Math.sin(theta);
		double new_y = x * Math.sin(theta) + y * Math.cos(theta);
		z = getZ();
		x = new_x;
		y = new_y;
	}
	
	
// end of the class.
}
