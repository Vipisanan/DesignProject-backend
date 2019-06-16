package com.kelani.demo.Payload;


import com.kelani.demo.exceptions.AGStatus;

public class ApiResponse<T> {
    private String statusCode;
    private String statusDescription;
    private T content;

    public ApiResponse() {
        this.statusCode = AGStatus.SUCCESS.getStatusCode();
        this.statusDescription = AGStatus.SUCCESS.getStatusDescription();
    }

    public ApiResponse(T content) {
        this.statusCode = AGStatus.SUCCESS.getStatusCode();
        this.statusDescription = AGStatus.SUCCESS.getStatusDescription();
        this.content = content;
    }

    public ApiResponse(String statusCode, String statusDescription, T content) {
        this.statusCode = AGStatus.SUCCESS.getStatusCode();
        this.statusDescription = AGStatus.SUCCESS.getStatusDescription();
        this.content = content;
    }



    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", content=" + content +
                '}';
    }
}