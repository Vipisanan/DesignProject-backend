package com.kelani.demo.exceptions;


public enum AGStatus {

    SUCCESS("S1000", "Success"),

    ERROR("E1000", "Unknown error occurred in operation"),
    DB_ERROR("E1002", "Unknown error occurred in database operation"),
    NO_ENTRY_FOUND("E1003", "Empty results from database"),
    MISSING_REQUIRED_PARAMS("E1004", "One or more required parameters are missing"),
    EMPTY_FILE("E1005", "Uploaded file is empty"),
    PARTIALLY_STORED1("E1006", "Images are parlially uploaded.Unknown error occurred in database operation"),
    PARTIALLY_STORED2("E1007", "Images are partially uploaded.One or more required parameters are missing"),
    EMAIL_ALREDY_EXIST("E1008", "The email you entered already has an account "),
    USER_NOT_FOUND("E1009", "The email id is not registered, must create a account"),
    AWS_ERROR("E1010", "Some error occurred with AWS server"),
    FILE_CONVERTION_ERROR("E1011", "Unknown error occurred while converting a file"),
    UNKOWN_OBJECT("E1012", "New object are not allowed"),
    ALREADY_EXIST("E1013", "The data you entered already exist "),

//    for voting system

    NO_VOTER_FOUND("V1000", "Invalid voter ID from database"),
    NO_USER_FOUND("U1000", "Invalid user finger print from database"),
    NO_CANDIDATE_FOUND("C1000", "Invalid Candidate ID from database"),


    //    Register election
    ALREADY_ACTIVE_ELECTION("E1014", "Already election activated"),
    ALREADY_DEACTIVATE_ELECTION("E1014", "Already election deactivated"),

    //    Candidate nomination
    PARTY_NOT_NOMINATED("E1015", "Party not valid");

    private final String statusCode;
    private final String statusDescription;


    AGStatus(String statusCode, String successDescription) {
        this.statusCode = statusCode;
        this.statusDescription = successDescription;
    }

    public static AGStatus getCCStatus(String statusCode) {
        for (AGStatus ccStatus : AGStatus.values()) {
            if (ccStatus.statusCode.equals(statusCode)) {
                return ccStatus;
            }
        }
        return SUCCESS;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public boolean isSuccess() {
        return this.statusCode.equals(AGStatus.SUCCESS.statusCode);
    }
}
