package api.pojos;

public class UserDetailsRequest {
    private String email;

    public UserDetailsRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
