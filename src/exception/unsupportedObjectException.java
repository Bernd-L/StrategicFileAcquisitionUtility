package exception;

public class unsupportedObjectException extends Exception {
    public unsupportedObjectException() {
    }

    public unsupportedObjectException(String s) {
        super(s);
    }

    public unsupportedObjectException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public unsupportedObjectException(Throwable throwable) {
        super(throwable);
    }

    public unsupportedObjectException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
