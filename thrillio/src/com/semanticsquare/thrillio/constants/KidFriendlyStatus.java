package com.semanticsquare.thrillio.constants;
public enum KidFriendlyStatus {
    APPROVED("approved"),
    REJECTED("rejected"),
    UNKNOWN("unknown");

    private final String kidFriendlystatus;

    private KidFriendlyStatus(String kidFriendlystatus){
        this.kidFriendlystatus = kidFriendlystatus;
    }

    public String getKidFriendlystatus() {
        return kidFriendlystatus;
    }
}