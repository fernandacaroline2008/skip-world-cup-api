/**
 *
 */
package com.skipthedishes.skipworldcupapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fcsantos
 *
 */
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String logo;

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
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
	return logo;
    }

    /**
     * @param logo
     *            the logo to set
     */
    public void setLogo(String logo) {
	this.logo = logo;
    }

}
