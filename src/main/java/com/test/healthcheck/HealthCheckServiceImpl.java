package com.test.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    private String healthCheckString;
    private String testBean;

    @Autowired
    public HealthCheckServiceImpl(@Value("${healthcheck.string:ok}") String healthCheckString,
                                  String testBean) {
        this.healthCheckString = healthCheckString;
        this.testBean = testBean;
    }

    @Override
    public String getHealthCheckString() {
        return healthCheckString + testBean;
    }
}
