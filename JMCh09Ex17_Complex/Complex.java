/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Riya Kumari
 * @version Oct 6
 * @author Period: 5
 * @author Assignment: JMCh09Ex17_Complex
 *
 */
public class Complex
{
    
    private double num1;

    private double num2;


    /**
     * Constructs a complex number
     * 
     * @param a
     *            is the real number
     * @param b
     *            is the imaginary number
     */
    public Complex( double a, double b )
    {
        num1 = a;
        num2 = b;
    }


    /**
     * Constructs a complex number with one value
     * 
     * @param a
     *            is a real number
     */
    public Complex( double a )
    {
        num1 = a;
        num2 = 0.0;
    }


    /**
     * Converts the values to absolute value
     * 
     * @return double absolute value
     */
    public double abs()
    {
        return Math.sqrt( Math.pow( num1, 2 ) + Math.pow( num2, 2 ) );
    }


    /**
     * Adds two complex numbers
     * 
     * @param other
     *            copy constructor
     * @return Complex complex sum
     */
    public Complex add( Complex other )
    {
        num1 += other.num1;
        num2 += other.num2;

        return new Complex( num1, num2 );
    }


    /**
     * Multiplies the complex number
     * 
     * @param other
     *            copy constructor
     * @return Complex product
     */
    public Complex multiply( Complex other )
    {
        double real = ( num1 * other.num1 ) + ( -1 * num2 * other.num2 );
        double imaginary = ( num2 * other.num1 ) + ( num1 * other.num2 );
        return new Complex( real, imaginary );
    }


    /**
     * Adds the complex number with a given value
     * 
     * @param a
     *            is the real number
     * @return Complex sum
     */
    public Complex add( double a )
    {
        num1 += a;

        return new Complex( num1, num2 );
    }


    /**
     * Multiplies the complex number with a given value
     * 
     * @param a
     *            is the given value
     * @return Complex product
     */
    public Complex multiply( double a )
    {
        double real = ( num1 * a );
        double imaginary = ( num2 * a );
        return new Complex( real, imaginary );

    }


    /**
     * Converts the equation into a string
     * 
     * @return String
     */
    public String toString()
    {
        return num1 + " + " + num2 + "i";
    }
}
