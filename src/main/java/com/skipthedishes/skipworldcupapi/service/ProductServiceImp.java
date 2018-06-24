/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.skipworldcupapi.model.Product;
import com.skipthedishes.skipworldcupapi.repository.ProductRepository;

/**
 * @author fcsantos
 *
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
	return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
	return productRepository.findByName(name);
    }

    @Override
    public Product findById(Long id) {
	return productRepository.findById(id).orElse(null);
    }

}
