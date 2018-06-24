/**
 *
 */
package com.skipthedishes.skipworldcupapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.skipworldcupapi.model.Restaurant;
import com.skipthedishes.skipworldcupapi.service.RestaurantService;

import io.swagger.annotations.Api;

/**
 * @author fcsantos
 *
 */
@Api(value = "restaurants", tags = "Restaurants")
@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll(@Param("name") String name) {
	List<Restaurant> restaurants = null;
	if (name == null) {
	    restaurants = restaurantService.findAll();
	} else {
	    restaurants = restaurantService.findByName(name);
	}
	return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable("id") Long id) {
	Restaurant restaurant = restaurantService.findById(id);
	if (restaurant == null) {
	    LOG.debug("Restaurant ID {} not found.", id);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
