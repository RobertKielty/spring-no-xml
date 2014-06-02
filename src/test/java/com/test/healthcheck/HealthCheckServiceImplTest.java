package com.test.healthcheck;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HealthCheckServiceImplTest {

    private HealthCheckService healthCheckService;

    @Test
    public void shouldReturnString() throws Exception {
        healthCheckService = new HealthCheckServiceImpl("foo", "bar");
        assertThat(healthCheckService.getHealthCheckString(), is("foobar"));
    }
}
