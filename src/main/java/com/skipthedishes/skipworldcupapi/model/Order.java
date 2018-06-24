/**
 *
 */
package com.skipthedishes.skipworldcupapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author fcsantos
 *
 */
@Entity
@Table(name = "command")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = true)
    private String seatNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the client
     */
    public Client getClient() {
	return client;
    }

    /**
     * @param client
     *            the client to set
     */
    public void setClient(Client client) {
	this.client = client;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
	return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(OrderStatus status) {
	this.status = status;
    }

    /**
     * @return the orderItems
     */
    public Set<OrderItem> getOrderItems() {
	return orderItems;
    }

    /**
     * @param orderItems
     *            the orderItems to set
     */
    public void setOrderItems(Set<OrderItem> orderItems) {
	this.orderItems = orderItems;
    }

    /**
     * @return the seatNumber
     */
    public String getSeatNumber() {
	return seatNumber;
    }

    /**
     * @param seatNumber
     *            the seatNumber to set
     */
    public void setSeatNumber(String seatNumber) {
	this.seatNumber = seatNumber;
    }

}
