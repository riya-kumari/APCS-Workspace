import java.util.*;


/**
 * RPN Calculator
 *
 * @author Riya Kumari
 * @version 1/18
 * @author Period: 5
 * @author Assignment: AB31RPN Calculator
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();

    }


    /**
     * ** Used for testing - Do Not Remove *
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * Calculates the expression
     */
    public void calculate()
    {
        /*
         * 1. if there are more numbers and operands 2. get the next int1 till u
         * reach an operand 3. save the operand in char 4. when u get an
         * operand, go back two (the int before int1) 5. check which operand it
         * is and call that method 6. u save the result and loop it
         */
        while ( scan.hasNext() )
        {

            String num = scan.next();
            // for ( int i = 0; i < num.length(); i++ )
            // {
            char a = num.charAt( 0 );
            myQ.add( "" + a );
            // myStack.push(Character.getNumericValue( a );
            switch ( a )
            {
                case 'q':
                case 'Q':
                    String expression = toString();
                    System.out
                        .println( expression + " = " + myStack.pop() );
                    break;

                case '+':
                    add();

                    break;

                case '-':
                    subtract();

                    break;

                case '/':
                    divide();

                    break;

                case '*':
                    multiply();

                    break;

                default:
                    myStack.push( Character.getNumericValue( a ) );
                    break;

            }

            // i++;
            // }
        }
    }


    /*
     * Converts the entire problem into a string and returns the string
     * 
     * @ returns the string with the expression
     */
    public String toString()
    {
        String random = "";
        int count = myQ.size();
        int i = 0;
        while ( i < count - 1 )
        {
            random += " " + myQ.remove();
            i++;
        }
        // if(random.contains( "q" )||random.contains( "Q" ))
        // {
        // random.indexOf( )
        // }
        return random;
    }


    /*
     * Adds the two values in stack
     */
    public void add()
    {
        int var = myStack.pop() + myStack.pop();
        myStack.push( var );
    }


    /*
     * Subtracts the two top values in stack
     */
    public void subtract()
    {
        int var1 = myStack.pop();
        int var = myStack.pop() - var1;
        myStack.push( var );
    }


    /*
     * Multiplies the top two values in stack
     */
    public void multiply()
    {
        int var = myStack.pop() * myStack.pop();
        myStack.push( var );
    }


    /*
     * Divides the top two values in stack
     */
    public void divide()
    {
        int var1 = myStack.pop();
        int var = myStack.pop();
        myStack.push( var / var1 );
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}