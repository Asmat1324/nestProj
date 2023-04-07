package nestProj.Exceptions;

/**
 * Title: InsufficientQuantityException Exception
 * <p>Description: An exception which will be thrown when quantity is insufficient.</p>
 * @author Asmatullah Khan
 **/
public class InsufficientQuantityException extends RuntimeException
{
    public InsufficientQuantityException()
    {
        super("Invalid date.");
    }
    public InsufficientQuantityException(String message)
    {
        super(message);
    }
}
