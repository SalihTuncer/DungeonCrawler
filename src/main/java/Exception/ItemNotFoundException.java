package Exception;

public class ItemNotFoundException extends Exception {
    //input which caused exception
    private String cause;
    //necessary serialVersionUID because it implements Serializable too
    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "ItemNotFoundException[" + this.cause + "]";
    }
}
