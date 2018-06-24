/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.skipworldcupapi.model.Restaurant;
import com.skipthedishes.skipworldcupapi.repository.RestaurantRepository;

/**
 * @author fcsantos
 *
 */
@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
	return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findByName(String name) {
	return restaurantRepository.findByName(name);
    }

    @Override
    public Restaurant findById(Long id) {
	return restaurantRepository.findById(id).orElse(null);
    }
}
