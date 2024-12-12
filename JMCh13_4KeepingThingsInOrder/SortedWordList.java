/**
   Implements a sorted list of words

   @author  Chaaruhaas Kandregula
   @version 12/9/2024

   @author Period - 3
   @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order

   @author Sources - None
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * No args constructor that initializes the ArrayList to its default size
     */
    public SortedWordList()
    {
        super();
    }

    /**
     * Constructor that initializes the ArrayList to the specified size
     * @param initialCapacity initial size of the ArrayList
     */
    public SortedWordList(int initialCapacity)
    {
        super(initialCapacity);
    }

    /**
     * Adds the word to the list in the correct position
     * @param word word to be added
     * @param i index to add the word
     */
    public void add(int i, String word)
    {
        if ((i > 0 && word.compareToIgnoreCase(this.get(i-1)) <= 0) || (i < this.size() && word.compareToIgnoreCase(this.get(i)) >= 0)) {
            throw new IllegalArgumentException("word = " + word + " i = " + i);
        }
        super.add(i,word);
    }

    /**
     * Adds the word to the list in the correct position
     * @param word word to be added
     * @return true if the word was added, false otherwise
     */
    public boolean add(String word)
    {
        int start = 0, end = this.size();

        while (start < end)
        {
            int mid = (start + end) / 2;
            int difference = word.compareToIgnoreCase(get(mid));

            if (difference > 0)
                start = mid + 1;
            else if (difference < 0)
                end = mid;
            else
                return false;
        }
        super.add(end, word);
        return true;
    }

    /**
     * Returns the index of the word in the list, returning -1 if it doesn't exist
     * @param obj object to find
     */
    public int indexOf(Object obj) {
        return this.binarySearch((String)obj);
    }

    /**
     * Returns true if the list contains the word
     * @param obj object to find
     */
    public boolean contains(Object obj) {
        return this.binarySearch((String)obj) != -1;
    }

    /**
     * Sets the word at the specified index
     * @param i index of the word
     * @param word word to be added
     * @return word at the specified index
     */
    public String set(int i, String word) {
        if (word.compareToIgnoreCase(get(i)) < 0 || word.compareToIgnoreCase(get(i+1)) > 0) {
            throw new IllegalArgumentException("word = " + word + " i= " + i);
        } else {
            return super.set(i, word);
        }
    }

    private int binarySearch(String word) {
        int start = 0;
        int end = this.size() - 1;
        int mid = (start + end) / 2;
        
        while (start <= end) {
            mid = (start + end) / 2;
            
            if (word.compareToIgnoreCase(this.get(mid)) == 0) {
                return mid;
            } else if (word.compareToIgnoreCase(this.get(mid)) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;        

    }

    /**
     * Merges the additionalWords into the SortedWordList
     * @param additionalWords list of words to merge
     */
    public void merge(SortedWordList additionalWords) {

        for (String word : additionalWords) {
            this.add(word);
        }
    }

}
