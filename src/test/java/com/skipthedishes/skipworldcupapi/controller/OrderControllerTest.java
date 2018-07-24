/**
 *
 */
package com.skipthedishes.skipworldcupapi.controller;

import static com.skipthedishes.skipworldcupapi.controller.OrderController.ORDER_BASE_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class OrderControllerTest {

    private MockMvc mockMvc;
    private static final long ORDER_ID = 1;
    private static final long INVALID_ORDER_ID = 99999;
    private static final String CANCELLED = "CANCELLED";

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findAll_withStatus_shouldReturnOrders() throws Exception {
	mockMvc.perform(get(ORDER_BASE_URI + "?status=IN_PROGRESS")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void findAll_withoutStatus_shouldReturnOrders() throws Exception {
	mockMvc.perform(get(ORDER_BASE_URI)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(5)));
    }

    @Test
    public void findById_withValidId_shouldReturnOrder() throws Exception {
	mockMvc.perform(get(ORDER_BASE_URI + "/{id}", ORDER_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.id", Matchers.is(1))).andExpect(jsonPath("$.seatNumber", Matchers.is("A1")));
    }

    @Test
    public void findById_withInvalidId_shouldReturnNotFound() throws Exception {
	mockMvc.perform(get(ORDER_BASE_URI + "/{id}", INVALID_ORDER_ID)).andExpect(status().isNotFound());
    }

    @Test
    public void updateStatus_withValidId_shouldReturnOrder() throws Exception {
	mockMvc.perform(post(ORDER_BASE_URI + "/{id}/updateStatus/{status}", ORDER_ID, CANCELLED))
		.andExpect(status().isCreated());
    }

    @Test
    public void updateStatus_withInvalidId_shouldReturnNotFound() throws Exception {
	mockMvc.perform(post(ORDER_BASE_URI + "/{id}/updateStatus/{status}", INVALID_ORDER_ID, CANCELLED))
		.andExpect(status().isNotFound());
    }

}
