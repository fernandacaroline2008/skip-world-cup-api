/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import com.skipthedishes.skipworldcupapi.model.Product;

/**
 * @author fcsantos
 *
 */
public interface ProductService {
    List<Product> findAll();

    List<Product> findByName(String name);

    Product findById(Long id);
}
