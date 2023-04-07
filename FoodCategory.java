package nestProj;

import nestProj.Exceptions.InsufficientQuantityException;
import nestProj.Exceptions.EmptyListException;
import nestProj.Lists.ArrayOrderedList;

/**
     * <p>Title: The FoodCategory Class</p>
     *
     * <p>Description: Objects of this type can store a category name of type String and a list of items of type FoodItem.
     * The class allows an ordered list of an item to be made and then have modifications made to it.</p>
     *
     * @author Asmatullah Khan
     */
    public class FoodCategory
    {
        private String categoryName;                //Will store the name of the category
        private ArrayOrderedList<FoodItem> items;   //Will store the items with different expiration dates

        /**
         * FoodCategory -- Parameterized constructor that will give the category a name.
         * @param catName - The name of the category
         */
        public FoodCategory(String catName)
        {
            categoryName = catName;
            items = new ArrayOrderedList<FoodItem>();
        }

        /**
         * addItem --
         * Adds items to the category
         * @param aI - the item that is to be added to the list
         */
        public void addItem(FoodItem aI)
        {
            if(items.contains(aI) == false)
            {
                items.add(aI);
            }
            else
            {
                FoodItem temp =  items.remove(aI);
                temp.updateQuantity(aI.getQuantity() + temp.getQuantity());
                items.add(temp);
            }
        }

        /**
         * deleteItems --
         * deletes the given number of items from the category
         * @param the given number of items to be removed
         * @return the quantity of the items removed
         */
        public int deleteItems(int amt)
        {
            int amtRemoved = amt;
            //System.out.println(items.size());
            if(items.isEmpty())
            {
                throw new EmptyListException("List is empty");
            }
            while(!items.isEmpty() && items.first().getQuantity() <= amt)
            {
                amt = amt - items.first().getQuantity();
                items.removeFirst();
            }
            if(items.isEmpty() && amt > 0)
            {
                throw new InsufficientQuantityException("\nThe quantity you requested, "+ amtRemoved + ", is not available. You were given " + (amtRemoved - amt) + " "+ getCategoryName() + " instead.");
            }
            items.first().updateQuantity(items.first().getQuantity() - amt);

            return amtRemoved;
        }
        /**
         * deleteExpiredItems --
         * Checks for and deletes all expired items
         * @param The date which will be used to check for expiration
         * @return a list of items that were removed
         */
        public ArrayOrderedList<FoodItem> deleteExpiredItems(Date expirDate)
        {
            //System.out.println(items.size());
            ArrayOrderedList<FoodItem> returnVal = new ArrayOrderedList<FoodItem>();
            ArrayOrderedList<FoodItem> tempItems = new ArrayOrderedList<FoodItem>();

            while(!items.isEmpty())
            {
                if(items.first().isExpired(expirDate))
                    returnVal.add(items.removeFirst());
                else
                    tempItems.add(items.removeFirst());
            }
            items = tempItems;
            return returnVal;
        }

        /**
         * equals method --
         * determines if two foodCategorys have the same name
         * @param eqCheck is a reference to an object
         * @return true if the two objects contain the same values
         */
        public boolean equals(Object eqCheck)
        {
            if(categoryName.equals(((FoodCategory)eqCheck).getCategoryName()))
                return true;
            else
                return false;
        }

        /**
         * getCategoryName--
         * accessor for the category name
         * @return returns the value stored as the category name
         */
        public String getCategoryName()
        {
            return categoryName;
        }

        /**
         * isEmpty --
         * determines whether or not the list is empty.
         * @return true if this list is empty; false otherwise
         */
        public boolean isEmpty()
        {
            return items.isEmpty();
        }

        /**
         * toString --
         * returns the category name along with all its contents
         * @return a String containing the category name and its contents
         */
        public String toString()
        {
            if(items.size() !=0)
            return categoryName + ": \n" + items;
            else
                return "The " + categoryName + " category is empty!\n";
        }
    }

