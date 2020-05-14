package com.example.home;

public class User {
    private String name;
    private String mail;
    private String password;
    private String number;

    public User(String name, String mail, String password, String number) {
        this.name=name;
        this.mail=mail;
        this.password=password;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
