/**
 *
 */
package com.skipthedishes.skipworldcupapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.skipworldcupapi.model.Order;
import com.skipthedishes.skipworldcupapi.service.OrderService;

import io.swagger.annotations.Api;

/**
 * @author fcsantos
 *
 */
@Api(value = "orders", tags = "Orders")
@RestController
@RequestMapping(OrderController.ORDER_BASE_URI)
public class OrderController {

    public static final String ORDER_BASE_URI = "/api/v1/orders";

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
	orderService.create(order);
	return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(@RequestParam(value = "status", required = false) String status) {
	List<Order> orders = null;
	if (status != null) {
	    orders = orderService.findByStatus(status);
	} else {
	    orders = orderService.findAll();
	}
	return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") Long id) {
	Order order = orderService.findById(id);
	if (order == null) {
	    LOG.debug("Order ID {} not found.", id);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("{id}/updateStatus/{status}")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @PathVariable String status) {
	if (orderService.findById(id) == null) {
	    LOG.debug("Order ID {} not found.", id);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	orderService.updateStatus(id, status);

	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
