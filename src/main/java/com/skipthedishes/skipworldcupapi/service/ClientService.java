/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import com.skipthedishes.skipworldcupapi.model.Client;

/**
 * @author fcsantos
 *
 */
public interface ClientService {
    List<Client> findAll();

    List<Client> findByName(String name);

    Client findById(Long id);
}
