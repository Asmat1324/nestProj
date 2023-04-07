package nestProj.Lists;

import nestProj.ADTs.OrderedListADT;

/**
 * <p>Title: ArrayOrderedList.java</p>
 *
 * <p>Description: Represents an array implementation of an ordered list.</p>
 */
public class ArrayOrderedList<E> extends ArrayList<E> implements OrderedListADT<E>
{
    /**
     * default constructor --
     * creates an empty list using the default capacity.
     */
    public ArrayOrderedList()
    {
        super();
    }

    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity the initial size of the list as specified by the user
     */
    public ArrayOrderedList (int initialCapacity)
    {
        super(initialCapacity);
    }

    /**
     * add --
     * adds the specified Comparable item to this list, keeping
     * the items in sorted order. The size of the list should be expanded when full.
     * @param newItem a reference to the new item to be added to the list
     */
    public void add(E newItem)
    {
        if (size() == contents.length)
            expandCapacity();

        Comparable<E> temp = (Comparable<E>) newItem;
        int i = 0;
        while (i < count && temp.compareTo(contents[i]) > 0)
            i++;

        for (int j=count; j > i; j--)
            contents[j] = contents[j-1];

        contents[i] = newItem;
        count++;
    }

    /**
     * find --
     * overrides the find method in the parent class, ArrayList. The efficiency of this
     * method is improved by terminating the linear search once you have gone beyond the
     * position where the item might be found.
     * @param target a reference to the item to locate
     * @return the index of the specified target if it is found; -1 if it
     * is not found
     */
    //@SuppressWarnings("unchecked")
    //protected int find(E target)
    //{
    //	return -1;
    //}

    /**
     * binSearch --
     * locates and returns the target from the list if it is found
     * @param target a reference to an "initialized" item containing a value
     * for the key-field
     * @return a reference to the item from the list if found
     * @throws an EmptyListException if the list is empty
     * @throws an ElementNotFoundException if the target is not found
     */
    @SuppressWarnings("unchecked")
    public E binSearch(E target)
    {
        return null;
    }

}