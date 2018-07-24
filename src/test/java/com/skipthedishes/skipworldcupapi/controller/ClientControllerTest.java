/**
 *
 */
package com.skipthedishes.skipworldcupapi.controller;

import static com.skipthedishes.skipworldcupapi.controller.ClientController.CLIENT_BASE_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author fcsantos
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ClientControllerTest {

    private MockMvc mockMvc;
    private static final long CLIENT_ID = 1;
    private static final long INVALID_CLIENT_ID = 99999;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findAll_withName_shouldReturnClients() throws Exception {
	mockMvc.perform(get(CLIENT_BASE_URI + "?name=Fernanda")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void findAll_withoutName_shouldReturnClients() throws Exception {
	mockMvc.perform(get(CLIENT_BASE_URI)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(4)));
    }

    @Test
    public void findById_withValidId_shouldReturnClient() throws Exception {
	mockMvc.perform(get(CLIENT_BASE_URI + "/{id}", CLIENT_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.id", Matchers.is(1)))
		.andExpect(jsonPath("$.name", Matchers.is("Fernanda Caroline")));
    }

    @Test
    public void findById_withInvalidId_shouldReturnNotFound() throws Exception {
	mockMvc.perform(get(CLIENT_BASE_URI + "/{id}", INVALID_CLIENT_ID)).andExpect(status().isNotFound());
    }

}
