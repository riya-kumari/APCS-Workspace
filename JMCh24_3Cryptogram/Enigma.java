// import java.util.Arrays;

/**
 * Enigma maintains the lookup table and defines a constructor alongwith the
 * setSubstitution(int i, char ch) method should set the i-th element of the
 * lookup table to ch. The decode(String text) method decodes all the letters in
 * text according to the current lookup table. decode should leave all
 * characters that are not letters unchanged and preserve the upper or lower
 * case of letters. It should return the decoded string, which has the same
 * length as text. The getHints(String text, String lettersByFrequency) method
 * returns computer-generated hints for each letter in the encrypted text.
 * 
 * @author Riya Kumari
 * @version 2/8/19
 * 
 * @author Period - 5
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * Constructor
     * 
     * @param numLetters
     *            that is the number of letters in the alphabet
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * sets the i-th element of the lookup table to ch.
     * 
     * @param index
     *            is the element
     * @param ch
     *            is what its changed to
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    /**
     * decodes all the letters in text according to the current lookup table
     * 
     * @param text
     *            is what is being decoded
     * @return String - the decoded string
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        for ( int i = 0; i < text.length(); i++ )
        {
            /*
             * get the character at each pos
             * 
             * if its a letter if the char is uppercase buffer.append(
             * lookupTable[r - 'A'] ); else make it uppercase make the one
             * before it lowercase
             *
             * else just append that character
             */
            char a = text.charAt( i );
            if ( !Character.isLetter( a ) )
            {
                buffer.append( text.charAt( a ) );
            }
            else
            {
                if ( Character.isUpperCase( a ) )

                {
                    buffer.append( lookupTable[a - 'A'] );

                }
                else
                {

                    a = Character.toUpperCase( a );
                    buffer.append(
                        Character.toLowerCase( lookupTable[a - 'A'] ) );
                }

            }

        }

        return buffer.toString();
    }


    /**
     * Gives hints for what letter it could be
     * 
     * @param text
     *            is a string
     * @param lettersByFrequency
     *            counting occurrences for the 26 letters in the file sample.txt
     * @return String computer-generated hints for each letter in the encrypted
     *         text
     */
    public String getHints( String text, String lettersByFrequency )
    {

        /*
         * First it counts the number of occurrences for each of the letters ‘a’
         * through ‘z’ in text (case blind) and saves these 26 counts in an
         * array.
         * 
         * increment through the lookup table create a var increment throught
         * the look up table again if the second increment is greater than the
         * first one then var = second inc
         * 
         */
        int[] a = countLetters( text );
        char[] holder = new char[lookupTable.length];
        int i = 0;

        while ( i < lookupTable.length )
        {
            int var = 0;
            int j = 0;
            while ( j < lookupTable.length )
            {
                if ( a[var] > a[j] )
                {
                    var = j;
                }
                j++;
            }
            a[var] = Integer.MAX_VALUE;
            holder[var] = lettersByFrequency.charAt( i );
            i++;
        }
        String toReturn = "";

        for ( char random : holder )
        {
            toReturn += random;
        }
        return toReturn;

    }


    /**
     * Counts the number of times a letter exists
     * 
     * @param text
     *            is a String
     * @return int[]
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        /*
         * traverse through text check if it is a letter if so do -->
         * counts[char - A]; else counts[char -a]
         * 
         */
        for ( int i = 0; i < text.length(); i++ )
        {
            char a = text.charAt( i );

            if ( Character.isLetter( a ) )
            {
                if ( a >= 'a' && a <= 'z' )
                {
                    counts[a - 'a']++;
                }
                if ( a >= 'A' && a <= 'Z' )
                {
                    counts[a - 'A']++;
                }
            }
        }
        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * Getter Method
     * 
     * @return char[] lookupTable
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * getter method
     * 
     * @param text
     *            is a string
     * @return int[] countLetters
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}