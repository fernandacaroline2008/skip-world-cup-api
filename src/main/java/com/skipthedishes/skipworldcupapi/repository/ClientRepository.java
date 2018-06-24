/**
 *
 */
package com.skipthedishes.skipworldcupapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skipthedishes.skipworldcupapi.model.Client;

/**
 * @author fcsantos
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c where lower(c.name) LIKE lower(concat('%', :name,'%'))")
    List<Client> findByName(@Param("name") String name);
}
