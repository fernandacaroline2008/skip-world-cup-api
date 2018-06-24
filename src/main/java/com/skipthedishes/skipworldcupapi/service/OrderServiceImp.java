/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skipthedishes.skipworldcupapi.model.Order;
import com.skipthedishes.skipworldcupapi.model.OrderStatus;
import com.skipthedishes.skipworldcupapi.repository.OrderRepository;

/**
 * @author fcsantos
 *
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void create(Order order) {
	order.setStatus(OrderStatus.ORDERED);
	orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
	return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
	return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findByStatus(String status) {
	return orderRepository.findByStatus(OrderStatus.fromString(status));
    }

}
