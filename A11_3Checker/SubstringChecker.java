/*** TODO Part (a) ***/

public class SubstringChecker implements Checker
{
    String toMatch = "";

    Checker aChecker = new SubstringChecker( "artichokes" );

    Checker kChecker = new SubstringChecker( "kale" );

    Checker yumChecker;


    public SubstringChecker( String s )
    {
        toMatch = s;
    }


    public boolean accept( String text )
    {
        return text.contains( toMatch );
    }

}
