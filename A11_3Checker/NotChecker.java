/*** Part (c) ***/
// TODO complete documentation

public class NotChecker
{
    private Checker c1;


    public NotChecker( Checker c )
    {
        c1 = c;
    }


    public boolean accept( String text )
    {
        return !c1.accept( text );
    }
}
