package nestProj;

/**
 * <p>Title: The Date Class</p>
 *
 * <p>Description: Objects of this type can store a month, day, and year as integers.
 * The class provides accessors and mutators for all instance variables along with
 * a toString method.</p>
 *
 * @author Asmatullah Khan
 */
public class Date implements Comparable<Object>
{
    private int dMonth;		//variable to store the month
    private int dDay;		//variable to store the day
    private int dYear;		//variable to store the year

    /**
     * default constructor --
     * sets month, day, and year to 1, 1, and 1800 respectively
     */
    public Date()
    {
        dMonth = 1;
        dDay = 1;
        dYear = 1800;
    }

    /**
     * parameterized constructor --
     * sets month, day, and year to user specified values
     * @param month value to be stored as this object's month
     * @param day value to be stored as this object's day
     * @param year value to be stored as this object's year
     */
    public Date(int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }
    /**
     * parameterized constructor --
     * sets month, day, and year to values specified in the provided string
     * @param date - written date which will then be converted
     */
    public Date(String date)
    {
        dMonth = Integer.parseInt(date.substring(0, date.indexOf("/")));
        dDay = Integer.parseInt(date.substring(date.indexOf("/") + 1, date.lastIndexOf("/")));
        dYear = Integer.parseInt(date.substring(date.lastIndexOf("/") + 1, date.length()));
    }
    /**
     * setDate --
     * stores month, day, and year by calling the setMethods defined
     * @param month value to be stored as this object's month
     * @param day value to be stored as this object's day
     * @param year value to be stored as this object's year
     */
    public void setDate(int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    /**
     * setMonth --
     * stores the user specified value as the month
     * @param month the value to be stored
     */
    public void setMonth(int month)
    {
        dMonth = month;
    }

    /**
     * setDay --
     * stores the user specified value as the day
     * @param day the value to be stored
     */
    public void setDay(int day)
    {
        dDay = day;
    }

    /**
     * setYear --
     * stores the user specified value as the year
     * @param year the value to be stored
     */
    public void setYear(int year)
    {
        dYear = year;
    }

    /**
     * getMonth --
     * accessor for the month
     * @return returns the value stored as the month
     */
    public int getMonth()
    {
        return dMonth;
    }

    /**
     * getDay --
     * accessor for the day
     * @return returns the value stored as the day
     */
    public int getDay()
    {
        return dDay;
    }

    /**
     * getYear --
     * accessor for the year
     * @return returns the value stored as the year
     */
    public int getYear()
    {
        return dYear;
    }

    public int compareTo(Object cT)
    {
        if(getYear() != ((Date)cT).getYear())
        {
            return getYear() - ((Date)cT).getYear();
        }
        else
        {
            if(getMonth() != ((Date)cT).getMonth())
            {
                return getMonth() - ((Date)cT).getMonth();
            }
            else
            {
                if(getDay() != ((Date)cT).getDay())
                {
                    return getDay() - ((Date)cT).getDay();
                }
                else
                {
                    return 0;
                }
            }
        }
    }
    /**
     * equals method --
     * determines if two Products have the same month day and year.
     * @param equalsCheck is a reference to a Date object
     * @return true if the two objects contain the same values for the month day and year
     */
    public boolean equals(Date equalsCheck)
    {
        if(dMonth == equalsCheck.getMonth() && dDay == equalsCheck.getDay() && dYear == equalsCheck.getYear())
        {
            return true;
        }
        return false;
    }

    /**
     * toString --
     * returns the month, day, and year in the format: mm-dd-yyyy;
     * leading zeros are NOT contained within the string
     * @return a String containing the date in month-day-year format
     */
    public String toString()
    {
        return (dMonth + "-" + dDay + "-" + dYear);
    }

}


