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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.skipworldcupapi.model.Client;
import com.skipthedishes.skipworldcupapi.service.ClientService;

import io.swagger.annotations.Api;

/**
 * @author fcsantos
 *
 */
@Api(value = "clients", tags = "Clients")
@RestController
@RequestMapping(ClientController.CLIENT_BASE_URI)
public class ClientController {
    public static final String CLIENT_BASE_URI = "/api/v1/clients";

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(@RequestParam(value = "name", required = false) String name) {
	List<Client> clients = null;
	if (name != null) {
	    clients = clientService.findByName(name);
	} else {
	    clients = clientService.findAll();
	}
	return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
	Client client = clientService.findById(id);
	if (client == null) {
	    LOG.debug("Client ID {} not found.", id);
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
