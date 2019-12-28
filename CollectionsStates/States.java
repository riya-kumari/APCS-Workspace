import java.util.*;


/**
 * Represents various States and their respective cities.
 *
 * @author Riya Kumari
 * @version 4/8/19
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 */
public class States
{
    private Map<String, Set<String>> theMap;


    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }


    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap( CityInfo theCity )
    {
        if ( theMap.get( theCity.state() ) != null )
        {
            theMap.get( theCity.state() ).add( theCity.city() );
        }
        else
        {
            theMap.put( theCity.state(), new TreeSet<String>() );
            theMap.get( theCity.state() ).add( theCity.city() );
        }

    }


    public void printOneState( String theState )
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));
        String state = "";
        for ( String a : theMap.get( theState ) )
        {
            if ( !state.contains( theState ) )
                state += theState + " ";
            state += a + " ";

        }
        System.out.println( state );

    }


    public void printAllStates()
    {
        // String result = "";
        for ( String a : theMap.keySet() )
        {

            printOneState( a );
        }

    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
