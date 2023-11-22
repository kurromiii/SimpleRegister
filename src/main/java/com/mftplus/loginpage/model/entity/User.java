package com.mftplus.loginpage.model.entity;

import com.google.gson.Gson;

public  class User {
    private int id;
    private String name;
    private String family;
    private String userName;
    private String passWord;

    public User(String name, String family, String userName) {
        this.name = name;
        this.family = family;
        this.userName = userName;
    }

    public User() {
    }

    public User(String name, String family, String userName, String passWord) {
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public User setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public User setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
