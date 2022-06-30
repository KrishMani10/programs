package mani.model;

public class User {
    private String userName;
    private String password;


    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}

