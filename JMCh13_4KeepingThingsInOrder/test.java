
public class test
{
    private static int multiplications = 0;

    private static int x = 0;


    //
    public static int mysterySum(int n)
    {
      if (n == 1)
        return 1;
      else
        return mysterySum(n - 1) + 2*n - 1;
    }


    public static void main( String args[] )
    {
       System.out.print( mysterySum( 10 ) ); 

    }
}
