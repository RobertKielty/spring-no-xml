package com.test.healthcheck;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HealthCheckControllerTest {

    private HealthCheckService healthCheckService;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        healthCheckService = mock(HealthCheckService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new HealthCheckController(healthCheckService)).build();
    }

    @Test
    public void shouldAssertHealthCheckResult() throws Exception {
        String healthString = "foo bar";
        when(healthCheckService.getHealthCheckString()).thenReturn(healthString);
        mockMvc.perform(get("/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string(healthString))
                .andReturn();
    }
}
