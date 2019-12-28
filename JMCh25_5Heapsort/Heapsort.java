
/**
 * A max heap and runs in O(n logn)
 * 
 * @author Riya Kumari
 * @version 3/10
 * 
 * @author Period - 5
 * @author Assignment - HeapSort
 * 
 * @author Sources - Me
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    public static void sort( double[] a )
    {
        /**
         * find the size build a heap thereby rearraging the array ,extract each
         * element, move the root to the end and call reheapDown
         * 
         * make the heap then go through each element and place it where it
         * should be
         * 
         */

        int n = a.length;

        for ( int i = n / 2; i >= 1; i-- )
        {
            reheapDown( a, i, n );

        }

        // System.out.println("exit is here ");

        // int n = a.length;

        while ( n > 1 )
        {
            double temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
            n--;
            reheapDown( a, 1, n );
        }

    }


    /**
     * 
     * To repair the order of the heap
     * 
     * @param a
     *            is the array
     * @param i
     *            root
     * @param n
     *            size
     */
    public static void reheapDown( double[] a, int i, int n )
    {

        /*
         * create a root, right variable, then the next node would just be will
         * just be right+1 check if root > right, if it is then swap them check
         * if root > right+1 and its greater than right --> return true check if
         * right is greater than the next node; if so swap eles just swap it
         * 
         * 
         */
        int root = i - 1;
        // int root = i - 1;
        // int right = 2 * root + 1; can't do this as the value of root changes
        double temp;
        while ( 2 * root + 1 < n )

        {

            int right = 2 * root + 1;
            if ( 2 * root + 2 == n )
                if ( a[root] > a[right] )
                    return;
                else
                {
                    temp = a[root];
                    a[root] = a[right];
                    a[right] = temp;
                    return;
                }

            if ( a[root] >= a[right] && a[root] >= a[right + 1] )
                return;

            if ( a[right] <= a[right + 1] )
            {
                temp = a[root];
                a[root] = a[right + 1];
                a[right + 1] = temp;
                root = right + 1;

            }

            else
            {
                temp = a[root];
                a[root] = a[right];
                a[right] = temp;
                root = right;
            }
        }
    }
}
