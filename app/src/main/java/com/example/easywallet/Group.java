package com.example.easywallet;

public class Group {
    private String GName;
    private String GDesc = "";

    public Group(String GName, String GDesc) {
        this.GName = GName;
        this.GDesc = GDesc;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getGDesc() {
        return GDesc;
    }

    public void setGDesc(String GDesc) {
        this.GDesc = GDesc;
    }
}
