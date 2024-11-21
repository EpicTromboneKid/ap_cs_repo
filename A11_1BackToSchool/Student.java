public class Student extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average

    public Student( String name, int age, String gender, String idNum,
                    double gpa )
    {
        // use the super class's constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }

    /**
     * Getter method for ID number
     * @return ID number of this Student instance
     */
    public String getIdNum()
    {
        return myIdNum;
    }
    /**
     * getter method for GPA of student
     * @return GPA of this Student instance
     */
    public double getGPA()
    {
        return myGPA;
    }
    /**
     * setter method for the ID number of this Student instance
     * @param idNum the ID number to be set in this Student instance
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }
    /**
     * setter method for the GPA of this Student instance
     * @param gpa the GPA to be set for this Student instance
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " +
            myIdNum + ", gpa: " + myGPA;
    }
}
