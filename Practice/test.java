
public class test
{

    public static void main( String[] args )
    {
        test t = new test();
        t.power3( 15 );
    }


    public int power3( int n )
    {
        if ( n == 0 ) // if n equals to 0
            return 1;
        else
        {
            int p = power3( n / 2 );
            // when n is odd, n/2 is truncated to an integer // e.g., 7/2 gives
            // 3 and 1/2 gives 0
            p *= p; // multiply p by itself
            if ( n % 2 == 1 ) // ifnisodd
                p *= 3; // multiply p by 3
            return p;
        }
    }
}
