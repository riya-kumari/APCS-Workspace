import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author Riya Kumari
 * @version Oct 6
 * @author Period: 5
 * @author Assignment: JMCh09Ex17_Complex
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {

        Complex x = new Complex( 5.0, 5.0 );
        String y = 5.0 + " + " + 5.0 + "i";
        assertEquals( y, x.toString() );

    }


    @Test
    public void testConstructor2Param()
    {
        Complex x = new Complex( 5.0 );
        String y = 5.0 + " + " + 0.0 + "i";
        assertEquals( y, x.toString() );
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        Complex x1 = new Complex( 8.0, 9.0 );
        Complex sum = x1.add( x1 );
        Complex check = new Complex( 16.0, 18.0 );
        assertEquals( check.toString(), sum.toString() );
    }


    @Test
    public void testAdd2ComplexNums()
    {
      
        Complex x = new Complex( 5.0, 6.0 );
        Complex y = new Complex( 10.0, 6.0 );
        Complex x2 = x.add( 5.0 );
        assertEquals( y.toString(), x2.toString() );
    }
    


    @Test
    public void testMultiply2ComplexNums()
    {
        Complex x1 = new Complex( 2.0, 2.0 );
        Complex product = x1.multiply( x1 );
        Complex check = new Complex( 0.0, 8.0 );
        assertEquals( check.toString(), product.toString() );

    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex x1 = new Complex( 2.0, 2.0 );
        Complex product = x1.multiply( 4.0 );
        Complex check = new Complex( 8.0, 8.0 );
        assertEquals( check.toString(), product.toString() );
    }


    @Test
    public void testAbsoluteValue()
    {
        Complex x = new Complex( 4.0, 6.0 );
        double y = x.abs();
        assertEquals( Math.sqrt( 52 ), y );
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
