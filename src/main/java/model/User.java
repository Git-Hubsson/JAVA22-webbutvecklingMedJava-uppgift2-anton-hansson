package model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String randomInfo;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.randomInfo = randomInfo;
    }

    public String getRandomInfo() {
        return randomInfo;
    }

    public void setRandomInfo(String randomInfo) {
        this.randomInfo = randomInfo;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
