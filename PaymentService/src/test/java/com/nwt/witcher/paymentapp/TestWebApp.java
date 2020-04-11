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

public class TestWebApp extends PaymentServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testNaplata() throws Exception {
		mockMvc.perform(get("/naplata")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.NaplataID").value(1)).andExpect(jsonPath("$.KorisnikID").value(2))
				.andExpect(jsonPath("$.Opis").value("Opis naplate")).andExpect(jsonPath("$.StavkaProdajeID").value(1))
				.andExpect(jsonPath("$.Valuta").value("BAM")).andExpect(jsonPath("$.AdresaDostave").value("Adresa 14"));

	}

}
