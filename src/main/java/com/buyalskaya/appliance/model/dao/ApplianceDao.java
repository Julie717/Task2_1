package com.buyalskaya.appliance.model.dao;

import com.buyalskaya.appliance.exception.DaoException;

import java.util.*;

public interface ApplianceDao {
    List<String> findAll() throws DaoException;

    List<String> findAppliance(String applianceType) throws DaoException;

    List<String> findAllByTag(String applianceParameter) throws DaoException;

    List<String> findApplianceByTag(String applianceType, String applianceParameter) throws DaoException;
}