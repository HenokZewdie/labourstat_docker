package com.restapi.laborstats;



public class Error {
    private ErrorType error;

    public Error error(ErrorType error) {
        this.error = error;
        return this;
    }

    public ErrorType getError() {
        return error;
    }

    public void setError(ErrorType error) {
        this.error = error;
    }
}
