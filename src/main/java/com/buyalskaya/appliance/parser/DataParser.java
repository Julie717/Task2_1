package com.buyalskaya.appliance.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private final static String REGEX_APPLIANCE_NAME = "\\s*(\\pL.+)\\s*:";
    private final static String REGEX_APPLIANCE_PARAMETER = "([\\pL_]+)\\s*=\\s*[\\pL\\d.-]+";

    public List<String> applianceParse(String appliance) {
        Pattern pattern = Pattern.compile(REGEX_APPLIANCE_NAME);
        Matcher matcher = pattern.matcher(appliance);
        List<String> applianceParameters = new ArrayList<>();
        if (matcher.find()) {
            applianceParameters.add(matcher.group(1));
        }
        pattern = Pattern.compile(REGEX_APPLIANCE_PARAMETER);
        matcher = pattern.matcher(appliance);
        while (matcher.find()) {
            applianceParameters.add(matcher.group(0));
        }
        return applianceParameters;
    }
}