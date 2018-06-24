/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import com.skipthedishes.skipworldcupapi.model.Order;

/**
 * @author fcsantos
 *
 */
public interface OrderService {

    void create(Order order);

    List<Order> findAll();

    List<Order> findByStatus(String status);

    Order findById(Long id);

    void updateStatus(Long id, String status);

    void update(Order order);
}
