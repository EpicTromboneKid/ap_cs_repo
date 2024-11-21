public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

    /**
     * 
     * @param name the name of the person   
     * @param age the age of the person
     * @param gender the gender of the person
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

    /**
     * This is a getter for the name parameter for the Person
     * @return name of the Person
     */
    public String getName()
    {
        return myName;
    }

    /**
     * This is a getter for the age parameter of the Person
     * @return age of the person
     */
    public int getAge()
    {
        return myAge;
    }

    /**
     * This is a getter for the gender parameter of the Person
     * @return gender of the Person
     */
    public String getGender()
    {
        return myGender;
    }
    /**
     * this sets the name of this instance of Person
     * @param name Name to give the Person object
     */
    public void setName( String name )
    {
        myName = name;
    }

    /**
     * this sets the age of this Person instance
     * @param age age of the Person object
     */
    public void setAge( int age )
    {
        myAge = age;
    }

    /**
     * this is a setter method for the gender of this Person instance
     * @param gender gender of the Person object
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}