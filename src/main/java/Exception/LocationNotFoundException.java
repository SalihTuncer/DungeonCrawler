package Exception;

public class LocationNotFoundException extends Exception {
    //input which caused exception
    private String cause;

    public LocationNotFoundException(String cause) {
        this.cause = cause;
    }

    public String toString() {
        return "LocationNotFoundException[" + this.cause + "]";
    }
}
