package nestProj.Exceptions;

/**
 * Title: Date Exception
 * An exception thrown when a date is invalid.
 * @author Asmatullah Khan
 **/
public class DateException extends Exception
{
    public DateException()
    {
        super("Invalid date.");
    }
    public DateException(String message)
    {
        super(message);
    }
}
