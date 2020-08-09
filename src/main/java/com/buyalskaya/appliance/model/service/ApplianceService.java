package com.buyalskaya.appliance.model.service;

import com.buyalskaya.appliance.controller.Request;
import com.buyalskaya.appliance.creator.ApplianceCreator;
import com.buyalskaya.appliance.exception.DaoException;
import com.buyalskaya.appliance.exception.ServiceException;
import com.buyalskaya.appliance.model.dao.ApplianceDao;
import com.buyalskaya.appliance.model.dao.impl.ApplianceDaoImpl;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.parser.DataParser;
import com.buyalskaya.appliance.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceService {
    private final static String EQUALITY = "=";
    private final static String COMMA = ",";

    public List<Appliance> findAll() throws ServiceException {
        ApplianceDao applianceDao = new ApplianceDaoImpl();
        try {
            List<String> appliancesString = applianceDao.findAll();
            List<Appliance> appliances = createAppliancesFromStringList(appliancesString);
            if (appliances.isEmpty()) {
                throw new ServiceException("Appliance isn't found");
            }
            return appliances;
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
    }

    public List<Appliance> findAppliance(Request request) throws ServiceException {
        ApplianceDao applianceDao = new ApplianceDaoImpl();
        if (request.getApplianceType() == null) {
            throw new ServiceException("Appliance type is null");
        }
        String applianceType = request.getApplianceType().toString();
        try {
            List<String> appliancesString = applianceDao.findAppliance(applianceType);
            List<Appliance> appliances = createAppliancesFromStringList(appliancesString);
            if (appliances.isEmpty()) {
                throw new ServiceException("Appliance isn't found");
            }
            return appliances;
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
    }

    public List<Appliance> findAllByTag(Request request) throws ServiceException {
        ApplianceDao applianceDao = new ApplianceDaoImpl();
        DataValidator dataValidator = new DataValidator();
        if (request.getApplianceParameter() == null ||
                request.getApplianceParameterValue() == null) {
            throw new ServiceException("Incorrect searching parameters");
        }
        String applianceParameterName = request.getApplianceParameter().toString();
        if (!dataValidator.isParameterNameValid(applianceParameterName)) {
            throw new ServiceException("Incorrect appliance parameter name");
        }
        StringBuilder applianceParameter = new StringBuilder();
        applianceParameter.append(applianceParameterName);
        String applianceParameterValue = request.getApplianceParameterValue();
        if (!dataValidator.isParameterValueValid(applianceParameterName,
                applianceParameterValue)) {
            throw new ServiceException("Incorrect appliance parameter value");
        }
        applianceParameter.append(EQUALITY);
        applianceParameter.append(request.getApplianceParameterValue());
        applianceParameter.append(COMMA);
        try {
            List<String> appliancesString = applianceDao.findAllByTag(applianceParameter.toString());
            List<Appliance> appliances = createAppliancesFromStringList(appliancesString);
            if (appliances.isEmpty()) {
                throw new ServiceException("Appliance isn't found");
            }
            return appliances;
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
    }

    public List<Appliance> findApplianceByTag(Request request) throws ServiceException {
        ApplianceDao applianceDao = new ApplianceDaoImpl();
        DataValidator dataValidator = new DataValidator();
        if (request.getApplianceType() == null ||
                request.getApplianceParameter() == null ||
                request.getApplianceParameterValue() == null) {
            throw new ServiceException("Incorrect searching parameters");
        }
        String applianceType = request.getApplianceType().toString();
        String applianceParameterName = request.getApplianceParameter().toString();
        if (!dataValidator.isParameterNameValid(applianceParameterName)) {
            throw new ServiceException("Incorrect appliance parameter name");
        }
        StringBuilder applianceParameter = new StringBuilder();
        applianceParameter.append(applianceParameterName);
        String applianceParameterValue = request.getApplianceParameterValue();
        if (!dataValidator.isParameterValueValid(applianceParameterName,
                applianceParameterValue)) {
            throw new ServiceException("Incorrect appliance parameter value");
        }
        applianceParameter.append(EQUALITY);
        applianceParameter.append(request.getApplianceParameterValue());
        applianceParameter.append(COMMA);
        try {
            List<String> appliancesString = applianceDao.findApplianceByTag(applianceType, applianceParameter.toString());
            List<Appliance> appliances = createAppliancesFromStringList(appliancesString);
            if (appliances.isEmpty()) {
                throw new ServiceException("Appliance isn't found");
            }
            return appliances;
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
    }

    private List<Appliance> createAppliancesFromStringList(List<String> appliancesString) throws ServiceException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        ApplianceCreator applianceCreator = new ApplianceCreator();
        List<String> applianceListParameters;
        List<Appliance> appliances = new ArrayList<>();
        Appliance appliance;
        for (String app : appliancesString) {
            applianceListParameters = dataParser.applianceParse(app);
            if (!dataValidator.isApplianceValid(applianceListParameters)) {
                throw new ServiceException("Incorrect parameters in file");
            }
            appliance = applianceCreator.createAppliance(applianceListParameters);
            appliances.add(appliance);
        }
        return appliances;
    }
}