package exception;

public class UnsupportedObjectException extends Exception {
    public UnsupportedObjectException() {
    }

    public UnsupportedObjectException(String s) {
        super(s);
    }

    public UnsupportedObjectException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UnsupportedObjectException(Throwable throwable) {
        super(throwable);
    }

    public UnsupportedObjectException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
