package Exception;

public class ItemNotFoundException extends Exception {
    //input which caused exception
    private String cause;

    public ItemNotFoundException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "ItemNotFoundException[" + this.cause + "]";
    }
}
