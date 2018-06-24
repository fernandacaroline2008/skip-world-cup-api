/**
 *
 */
package com.skipthedishes.skipworldcupapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skipthedishes.skipworldcupapi.model.Product;

/**
 * @author fcsantos
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p where lower(p.name) LIKE lower(concat('%', :name,'%'))")
    List<Product> findByName(@Param("name") String name);
}
