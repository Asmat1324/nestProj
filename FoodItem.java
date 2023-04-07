package nestProj;

/**
 * <p>Title: The FoodItem Class</p>
 *
 * <p>Description: Objects of this type can store a quantity of type int and an expiration date of type date.
 * The class provides accessors and mutators for all instance variables along with
 * a toString method.</p>
 *
 * @author Asmatullah Khan
 */
public class FoodItem implements Comparable<Object>
{
    private int quantity;			//Variable to store the quantity
    private Date expirationDate;	//Variable to store the expiration date

    /**
     * parameterized constructor --
     * sets quantity and expirationDate to provided parameters
     */
    public FoodItem(int q, Date eD)
    {
        quantity = q;
        expirationDate = eD;
    }

    /**
     * getQuantity --
     * accessor for the quantity
     * @return returns the value stored as the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * getExpirationDate --
     * accessor for the expirationDate
     * @return returns the value stored as the expiration date
     */
    public Date getExpirationDate()
    {
        return expirationDate;
    }

    /**
     * updateQuantity --
     * stores the user specified value as the quantity
     * @param newQuantity the value to be stored
     */
    public void updateQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }

    /**
     * equals method --
     * determines if two foodItems have the same quantity and expirationDate
     * @param equalsFoodItem is a reference to an object
     * @return true if the two objects contain the same values
     */
    public boolean equals(Object equalFoodItem)
    {
        if(expirationDate.equals(((FoodItem)equalFoodItem).getExpirationDate()))
        {
            return true;
        }
        return false;
    }
    /**
     * isExpired --
     * Determines if a foodItem is expired
     * @param currDate - The date that will be used to check expiration
     * @return a boolean value of true or false depending on if the item is expired
     */
    public boolean isExpired(Date currDate)
    {
        if(expirationDate.compareTo(currDate) <= 0)
            return true;
        else
            return false;
    }
    /**
     * compareTo --
     * compares the expiration dates to check which comes first
     * @param comDate - date that will be used to compare with
     * @return an integer value that is either greater, less , or equal to the items expirationDate
     */
    public int compareTo(Object comDate)
    {
        return expirationDate.compareTo(((FoodItem)comDate).getExpirationDate());
    }
    /**
     * toString --
     * returns the product quantity and expiration date
     * @return a String containing the quantity and expiration date
     */
    public String toString()
    {
        return "-----------------------------------------------------\nProduct quantity: " +  quantity + "\nProduct expirationDate: " + expirationDate + "\n-----------------------------------------------------";
    }
}

