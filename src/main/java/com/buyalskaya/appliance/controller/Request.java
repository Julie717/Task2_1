package com.buyalskaya.appliance.controller;

import com.buyalskaya.appliance.model.entity.ApplianceType;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;

import java.util.StringJoiner;

public class Request {
    private String commandName;
    private ApplianceParameter applianceParameter;
    private String applianceParameterValue;
    private ApplianceType applianceType;

    public Request(String commandName, ApplianceType applianceType, ApplianceParameter applianceParameter) {
        this.commandName = commandName;
        this.applianceParameter = applianceParameter;
        this.applianceType = applianceType;
    }

    public Request(String commandName, ApplianceType applianceType, ApplianceParameter applianceParameter,
                   String ApplianceParameterValue) {
        this.commandName = commandName;
        this.applianceParameter = applianceParameter;
        this.applianceParameterValue = ApplianceParameterValue;
        this.applianceType = applianceType;
    }

    public Request(String commandName, ApplianceParameter applianceParameter) {
        this.commandName = commandName;
        this.applianceParameter = applianceParameter;
    }

    public Request(String commandName, ApplianceParameter applianceParameter, String ApplianceParameterValue) {
        this.commandName = commandName;
        this.applianceParameter = applianceParameter;
        this.applianceParameterValue = ApplianceParameterValue;
    }

    public Request(String commandName, ApplianceType applianceType) {
        this.commandName = commandName;
        this.applianceType = applianceType;
    }

    public Request(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public ApplianceParameter getApplianceParameter() {
        return applianceParameter;
    }

    public void setApplianceParameter(ApplianceParameter applianceParameter) {
        this.applianceParameter = applianceParameter;
    }

    public String getApplianceParameterValue() {
        return applianceParameterValue;
    }

    public void setApplianceParameterValue(String applianceParameterValue) {
        this.applianceParameterValue = applianceParameterValue;
    }

    public ApplianceType getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(ApplianceType applianceType) {
        this.applianceType = applianceType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Request request = (Request) obj;
        if ((commandName == null ^ request.commandName == null) ||
                (commandName != null && request.commandName != null && !commandName.equals(request.commandName))) {
            return false;
        }
        if ((applianceParameterValue == null ^ request.applianceParameterValue == null) ||
                (applianceParameterValue != null && request.applianceParameterValue != null
                        && !applianceParameterValue.equals(request.applianceParameterValue))) {
            return false;
        }
        return (applianceParameter == request.applianceParameter) &&
                (applianceType == request.applianceType);
    }

    @Override
    public int hashCode() {
        return commandName.hashCode() * 31 + applianceType.hashCode() +
                applianceParameter.hashCode() + applianceParameterValue.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
                .add("commandName='" + commandName + "'")
                .add("applianceParameter=" + applianceParameter)
                .add("applianceParameterValue='" + applianceParameterValue + "'")
                .add("applianceType=" + applianceType)
                .toString();
    }
}