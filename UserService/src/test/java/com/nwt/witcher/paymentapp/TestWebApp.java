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

public class TestWebApp extends UserServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testKorisnickeRole() throws Exception {
		mockMvc.perform(get("/korisnickeRole")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.KorisnickaRolaID").value(1)).andExpect(jsonPath("$.KorisnikID").value(1))
				.andExpect(jsonPath("$.RolaID").value(1));

	}
	@Test
	public void testKorisnik() throws Exception {
		mockMvc.perform(get("/korisnik")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.KorisnikID").value(1)).andExpect(jsonPath("$.BrojKartice").value("12345678"))
				.andExpect(jsonPath("$.Godine").value(20)).andExpect(jsonPath("$.Ime").value("Ime"))
				.andExpect(jsonPath("$.Prezime").value("Prezime"));

	}
	@Test
	public void testRola() throws Exception {
		mockMvc.perform(get("/role")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.RolaID").value(1)).andExpect(jsonPath("$.NazivRole").value("Premium korisnik"))
				.andExpect(jsonPath("$.AzuriranaU").value(null)).andExpect(jsonPath("$.KreiranaU").value(null));

	}

}
