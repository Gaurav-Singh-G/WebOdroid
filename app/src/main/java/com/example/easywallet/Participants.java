package com.example.easywallet;

import android.text.Editable;

public class Participants {
    private Integer ID;
    private String EmailAdd;

    public Participants(String emailAdd) {
        EmailAdd = emailAdd;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

}
