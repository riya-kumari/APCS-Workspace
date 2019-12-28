import java.util.*;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author Riya Kumari
 * @version 10/12/18
 * 
 * @author Period 5
 * @author Assignment - Ch10Exercises
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    /**
     * A method that returns true if a given string is not empty and ends with a
     * star ('*')
     * 
     * @param s
     *            is the given string
     * @return boolean true or false
     */
    public boolean endsWithStar( String s )
    {

        if ( s.endsWith( "*" ) && !s.isEmpty() )
            return true;
        else
            return false;
    }


    /**
     * a method that returns true if a given string has at least two characters
     * and ends with two stars
     * 
     * @param s
     *            is the given string
     * @return boolean true or false
     */
    public boolean endsWith2Stars( String s )
    {
        if ( s.length() >= 2 && s.endsWith( "**" ) )
            return true;
        else
            return false;
    }


    /**
     * Takes a string as a parameter, moves the first character to the end of
     * the string, and returns the new string.
     * 
     * @param s
     *            is the given string
     * @return String str with the desired output
     */
    public String scroll( String s )
    {
        String str = "";
        str = s.substring( 1, s.length() ) + s.charAt( 0 );

        return str;
    }


    /**
     * Takes a string and returns a string where the first name is placed first
     * followed by one space and then the last name
     * 
     * @param name
     *            is the input
     * @return String converted name
     */
    public String convertName( String name )
    {
        String result = "";
        String firstName = name.substring( name.lastIndexOf( "," ) + 2,
            name.length() );
        String lastName = name.substring( 0, name.lastIndexOf( "," ) );

        return firstName + " " + lastName;
    }


    /**
     * takes such a string and makes and returns a â€œnegativeâ€� string in
     * which all the 0â€Ÿs are replaced with 1â€Ÿs and all the 1â€Ÿs with 0â€Ÿs
     * 
     * @param str
     *            is the given string
     * @return String that is negated
     */
    public String negate( String str )
    {
        String result = "";
        for ( int i = 0; i < str.length(); i++ )
        {
            if ( str.charAt( i ) == '0' )
            {
                result += 1;
            }
            else if ( str.charAt( i ) == '1' )
            {
                result += 0;
            }

        }

        return result;
    }


    /**
     * Determines whether all the characters in a string are the same
     * 
     * @param s
     *            is the given string
     * @return boolean true or false
     */
    public boolean isConstant( String s )
    {
        String str = "";
        str = s.substring( 1, s.length() ) + s.charAt( 0 );
        return s.contentEquals( str );

    }


    /**
     * Finds comments and removes them
     * 
     * @param str
     *            is the given string
     * @return String without the comments
     */
    public String removeComment( String str )
    {
        String result1, result2 = "";
        if ( str.contains( "/*" ) && str.contains( "*/" ) )
        {
            int firstComment = str.indexOf( "/*" );
            int secondComment = str.indexOf( "*/" );
            result1 = str.substring( firstComment, secondComment + 2 );
            result2 = str.replace( result1, "" );

            return result2;
        }
        else
        {
            return str;
        }

    }


    /**
     * Removes the first occurrence of a given substring (if found) from a given
     * string
     * 
     * @param s
     *            the given string
     * @param s2
     *            substring that is being removed
     * @return String final
     */
    public String cutOut( String s, String s2 )
    {

        String result = s.replaceFirst( s2, "" );

        return result;

    }


    /**
     * Removes html tags from text
     * 
     * @param str
     *            given text
     * @return String without html tags
     */
    public String removeHtmlTags( String str )
    {

        {
            int firstComment = str.indexOf( "<" );
            int secondComment = str.indexOf( ">" );
            String htmlTags = str.substring( firstComment,
                secondComment + 1 );
            String result1 = str.replace( htmlTags, "" );
            int lastComment = str.lastIndexOf( "</" );
            int lastComment2 = str.lastIndexOf( ">" );
            String htmlTag2 = str.substring( lastComment,
                lastComment2 + 1 );
            String result2 = result1.replace( htmlTag2, "" );

            return result2;

        }
    }


    /**
     * tests whether a given string contains only digits.
     * 
     * @param s
     *            is the given string
     * @return boolean true or false
     */
    public boolean onlyDigits( String s )
    {
        for ( int i = 0; i < s.length(); i++ )
            if ( !Character.isDigit( s.charAt( i ) ) )
            {
                return false;
            }

        return true;
    }


    /**
     * Checks if the given string is a valid isbn
     * 
     * @param isbn
     *            to be checked
     * @return boolean true or false
     */
    public static boolean isValidISBN( String isbn )
    {
        int coefficient = 10;
        int sum = 0;
        for ( int i = 0; i < isbn.length(); i++ )
        {
            char c = isbn.charAt( i );
            int digit = coefficient * Character.digit( c, 10 );
            sum += digit;
            coefficient--;
            if ( ( i == 10 && sum % 11 == 0 ) || ( c == 'X' ) )
            {

                return true;
            }

        }
        return false;

    }


    /**
     * Shuffles the characters of a string
     * 
     * @param s
     *            is the given string
     * @return String shuffled
     */
    public String shuffle( String s )
    {
        StringBuffer abc = new StringBuffer( s );
        int n = abc.length();
        while ( n > 1 )
        {
            int rand = (int)( Math.random() * n );
            abc.setCharAt( n - 1, abc.charAt( rand ) );
            abc.setCharAt( rand, abc.charAt( n - 1 ) );

            n--;

        }
        return abc.toString();
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out
                .println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out
                .println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out
                .println( "   (7) 10-10 removeComment( String str )" );
            System.out
                .println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out
                .println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out
                .println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star
                            + ") = " + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out
                            .println( "endsWithStar(" + ends0Star + ") = "
                                + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out
                            .println( "endsWith2Stars(" + end2Str + ") = "
                                + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println( "endsWith2Stars("
                            + endsWith1Star + ") = "
                            + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println(
                            "scroll(\"" + scrollStr + "\") --> " + "\""
                                + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\""
                                + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println(
                            "negate(\"" + negStr + "\") --> " + "\""
                                + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println(
                            "isConstant(\"" + constStr1 + "\") = "
                                + exercise.isConstant( constStr1 ) );
                        System.out.println(
                            "isConstant(\"" + constStr2 + "\") = "
                                + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println( "removeComment(\"" + comment
                            + "\") --> " + "\""
                            + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment
                            + "\") --> " + "\""
                            + exercise.removeComment( notComment )
                            + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \""
                            + cutOutstr + "\") --> " + "\""
                            + exercise.cutOut( cutstr, cutOutstr )
                            + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println( "removeHtmlTags(\"" + htmlStr
                            + "\") --> " + "\""
                            + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr
                            + "\") = " + exercise.onlyDigits( digitStr ) );
                        System.out.println( "onlyDigits(\"" + dStr
                            + "\") = " + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println(
                            "isValidISBN(\"" + validISBN + "\") = "
                                + exercise.isValidISBN( validISBN ) );
                        System.out.println(
                            "isValidISBN(\"" + invalidISBN + "\") = "
                                + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        // String str = "The quick brown fox";
                        String str = "abcd";
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
