package com.yusuf.spring.session;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -1147071706055416445L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
