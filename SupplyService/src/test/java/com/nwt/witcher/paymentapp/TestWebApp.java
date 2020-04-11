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

public class TestWebApp extends SupplyServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testProizvod() throws Exception {
		mockMvc.perform(get("/proizvod")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.ProizvodID").value(1)).andExpect(jsonPath("$.Cijena").value(10.00))
				.andExpect(jsonPath("$.Naziv").value("Proizvod")).andExpect(jsonPath("$.RaspolozivaKolicina").value(100));

	}
	@Test
	public void testStavkaProdaje() throws Exception {
		mockMvc.perform(get("/stavkaProdaje")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.ProizvodID").value(1)).andExpect(jsonPath("$.Kolicina").value(50))
				.andExpect(jsonPath("$.StavkaProdajeID").value(1)).andExpect(jsonPath("$.UkupnaCijena").value(500.00));

	}

}
