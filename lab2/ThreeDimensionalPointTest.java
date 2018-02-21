import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreeDimensionalPointTest {

	@Test
	void testThreeDimensionalPoint() 
	{
		ThreeDimensionalPoint coordinate = new ThreeDimensionalPoint();		
		assertTrue(coordinate.getX() == 0);
		assertTrue(coordinate.getY() == 0);
		assertTrue(coordinate.getZ() == 0);
	}

	@Test
	void testThreeDimensionalPointDoubleDoubleDouble() 
	{
		ThreeDimensionalPoint coordinate = new ThreeDimensionalPoint(5,4,3);
		assertTrue(coordinate.getX() == 5);
		assertTrue(coordinate.getY() == 4);
		assertTrue(coordinate.getZ() == 3);
	}

	@Test
	void testShiftX() 
	{
		ThreeDimensionalPoint coordinate = new ThreeDimensionalPoint(5,0,0);
		
		double new_x = coordinate.shiftX(5);
		assertTrue( new_x == 10);
	}

	@Test
	void testShiftY() {
		ThreeDimensionalPoint coordinate = new ThreeDimensionalPoint(0,5,0);
		double new_y = coordinate.shiftY(5);
		assertTrue( new_y == 10);
	}

	@Test
	void testShiftZ() {
		ThreeDimensionalPoint coordinate = new ThreeDimensionalPoint(0,0,5);
		double new_z = coordinate.shiftZ(5);
		assertTrue( new_z == 10);
	}

	@Test
	void testRotateX() 
	{	
		ThreeDimensionalPoint coordinate_3 = new ThreeDimensionalPoint(10,10,10);
		ThreeDimensionalPoint coordinate_4 = new ThreeDimensionalPoint(10,10,10);
		coordinate_3.rotateX(Math.PI);
		coordinate_4.rotateX(-Math.PI);
		assertEquals(coordinate_3.getX(), coordinate_4.getX() ,0.001);
		assertEquals(coordinate_3.getY(), coordinate_4.getY() ,0.001);
		assertEquals(coordinate_3.getZ(), coordinate_4.getZ() ,0.001);
		
	}

	@Test
	void testRotateY() {
		ThreeDimensionalPoint coordinate_3 = new ThreeDimensionalPoint(10,10,10);
		ThreeDimensionalPoint coordinate_4 = new ThreeDimensionalPoint(10,10,10);
		coordinate_3.rotateY(Math.PI);
		coordinate_4.rotateY(-Math.PI);
		assertEquals(coordinate_3.getX(), coordinate_4.getX() ,0.001);
		assertEquals(coordinate_3.getY(), coordinate_4.getY() ,0.001);
		assertEquals(coordinate_3.getZ(), coordinate_4.getZ() ,0.001);
	}

	
	@Test
	void testRotateZ() {
		ThreeDimensionalPoint coordinate_3 = new ThreeDimensionalPoint(10,10,10);
		ThreeDimensionalPoint coordinate_4 = new ThreeDimensionalPoint(10,10,10);
		coordinate_3.rotateZ(Math.PI);
		coordinate_4.rotateZ(-Math.PI);
		assertEquals(coordinate_3.getX(), coordinate_4.getX() ,0.001);
		assertEquals(coordinate_3.getY(), coordinate_4.getY() ,0.001);
		assertEquals(coordinate_3.getZ(), coordinate_4.getZ() ,0.001);
	}

}
