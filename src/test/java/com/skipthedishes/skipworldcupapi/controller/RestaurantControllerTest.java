/**
 *
 */
package com.skipthedishes.skipworldcupapi.controller;

import static com.skipthedishes.skipworldcupapi.controller.RestaurantController.RESTAURANT_BASE_URI;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.skipthedishes.skipworldcupapi.service.RestaurantService;

/**
 * @author fcsantos
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RestaurantControllerTest {

    private MockMvc mockMvc;
    private static final long RESTAURANT_ID = 1;
    private static final long INVALID_RESTAURANT_ID = 99999;

    @Autowired
    private WebApplicationContext context;

    @Mock
    private RestaurantService restaurantService;

    @Before
    public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findAll_withName_shouldReturnRestaurants() throws Exception {
	mockMvc.perform(get(RESTAURANT_BASE_URI + "?name=Restaurant A")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void findAll_withoutName_shouldReturnRestaurants() throws Exception {
	mockMvc.perform(get(RESTAURANT_BASE_URI)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

    @Test
    public void findById_withValidId_shouldReturnRestaurant() throws Exception {
	mockMvc.perform(get(RESTAURANT_BASE_URI + "/{id}", RESTAURANT_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.id", Matchers.is(1))).andExpect(jsonPath("$.name", Matchers.is("Restaurant A")))
		.andExpect(jsonPath("$.logo", Matchers.is("1.png")));
    }

    @Test
    public void findById_withInvalidId_shouldReturnRestaurant() throws Exception {
	mockMvc.perform(get(RESTAURANT_BASE_URI + "/{id}", INVALID_RESTAURANT_ID)).andExpect(status().isNotFound());
    }

}
