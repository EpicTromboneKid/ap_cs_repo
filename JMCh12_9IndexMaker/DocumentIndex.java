import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * this class allows you to make an index from a document
 * @author Chaaruhaas Kandregula
 * @version 11/20/24
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{

    //  Creates an empty DocumentIndex with the default
    // initial capacity.

    /**
     * constructs an empty docindex with the default inital capacity
     */
    public DocumentIndex()
    {
       super(); 
    }

    /**
     * Creates an empty DocumentIndex with a given 
     * initial capacity.
     * @param initialCapacity initial capacity
     */
    public DocumentIndex(int initialCapacity)
    {
        super(initialCapacity);
    }

    /**  If word is not yet in this DocumentIndex,
     *  creates a new IndexEntry for word, and inserts
     *  it into this list in alphabetical order;
     *  adds num to this word's IndexEntry by calling
     * its add(num) method.
     * @param word this is the word to add
     * @param num this is the page number to add
     */  
    public void addWord(String word, int num)
    {

        boolean match = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getWord().equalsIgnoreCase(word)) {
                this.get(i).add(num);
                match = true;
            }
        }

        if (!match) {
            IndexEntry newOne = new IndexEntry(word);
            newOne.add(num);
            this.add(newOne);
        }

        Collections.
            sort(this, (o1, o2) -> o1.
                getWord().
                compareToIgnoreCase(o2.getWord()));
    }

    /**  For each word in str, calls addWord(word, num).
     *   @param str this is the string to analyze
     *   @param num this is the line number
     */ 
    public void addAllWords(String str, int num)
    {
        String[] stringArray = str.split(" ");

        for (String word : stringArray) {
            addWord(word, num);
        }   
    }


    /**
     * returns the index of the word where it should be inserted
     * @param word insert word
     * @return index
     */
    private int foundOrInserted(String word) {
        return 0;
    }
}
