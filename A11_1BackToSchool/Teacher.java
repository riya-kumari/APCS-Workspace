/**
 * 
 *  Teacher is like person with additional properties.
 *  
 *
 *  @author  Riya Kumari
 *  @version Oct 20, 2018
 *  @author  Period: 5
 *  @author  Assignment: A11_1BackToSchool
 */
public class Teacher extends Person
{

    private String mySubject;
    private double mySalary;
    
   /**
    * Constructs teacher with
    * @param name String
    * @param age int
    * @param gender String
    * @param subject String
    * @param salary double
    */
    public Teacher(
        String name,
        int age,
        String gender,
        String subject,
        double salary )
    {
        super( name, age, gender );
        mySalary = salary;
        mySubject = subject;
    }

    
   /**
    * Gets the value of subject
    * @return String mySubject
    */
    public String getSubject()
    {
        return mySubject;
    }
    /**
     * Gets the value of salary
     * @return double mySalary
     */
    public double getSalary()
    {
        return mySalary;
    }
   /**
  *Sets value of subject
    * @param subject is the value being passed to mySubject
    */
    public void setSubject(String subject)
    {
        mySubject = subject;
    }
   /**
    * Sets value of salary
    * @param salary is the value being passed to mySalary
    */
    public void setSalary(double salary)
    {
        mySalary = salary;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }
}
