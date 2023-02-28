package com.semanticsquare.thrillio.constants;
public enum UserType {
    USER("user"),
    EDITOR("editor"),
    CHIEF_EDITOR("chiefeditor");

    private String userType;
    private UserType(String userType){
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}