/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.response;

import com.solutech.trackae.utils.ReflectionUtils;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Office
 */
public class RestResponse {

    private HashMap<String, String> message = new HashMap<>();
    private boolean error;
    private Object modal;
    private String operation;
    private String errorType;

    public RestResponse() {
        error = false;
        this.operation = Operation.CREATE;
        this.errorType = ErrorType.NONE;
    }

    public RestResponse succeed() {
        this.error = false;
        return this;
    }

    public RestResponse operation(String operation) {
        this.operation = operation;
        return this;
    }

    public RestResponse errorType(String errorType) {
        this.errorType = errorType;
        return this;
    }

    public RestResponse failed() {
        error = true;
        return this;
    }

    public RestResponse modal(Object modal) {
        this.modal = modal;
        return this;
    }

    public HashMap<String, String> getMessage() {
        return message;
    }

    public void setMessage(HashMap<String, String> message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getModal() {
        return modal;
    }

    public void setModal(Object modal) {
        this.modal = modal;
    }

    public RestResponse putMessage(String key, String value) {
        message.put(key, value);
        return this;
    }

    public RestResponse removeMessage(Object key) {
        message.remove(key);
        return this;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    public static RestResponse inst(){
        return new RestResponse();
    }
}
