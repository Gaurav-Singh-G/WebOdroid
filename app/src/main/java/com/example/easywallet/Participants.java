package com.example.easywallet;

public class Participants {
    private String ID;
    private String EmailAdd;

    public Participants(String emailAdd) {
        EmailAdd = emailAdd;
    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

}
