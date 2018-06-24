/**
 *
 */
package com.skipthedishes.skipworldcupapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skipthedishes.skipworldcupapi.model.Order;
import com.skipthedishes.skipworldcupapi.model.OrderStatus;

/**
 * @author fcsantos
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(@Param("status") OrderStatus status);
}
