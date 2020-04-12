package com.nwt.witcher.paymentapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends AuthorizationServiceApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAktivnosti() throws Exception {
        mockMvc.perform(get("/aktivnosti")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.AktivnostiID").value(1)).andExpect(jsonPath("$.Metoda").value("..."))
                .andExpect(jsonPath("$.URL").value("url")).andExpect(jsonPath("$.URLRegex").value("regex"));

    }

    @Test
    public void testAktivnostiDopustenja() throws Exception {
        mockMvc.perform(get("/aktivnostiDopustenja")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.AktivnostiDopustenjaID").value(1)).andExpect(jsonPath("$.AktivnostiID").value(1))
                .andExpect(jsonPath("$.DopustenjaID").value(1));

    }

    @Test
    public void testDopustenja() throws Exception {
        mockMvc.perform(get("/dopustenja")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.DopustenjaID").value(1)).andExpect(jsonPath("$.Naziv").value("Naziv dopustenja"))
                .andExpect(jsonPath("$.KreiranaU").value(null)).andExpect(jsonPath("$.AzuriranaU").value(null));

    }

    @Test
    public void testKorisnickaDopustenja() throws Exception {
        mockMvc.perform(get("/korisnickaDopustenja")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.KorisnickaDopustenjaID").value(1)).andExpect(jsonPath("$.DopustenjaID").value(1))
                .andExpect(jsonPath("$.UlogaaID").value(1));

    }

}
