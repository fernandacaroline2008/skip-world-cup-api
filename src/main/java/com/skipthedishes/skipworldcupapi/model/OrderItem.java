/**
 *
 */
package com.skipthedishes.skipworldcupapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author fcsantos
 *
 */
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_product_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;

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
     * @return the order
     */
    public Order getOrder() {
	return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
	this.order = order;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
	return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(Product product) {
	this.product = product;
    }

    /**
     * @return the quantity
     */
    public Long getQuantity() {
	return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(Long quantity) {
	this.quantity = quantity;
    }

}
