/**
 * this class extends the student class, 
 * and has a major and a year field for college students.
 * @author Chaaruhaas Kandregula
 * @version 11/1/2024
 */
public class CollegeStudent extends Student
{

    private String major;

    private int year;
    
    /**
     * Constructs a new CollegeStudent object
     * @param name name of object
     * @param age age of object
     * @param gender gender of object
     * @param idNum ID Number of object
     * @param gpa gpa of object
     * @param year year of object
     * @param major major of object
     */
    public CollegeStudent(String name, int age, String gender, 
                          String idNum, double gpa, int year, 
                          String major) {
        super(name, age, gender, idNum, gpa);
        this.major = major;
        this.year = year;
    }
    
    /**
     * returns the major this teacher object teaches
     * @return String major
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * returns the year this teacher object has
     * @return int year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * setter method for the major field
     * @param major String
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * setter method for the year field
     * @param year double
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year +
            ", major: " + major;
    }
}
