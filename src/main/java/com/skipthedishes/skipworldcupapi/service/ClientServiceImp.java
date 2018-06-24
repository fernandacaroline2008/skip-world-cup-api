/**
 *
 */
package com.skipthedishes.skipworldcupapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.skipworldcupapi.model.Client;
import com.skipthedishes.skipworldcupapi.repository.ClientRepository;

/**
 * @author fcsantos
 *
 */
@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
	return clientRepository.findAll();
    }

    @Override
    public List<Client> findByName(String name) {
	return clientRepository.findByName(name);
    }

    @Override
    public Client findById(Long id) {
	return clientRepository.findById(id).orElse(null);
    }

}
