import java.util.Scanner;
import java.io.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO the date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 * @author Sources - TODO list collaborators
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out
                .println( "*** Can't create RamblecsDictionary.java ***" );
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     * 
     */
    public static void openInputFile( String fileName )
    {
        File a = new File( fileName );
        try
        {

            fileIn = new Scanner( a );
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "The file doesn't exist." );
            System.exit( 1 );
        }

    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     * 
     */
    public static void createOutputFile( String fileName )

    {
        File a = new File( fileName );

        try
        {

            fileOut = new PrintWriter( a );
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "The file doesn't exist." );
            System.exit( 1 );
        }
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {

        fileOut.println( "public class RamblecsDictionary" );
        fileOut.println( "{" );
        fileOut.println( "    public String words[] = " );
        fileOut.println( "    {" );

        String a = "";
        int num = 0;

        while ( fileIn.hasNext() )
        {
            a = fileIn.next();
            if ( a.length() >= MINLENGTH && a.length() <= MAXLENGTH )
            {

                fileOut.println( "        \"" + a.toUpperCase() + "\"," );
                num++;
            }
        }
        fileOut.println( "    };" );
        fileOut.println( "}" );

        return num; 
    }
}
