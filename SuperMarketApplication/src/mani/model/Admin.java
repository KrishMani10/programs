package mani.model;

public class Admin {
    private String userName;
    private String password;

    Admin(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

    public Admin(){}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
