package nestProj.Exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(String message)
    {
        super("The target element is not in this list.");
    }
}

