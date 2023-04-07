package nestProj.Exceptions;


    public class EmptyListException extends RuntimeException{
        public EmptyListException(String message)
        {
            super("Element was not found.");
        }
    }

