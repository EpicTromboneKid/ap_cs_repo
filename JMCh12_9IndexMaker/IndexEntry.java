import java.util.ArrayList;

public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numsList;

    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    public IndexEntry(String word)
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    // Returns the word of this IndexEntry object.
    public String getWord()
    {
        return this.word;  // Fix this!!
    }

    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    public void add(int num)
    {
        boolean match = false;

        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) == num) {
                match = true;
            }
        }

        if (match == false) {
            numsList.add(num);
        }
    }

    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    public String toString()
    {
        String editedNumsToString = 
        return word + editedNumsToString;
    }
}
