/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what
 *       abstraction it represents, and how to use it.
 *
 *  @author  TODO your name
 *  @version TODO date
 *  @author  Period: TODO your period
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class Book
{
    // TODO implement data fields

    private int numPages, currentPage;
    
    // TODO implement constructor
    public Book(int size) {
        this.numPages = size;
        this.currentPage = 1;        
    }
    
    // TODO implement methods

    public int getNumPages() {
        return this.numPages;
    }

    public int getCurrentPage(){
        return this.currentPage;
    }

    public void nextPage() {
        if (currentPage < numPages){
            currentPage++;
        }
    }
}
