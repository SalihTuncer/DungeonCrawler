package Exception;

public class LocationNotFoundException extends Exception {
    //input which caused exception
    private String cause;
    //necessary serialVersionUID because it implements Serializable too
    private static final long serialVersionUID = 2L;

    public LocationNotFoundException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "LocationNotFoundException[" + this.cause + "]";
    }
}
