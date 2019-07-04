package com.kelani.demo.utils;

public enum  Roles {
    V("Voter"),
    EC("Election Commissioner"),
    PRO("Party Register Officer"),
    HOEC("Head of the Election Centre"),
    VRO("Voter Register Officer"),
    EO("Election Organizer"),
    EOF("Election Office"),  // like Admin
    CRO("Candidate Register Officer");


    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
