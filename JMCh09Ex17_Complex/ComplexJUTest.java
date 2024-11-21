import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 *  Test for the complex number class.
 *  
 *  testConstructor1Param - test the 1 parameter constructor
 *  testConstructor2Param - test the 2 parameter constructor
 *  testAddRealAndComplexNum - addition of a complex number 
 *     with a real number
 *  testAdd2ComplexNums - addition of two complex numbers
 *  testMultiply2ComplexNums - multiplication of two complex numbers
 *  testMultiplyRealAndComplexNum - multiplication of a complex number
 *     with a real number
 *  testAbsoluteValue - absolute value of a complex number
 *
 *  @author  Chaaruhaas Kandregula
 *  @version 10/10/2024
 *  @author  Period: 3
 *  @author  Assignment: JMCh09Ex17_Complex 
 *
 *  @author  Sources: None
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        Complex c1 = new Complex(3);
        String rightAnswer = "3.0 + 0.0i";
        String myAnswer = c1.toString();
        assertEquals(rightAnswer, myAnswer);
    }

    @Test
    public void testConstructor2Param()
    {
        Complex c2 = new Complex(1, 2); //Creates 1.0 + 2.0i
        String rightAnswer = "1.0 + 2.0i"; 
        String myAnswer = c2.toString(); //This should be 1.0 + 2.0i
        assertEquals(rightAnswer, myAnswer); 
    }

    @Test
    public void testAddRealAndComplexNum()
    {
        Complex c3 = new Complex(1, 2);
        double d = 10.0;
        Complex c4 = c3.add(d);
        String rightAnswer = "11.0 + 2.0i"; 
        String myAnswer = c4.toString(); 
        assertEquals(rightAnswer, myAnswer);
    }
    
    @Test
    public void testAdd2ComplexNums()
    {
        Complex c5 = new Complex(1, 2);
        Complex c6 = new Complex(3, 4);
        Complex c7 = c5.add(c6);
        String rightAnswer = "4.0 + 6.0i"; 
        String myAnswer = c7.toString(); 
        assertEquals(rightAnswer, myAnswer);
    }

    @Test
    public void testMultiply2ComplexNums()
    {
        Complex c8 = new Complex(1, 2);
        Complex c9 = new Complex(3, 4);
        Complex c10 = c8.multiply(c9);
        String rightAnswer = "-5.0 + 10.0i"; 
        String myAnswer = c10.toString(); 
        assertEquals(rightAnswer, myAnswer);
    }

    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex c11 = new Complex(1, 2);
        double d = 10.0;
        Complex c12 = c11.multiply(d);
        String rightAnswer = "10.0 + 20.0i"; 
        String myAnswer = c12.toString(); 
        assertEquals(rightAnswer, myAnswer);
    }

    @Test
    public void testAbsoluteValue()
    {
        Complex c1 = new Complex(5, 12);
        String rightAnswer = "13.0"; 
        String myAnswer = Double.toString(c1.abs()); 
        assertEquals(rightAnswer, myAnswer);
    }
    
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
