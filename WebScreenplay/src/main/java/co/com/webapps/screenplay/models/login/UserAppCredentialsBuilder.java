package co.com.webapps.screenplay.models.login;

import co.com.webapps.screenplay.models.Builder;

public class UserAppCredentialsBuilder implements Builder<UserAppCredentials> {


    private String userName;
    private String password;

    public UserAppCredentialsBuilder(String name) {
        this.userName = System.getProperty(String.format("app.user.%s",name));
        this.password = System.getProperty(String.format("app.password.%s",name));
    }

    public static UserAppCredentialsBuilder getCredencials(String name){
        return new UserAppCredentialsBuilder(name);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public UserAppCredentials build() {
        return null;
    }
}
