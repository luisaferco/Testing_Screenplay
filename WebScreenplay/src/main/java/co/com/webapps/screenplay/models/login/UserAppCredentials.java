package co.com.webapps.screenplay.models.login;

public class UserAppCredentials {

    private String userName;
    private String password;

    public UserAppCredentials(UserAppCredentialsBuilder user){
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
