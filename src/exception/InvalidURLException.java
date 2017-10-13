package exception;

public class InvalidURLException extends Exception {
    public InvalidURLException() {
    }

    public InvalidURLException(String s) {
        super(s);
    }

    public InvalidURLException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidURLException(Throwable throwable) {
        super(throwable);
    }

    public InvalidURLException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
