import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	private GradeBook gradeOne;
	private GradeBook gradeTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		gradeOne = new GradeBook(5);
		gradeTwo = new GradeBook(5);
		
		gradeOne.addScore(50);
		gradeOne.addScore(75);
		
		gradeTwo.addScore(45);
		gradeTwo.addScore(60);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeOne = null;
		gradeTwo = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradeOne.toString().equals(" 50.0 75.0 "));
		assertTrue(gradeTwo.toString().equals(" 45.0 60.0 "));
		
		assertEquals(2,gradeOne.getScoreSize(),0.001);
		assertEquals(2,gradeTwo.getScoreSize(),0.001);
		
		//fail("Not yet implemented");
	}

	@Test
	void testSum() {
		assertEquals(125.0,gradeOne.sum(),0.001);
		assertEquals(105.0,gradeTwo.sum(),0.001);
		
		//fail("Not yet implemented");
	}

	@Test
	void testMinimum() {
		assertEquals(50,gradeOne.minimum(),0.001);
		assertEquals(45,gradeTwo.minimum(),0.001);
		
		//fail("Not yet implemented");
	}

	@Test
	void testFinalScore() {
		assertEquals(75,gradeOne.finalScore(),0.001);
		assertEquals(60,gradeTwo.finalScore(),0.001);
		
		//fail("Not yet implemented");
	}

}
