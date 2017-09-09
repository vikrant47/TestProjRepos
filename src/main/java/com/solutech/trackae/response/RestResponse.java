/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutech.trackae.response;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

/**
 *
 * @author Office
 */
public class RestResponse extends DefaultErrorAttributes {

    private HashMap<String, String> message = new HashMap<>();
    private boolean error;
    private Object modal;
    private String operation;
    private String errorType;
    private String flash;

    public RestResponse() {
        error = false;
        this.operation = Operation.CREATE;
        this.errorType = ErrorType.INFO;
    }

    /*
    Overriding default error response 
     */
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttributes.put("error", true);
        errorAttributes.put("errorType", ErrorType.EXCEPTION);
        //errorAttributes.put("exception",super.getError(requestAttributes));
        errorAttributes.put("flash", "Sorry! Something went wrong, Please try again");        
        return errorAttributes;
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

    public static RestResponse inst() {
        return new RestResponse();
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public RestResponse flash(String flash) {
        this.flash = flash;
        return this;
    }
}
