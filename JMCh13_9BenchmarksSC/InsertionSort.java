public class InsertionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Insertion Sort.
    public void sort( double[] a )
    {
        addSteps(1); // initialize n
        for ( int n = 1; n < a.length; n++ )
        {
            addSteps(3);
            // 1 - condition of for loop
            // 2 - increment n
            // 3 - Save the next element to be inserted:
            double aTemp = a[n];
            addSteps(1);
            // 1 - Going backward from a[n-1], shift elements to the
            // right until you find an element a[i] <= aTemp:
            int i = n;
            while ( i > 0 && aTemp < a[i - 1] )
            {
                addSteps(4);
                a[i] = a[i - 1];
                i--;
            }

            // Insert the saved element after a[i]:
            addSteps(1);
            a[i] = aTemp;
        }
    }
}

