package com.mingrisoft.denglu;

public class User {
    private String name;            //用户名
    private String password;
    private String phone;//密码

    public User(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getname() {
        return name;
    }

    public String getpassword() {
        return password;
    }


    public String getphone() {
        return phone;
    }
}


