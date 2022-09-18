package com.chano.personerosapp.Model;

import java.util.List;

public class Response<TEntity> {
    private boolean success;
    private TEntity result;
    private String displayMessage;
    private List<String> errorMessage;

    public Response() {
    }

    public Response(boolean success, TEntity result, String displayMessage, List<String> errorMessage) {
        this.success = success;
        this.result = result;
        this.displayMessage = displayMessage;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TEntity getResult() {
        return result;
    }

    public void setResult(TEntity result) {
        this.result = result;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }
}
