import java.util.Iterator;
import java.util.List;
import java.util.Objects.*;

/**
    Implements a singly-linked list.
    
    @author  Chaaruhaas Kandregula
    @version 12/15/2024
    
    @author  Period - 3
    @author  Assignment - SinglyLinkedList
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return java.util.Objects.isNull(head);  // fix this
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(node))
        {
            return false;
        }

        while (!java.util.Objects.isNull(node))
        {
            if (node.getValue().equals(obj))
            {
                return true;
            }
            node = node.getNext();
        }
        return false;  // fix this
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {
        ListNode<E> node = head;
        int count = 0;

        if (java.util.Objects.isNull(head))
        {
            return -1;
        }

        while (node != null)
        {
            if (node.getValue().equals(obj))
            {
                return count;
            }
            count++;
            node = node.getNext();
        }
        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(head))
        {
            head = new ListNode<E>(obj, null);
            nodeCount++;
            return true;
        }

        while (node.getNext() != null)
        {
            node = node.getNext();
        }

        node.setNext(new ListNode<E>(obj, null));
        nodeCount++;
        return true;  // fix this
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(node))
        {
            return false;
        }

        while (node.getNext() != null)
        {
            if (node.getNext().getValue().equals(obj))
            {
                node.setNext(node.getNext().getNext());
                nodeCount--;
                return true;
            }
            node = node.getNext();
        }
        return false;  // fix this
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(node) || i >= nodeCount || i < 0) {
            throw new IndexOutOfBoundsException();
        }
                
        while (i-- > 0)
        {
            node = node.getNext();
        }
        return node.getValue();  // fix this
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(node) || i >= nodeCount || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        while (i-- > 1)
        {
            node = node.getNext();
        }

        E old = node.getNext().getValue();
        node.setValue(obj);
        return old;  // fix this
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i > nodeCount || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> node = head;

        if (i == 0) {
            head = new ListNode<E>(obj, head);
            nodeCount++;
            return;
        }
        
        while (i-- >= 1)
        {
            node = node.getNext();
        }

        node.setNext(new ListNode<E>(obj, node.getNext()));

        nodeCount++;
    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {
        ListNode<E> node = head;

        if (java.util.Objects.isNull(head) || i >= nodeCount || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        E temp = get(i);
        
        while (i-- > 1)
        {
            node = node.getNext();
        }

    
        node.setNext(node.getNext().getNext());
        nodeCount--;
        return temp;  
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    {
        String outString = "[";

        ListNode<E> node = head;

        for (E something : this)
        {
            outString += something + ", ";
        }

        outString = outString.substring(0, outString.length() - 2);

        return outString + ']';  // fix this
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

