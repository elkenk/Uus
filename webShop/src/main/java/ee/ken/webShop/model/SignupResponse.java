package ee.ken.webShop.model;

public class SignupResponse {
    String message;
    boolean successful;

    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
