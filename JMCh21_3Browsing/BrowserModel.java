import java.util.Stack;

/**
 * This is a class that models a very primitive browser. 
 * Topline is the top line, backstack stores the previous lines,
 * forwardstack stores the forward lines.
 * @author Chaaruhaas Kandregula
 * @version 1/17/2025
 */
public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;

    /**
     * initializes this browsermodel with the browserview view.
     * @param view the browserview to be used.
    */

    public BrowserModel(BrowserView view) {
        this.view = view;
        backStk = new Stack<>();
        forwardStk = new Stack<>();
        topLine = 0;
        view.update(topLine);
    }

    /**
     * moves the topLine to the previous line in the textLines list.
     * 
     */
    public void back() {
        if (hasBack()) {
            forwardStk.push(topLine);
            topLine = backStk.pop();
        }
        view.update(topLine);
    };

    /**
     * moves the topLine to the next line in the textLines list.
     */
    public void forward() {
        if (hasForward()) {
            backStk.push(topLine);
            topLine = forwardStk.pop();
        }
        view.update(topLine);
    };

    /**
     * moves the topLine to the first line in the textLines list.
     */
    public void home() {
        backStk.push(topLine);
        topLine = 0;
        view.update(topLine);
    };

    /**
     * moves the topLine to the specified line in the textLines list.
     * @param n the line number to move to.
     */
    public void followLink(int n) {
        backStk.push(topLine);
        topLine = n;
        view.update(topLine);
    };

    /**
     * @return true if the backStk is not empty.
     */
    public boolean hasBack() {
        return !backStk.isEmpty();
    };

    /**
     * @return true if the forwardStk is not empty.
     */
    public boolean hasForward() {
        return !forwardStk.isEmpty();
    };

    // The following are for test purposes only
    /**
     * return the backstack
     * @return the backstack
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * return the forwardstack
     * @return the forwardstack
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * return the top line
     * @return the top line
     */
    public int getTopLine()
    {
        return topLine;
    }
}

