import java.util.TreeMap;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Riya Kumari
 * @version 2/1/19
 * 
 * @author Period - 5
 * @author Assignment - JMCH23_6MorseCode
 * 
 */
public class MorseCode
{
    private static final char DOT = '.';

    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;

    private static TreeNode<Character> decodeTree;


    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>( ' ', null, null ); // autoboxing

        addSymbol( 'A', ".-" );
        addSymbol( 'B', "-..." );
        addSymbol( 'C', "-.-." );
        addSymbol( 'D', "-.." );
        addSymbol( 'E', "." );
        addSymbol( 'F', "..-." );
        addSymbol( 'G', "--." );
        addSymbol( 'H', "...." );
        addSymbol( 'I', ".." );
        addSymbol( 'J', ".---" );
        addSymbol( 'K', "-.-" );
        addSymbol( 'L', ".-.." );
        addSymbol( 'M', "--" );
        addSymbol( 'N', "-." );
        addSymbol( 'O', "---" );
        addSymbol( 'P', ".--." );
        addSymbol( 'Q', "--.-" );
        addSymbol( 'R', ".-." );
        addSymbol( 'S', "..." );
        addSymbol( 'T', "-" );
        addSymbol( 'U', "..-" );
        addSymbol( 'V', "...-" );
        addSymbol( 'W', ".--" );
        addSymbol( 'X', "-..-" );
        addSymbol( 'Y', "-.--" );
        addSymbol( 'Z', "--.." );
        addSymbol( '0', "-----" );
        addSymbol( '1', ".----" );
        addSymbol( '2', "..---" );
        addSymbol( '3', "...--" );
        addSymbol( '4', "....-" );
        addSymbol( '5', "....." );
        addSymbol( '6', "-...." );
        addSymbol( '7', "--..." );
        addSymbol( '8', "---.." );
        addSymbol( '9', "----." );
        addSymbol( '.', ".-.-.-" );
        addSymbol( ',', "--..--" );
        addSymbol( '?', "..--.." );
    }


    /**
     * Inserts a letter and its Morse code string into the encoding map and
     * calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol( char letter, String code )
    {
        codeMap.put( letter, code );
        treeInsert( letter, code );
    }


    /**
     * Inserts a letter and its Morse code string into the decoding tree. Each
     * dot-dash string corresponds to a path in the tree from the root to a
     * node: at a "dot" go left, at a "dash" go right. The node at the end of
     * the path holds the symbol for that code string.
     */
    private static void treeInsert( char letter, String code )
    {
        TreeNode<Character> a = decodeTree;
        /*
         * Traverse through code 
         * if code.charAt is '.' 
         *      check if left is null 
         *      yes --> new TreeNode<Character>( ., null, null ) ; and char.getLeft
         * 
         * else check if code.charAt is a - 
         *          yes-->new TreeNode<Character>( -,null, null ) ; 
         *          char.getRight
         * 
         * and then in the end you set the value equal to letter
         */

        for ( int i = 0; i < code.length(); i++ )
        {

            if ( code.charAt( i ) == '.' )
            {
                if ( a.getLeft() == null )
                {
                    a.setLeft(
                        new TreeNode<Character>( '.', null, null ) );

                }
                a = a.getLeft();
            }
            else if ( code.charAt( i ) == '-' )
            {
               // System.out.println("error : " + a.getValue());
                if ( a.getRight() == null )
                {
                a.setRight( new TreeNode<Character>( '-', null, null ) );
                }
                a = a.getRight();
            }
           

        }
        a.setValue( letter );
    }

    


    /**
     * Converts text into a Morse code message. Adds a space after a dot-dash
     * sequence for each letter. Other spaces in the text are transferred
     * directly into the encoded message.
     *
     * @return the encoded message.
     */
    public static String encode( String text )
    {
        StringBuffer morse = new StringBuffer( 400 );
        /*
         * traverse throught the text
         *   get the first letter
         *   if (text = space)
         *      morse += " ";
         *   add codeMap.getCode(firstLetter) to morse + " "
         */
        for ( int i = 0; i < text.length(); i++ )
        {
            char currentLetter = text.charAt( i );
            if ( currentLetter == ' ' )
            {
                morse.append( " " );

            }
            else
            {
                morse.append( codeMap.get( Character.toUpperCase( currentLetter ) ) );
                morse.append( " " );
            }

        }

        return morse.toString();
    }


    /**
     * Converts a Morse code message into a text string. Assumes that dot-dash
     * sequences for each letter are separated by one space. Additional spaces
     * are transferred directly into text.
     *
     * @return the plain text message.
     */
    public static String decode( String morse )
    {
        StringBuffer text = new StringBuffer( 100 );
        TreeNode<Character> a = decodeTree;
        
        for ( int i = 0; i < morse.length(); i++ )
        {
            char currentCode = morse.charAt( i );
            
            if ( currentCode == '.' )
            {
             //   System.out.print( currentCode );

                a = a.getLeft();
                            }
            else if ( currentCode == '-' )
            {
                a = a.getRight();
            }
            
            else
            {
                text.append( a.getValue()  );
                a = decodeTree;
            }
            

        }

        return text.toString();
    }


    // --------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }


    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}
