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

import com.skipthedishes.skipworldcupapi.model.Product;
import com.skipthedishes.skipworldcupapi.service.ProductService;

import io.swagger.annotations.Api;

/**
 * @author fcsantos
 *
 */
@Api(value = "products", tags = "Products")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(@Param("name") String name) {
	List<Product> products = null;
	if (name == null) {
	    products = productService.findAll();
	} else {
	    products = productService.findByName(name);
	}
	return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
	Product product = productService.findById(id);
	if (product == null) {
	    LOG.debug("Product ID {} not found.", id);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
