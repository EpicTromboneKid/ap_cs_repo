/**
 * this class extends the Person class, 
 * and has a Subject and a Salary field for Teachers.
 * @author Chaaruhaas Kandregula
 * @version 11/1/2024
 */
public class Teacher extends Person
{
    private String subject;
    private double salary;
    
    /**
     * Constructs an instance of teacher
     * @param name Teacher's name
     * @param age Teacher's age
     * @param gender Teacher's gender
     * @param subject Teacher's subject
     * @param salary Teacher's salary
     */
    public Teacher(String name, int age, String gender, 
                   String subject, double salary) {
        super(name, age, gender);
        this.subject = subject;
        this.salary = salary;
    }
    
    /**
     * returns the subject this teacher object teaches
     * @return String subject
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * returns the salary this teacher object has
     * @return double salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * setter method for the subject field
     * @param subject String
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * setter method for the salary field
     * @param salary double
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + subject +
            ", salary: " + salary;
    }
}
