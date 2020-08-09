package com.buyalskaya.appliance.model.dao.impl;

import com.buyalskaya.appliance.exception.DaoException;
import com.buyalskaya.appliance.model.dao.ApplianceDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ApplianceDaoImpl implements ApplianceDao {
    private static final String DEFAULT_PATH = "resources/appliances_db.txt";

    @Override
    public List<String> findAll() throws DaoException {
        List<String> appliances;
        try (FileReader fileReader = new FileReader(DEFAULT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            appliances = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error in opening file " + DEFAULT_PATH, e);
        }
        return appliances;
    }

    @Override
    public List<String> findAppliance(String applianceType) throws DaoException {
        List<String> appliances;
        try (FileReader fileReader = new FileReader(DEFAULT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            appliances = bufferedReader.lines()
                    .filter(a -> a.toUpperCase().contains(applianceType))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error in opening file " + DEFAULT_PATH, e);
        }
        return appliances;
    }

    @Override
    public List<String> findAllByTag(String applianceParameter) throws DaoException {
        List<String> appliances;
        try (FileReader fileReader = new FileReader(DEFAULT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            appliances = bufferedReader.lines()
                    .filter(a -> a.toUpperCase().contains(applianceParameter))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error in opening file " + DEFAULT_PATH, e);
        }
        return appliances;
    }

    @Override
    public List<String> findApplianceByTag(String applianceType, String applianceParameter) throws DaoException {
        List<String> appliances;
        try (FileReader fileReader = new FileReader(DEFAULT_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            appliances = bufferedReader.lines()
                    .filter(a -> a.toUpperCase().contains(applianceType))
                    .filter(a -> a.toUpperCase().contains(applianceParameter))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error in opening file " + DEFAULT_PATH, e);
        }
        return appliances;
    }
}