package api.pojos;

public class LoginRequest {
    private String emailId;
    private String password;

    public LoginRequest(String emailId, String password)
    {
        this.emailId = emailId;
        this.password = password;
    }

    public LoginRequest()
    {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public String getPassword()
    {
        return password;
    }
}
