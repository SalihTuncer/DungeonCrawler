package Exception;

public class NotAllowedNameException extends Exception {
    //input which caused exception
    private String cause;

    public NotAllowedNameException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "NotAllowedNameException[" + this.cause + "]";
    }
}
