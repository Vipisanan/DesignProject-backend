package com.kelani.demo.exceptions;

public class AGException extends Exception {

    private static final long serialVersionUID = 1L;

    private AGStatus status;

    public AGException(AGStatus status) {
        super(status.getStatusDescription());
        this.status = status;
    }

    public AGStatus getStatus() {
        return status;
    }

    public void setStatus(AGStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AGException{" +
                "status=" + status +
                '}';
    }
}
