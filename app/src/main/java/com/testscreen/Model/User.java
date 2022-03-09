package com.testscreen.Model;

public class User {
    String Name;
    String Email;
    String Contact;
    String Password;
    String Uid;


    public User() {
    }

    public User(String name, String email, String contact, String password, String uid) {
        Name = name;
        Email = email;
        Contact = contact;
        Password = password;
        Uid = uid;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
