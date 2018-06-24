package com.skipthedishes.skipworldcupapi.model;

/**
 * @author fcsantos
 *
 */
public enum OrderStatus {
    ORDERED("ORDERED"), IN_PROGRESS("IN_PROGRESS"), DELIVERING("DELIVERING"), COMPLETED("COMPLETED"), CANCELLED(
	    "CANCELLED");

    private String value;

    OrderStatus(String value) {
	this.value = value;
    }

    public static OrderStatus fromString(String text) {
	for (OrderStatus orderStatus : OrderStatus.values()) {
	    if (orderStatus.value.equalsIgnoreCase(text)) {
		return orderStatus;
	    }
	}
	return null;
    }
}
