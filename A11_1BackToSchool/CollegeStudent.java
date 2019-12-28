/**
 * College student is like Student with extra features
 *
 *  @author  Riya Kumari
 *  @version Oct 20, 2018
 *  @author  Period: 5
 *  @author  Assignment: A11_1BackToSchool
 *
 *  @author  Sources: TODO
 */
public class CollegeStudent extends Student
{
   
    private String myMajor;

    private int myYear;

    /**
     * Constructs CollegeStudent
     * @param name String
     * @param age int
     * @param gender String
     * @param iDnum String
     * @param gpa double
     * @param year int
     * @param major String
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String iDnum,
        double gpa,
        int year,
        String major )
    {
        super( name, age, gender, iDnum, gpa );
        myMajor = major;
        myYear = year;
    }
    
    /**
     * Gets year
     * @return int year
     */
    public int getYear()
    {
        return myYear;
    }

/**
 * Gets major
 * @return String major
 */
    public String getMajor()
    {
        return myMajor;
    }

/**
 * Sets year 
 * @param year to set 
 */
    public void setYear( int year )
    {
        myYear = year;
    }

/**
 * Sets major
 * @param major to set
 */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: "
            + myMajor;
    }
}
