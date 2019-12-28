import java.util.Scanner;
import java.io.*;


/**
 * A class for calculating Statistics on a set of numbers.
 *
 * @author Riya Kumari
 * @version 10/30/18
 * @author Period: 5
 * 
 * @author Assignment: Lab Activity 16.1 - Statistics
 */
public class Statistics
{
    private final static int MAX_VALUE = 100;

    private int[] statsData = new int[1000];

    private int howMany;


    /**
     * Constructs this object with an array of integers for use with statistical
     * calculation
     * 
     * @param fileName
     *            name of file containing numbers for statistical evaluation
     */
    public Statistics( String fileName )
    {
        howMany = 0;
        loadFile( fileName );
    }


    /**
     * Loads text file into array data. Values are stored from positions
     * 0..howMany-1. Returns the number of data values as howMany
     * 
     * @param fileName
     *            file or string containing numbers to read
     */
    public void loadFile( String fileName )
    {
        int index = 0;
        Scanner inFile;

        try
        {
            if ( new File( fileName ).isFile() )
            {
                inFile = new Scanner( new File( fileName ) );
            }
            else
            {
                inFile = new Scanner( fileName );
            }

            while ( inFile.hasNext() )
            {
                statsData[index] = inFile.nextInt();
                index++;
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
        howMany = index;
    }


    /**
     * Returns average of values in vector data.
     * 
     * @return average of this objects data collection
     */
    public double average()
    {
        double average = 0;
        double sum = 0;

        for ( int i = 0; i < howMany + 1; i++ )
        {
            sum += statsData[i];

        }
        average = sum / howMany;
        return average;
    }
    /*
     * public double average() { double total = 0; for ( int i = 0; i < howMany
     * + 1; i++ ) { total += statsData[i]; } return total / howMany; }
     */


    /**
     * Finds standard deviation of values in vector data.
     *
     * Determine the difference of each number from the average, and square each
     * difference. Sum all the differences. Divide this sum by (the number of
     * values - 1). Take the square root of the above division result from step
     * c.
     * 
     * @return the standard deviation of the vector data
     */
    public double stdDev()
    {
        double mean = average();
        double diff;
        double sum = 0;
        for ( int i = 0; i < howMany; i++ )
        {
            diff = mean - statsData[i];
            diff = diff * diff;
            sum = sum + diff;
        }
        double divide = ( sum / ( howMany - 1 ) );

        return Math.sqrt( divide );
    }


    /**
     * finds the largest integer in the array scores. This array is sized from
     * 0..MAX_VALUE, with each element storing the quantity of each number from
     * 0..MAX_VALUE.
     * 
     * @param scores
     *            integer array sized at MAX_VALUE+1 with each element storing
     *            the quantity of each number from 0..MAX_VALUE
     */
    public int findLargest( int[] scores )
    {

        int MAX_VALUE = scores[0];
        for ( int i = 0; i < scores.length; i++ )
        {
            if ( MAX_VALUE < scores[i] )
            {
                MAX_VALUE = scores[i]; // if the max value is less than the
                                       // index value it stores that value
                                       // instead
            }
        }
        return MAX_VALUE;
    }


    /**
     * The array data is analyzed and transferred into a smaller array smallList
     * (0..MAX_VALUE). For each occurrence of n in the array data, smallList[n]
     * is incremented +1. findLargest is then called to find the largest
     * quantity in the array smallList. The mode(s) is/are returned in an array.
     * 
     * @return array of mode(s)
     */
    public int[] findMode()
    {
        int maxValue = findLargest( statsData );
        int[] smallList = new int[maxValue + 1];
        int current = 0;

        for ( int i = 0; i < howMany; i++ ) // loops through each index and
                                            // counts the frequency of numbers
                                            // and stores it in smallList
        {
            // int n = statsData[i];
            // current = smallList[n];
            // smallList[n]= current+1;

            smallList[statsData[i]]++;

        }
        int quantity = findLargest( smallList ); // find the largest frequency
                                                 // in smallList

        int[] result = new int[smallList.length]; // new array to store the mode
        int count = 0;

        for ( int i = 0; i < smallList.length; i++ ) // stores all the possible
                                                     // modes in array result
        {
            if ( quantity == smallList[i] )
            {
                result[count] = i;
                count++;
            }
        }
        int[] finalResult = new int[count];
        for ( int i = 0; i < count; i++ )
        {
            finalResult[i] = result[i];
        }

        return finalResult;

    }


    public static void main( String[] args )
    {
        Statistics fileStats = new Statistics( "numbers.txt" );

        System.out.printf( "The average = %6.2f", fileStats.average() );
        System.out.println();
        System.out.printf( "Standard deviation = %6.2f",
            fileStats.stdDev() );
        System.out.println();

        int[] mode = fileStats.findMode();
        System.out.print( "The mode is(are) --> " );
        for ( int m : mode )
        {
            System.out.print( m + "  " );
        }
    }
}
