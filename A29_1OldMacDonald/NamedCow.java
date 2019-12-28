/**
 * 
 * @author Riya Kumari
 * @version Oct 30, 2018
 * @author Period: 5
 * @author Assignment: A29_1OldMacDonald
 * 
 */
class NamedCow extends Cow
{
    private String cowName = "";


    /**
     * Constructor
     * 
     * @param type
     *            the type of cow
     * @param name
     *            of the cow
     * @param sound
     *            is the sound the cow makes
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        cowName = name;
    }


    /**
     * Constructor 2
     * 
     * @param type
     *            they type of cow
     * @param sound
     *            is the sound the cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * returns the value of cowName
     * 
     * @return the name of the cow
     */
    public String getName()
    {
        return cowName;
    }
}
