/**
 * Student.java
 * 
 * Stores the following information about students grade name (first and last)
 * Lynbrook id
 * 
 */
public class Student implements Comparable
{
    private String lynbrookId;

    private String firstName;

    private String lastName;

    private int grade;


    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }


    public Student()
    {
        this( "", "", "", 0 );
    }


    /**
     * first compare the grade of each student, and if the grades are equal then
     * compare Lynbrook id's
     * 
     * @param obj
     *            is the other student
     * @return
     */
    public int compareTo( Object obj )
    {

        if ( this.grade == ( (Student)obj ).grade )

        {

            return lynbrookId.compareTo( ( (Student)obj ).lynbrookId );

        }

        int diff = this.grade - ( (Student)obj ).grade;

        return diff;
    }


    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }


    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
