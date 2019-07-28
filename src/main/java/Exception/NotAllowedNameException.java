package Exception;

public class NotAllowedNameException extends Exception {
    //input which caused exception
    private String cause;
    //necessary serialVersionUID because it implements Serializable too
    private static final long serialVersionUID = 3L;

    public NotAllowedNameException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "NotAllowedNameException[" + this.cause + "]";
    }
}
