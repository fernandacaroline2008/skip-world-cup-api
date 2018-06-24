/**
 *
 */
package com.skipthedishes.skipworldcupapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skipthedishes.skipworldcupapi.model.Restaurant;

/**
 * @author fcsantos
 *
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r where lower(r.name) LIKE lower(concat('%', :name,'%'))")
    List<Restaurant> findByName(@Param("name") String name);
}
