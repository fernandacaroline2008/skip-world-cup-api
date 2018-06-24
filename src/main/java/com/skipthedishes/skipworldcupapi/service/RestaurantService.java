/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import com.skipthedishes.skipworldcupapi.model.Restaurant;

/**
 * @author fcsantos
 *
 */
public interface RestaurantService {
    List<Restaurant> findAll();

    List<Restaurant> findByName(String name);

    Restaurant findById(Long id);
}
