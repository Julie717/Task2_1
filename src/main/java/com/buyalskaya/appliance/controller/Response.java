package com.buyalskaya.appliance.controller;

import com.buyalskaya.appliance.model.entity.Appliance;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Response {
    private boolean isCompletedSuccess;
    private String message = new String();
    private List<Appliance> appliances = new ArrayList<>();

    public Response() {
    }

    public Response(boolean isCompletedSuccess, String message) {
        this.isCompletedSuccess = isCompletedSuccess;
        this.message = message;
    }

    public Response(boolean isCompletedSuccess, List<Appliance> appliances) {
        this.isCompletedSuccess = isCompletedSuccess;
        this.appliances = appliances;
    }

    public Response(boolean isCompletedSuccess, String message, List<Appliance> appliances) {
        this.isCompletedSuccess = isCompletedSuccess;
        this.message = message;
        this.appliances = appliances;
    }

    public boolean isCompletedSuccess() {
        return isCompletedSuccess;
    }

    public void setCompletedSuccess(boolean completedSuccess) {
        isCompletedSuccess = completedSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Response response = (Response) obj;
        if ((message == null ^ response.message == null) ||
                (message != null && response.message != null && !message.equals(response.message))) {
            return false;
        }
        if ((appliances == null ^ response.appliances == null) ||
                (appliances != null && response.appliances != null && !appliances.equals(response.appliances))) {
            return false;
        }
        return isCompletedSuccess == response.isCompletedSuccess;
    }

    @Override
    public int hashCode() {
        return (isCompletedSuccess ? 1 : 0) + message.hashCode() * 31 + appliances.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Response.class.getSimpleName() + "[", "]")
                .add("isCompletedSuccess=" + isCompletedSuccess)
                .add("message='" + message + "'")
                .add("appliances=" + appliances)
                .toString();
    }
}