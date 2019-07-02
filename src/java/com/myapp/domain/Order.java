/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

/**
 *
 * @author tellw
 */
public class Order {
    private int orderId;
    private String buyerId;
    private int cinemaFilmId;
    private int seatRow;
    private int seatColumn;
    private String orderTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public int getCinemaFilmId() {
        return cinemaFilmId;
    }

    public void setCinemaFilmId(int cinemaFilmId) {
        this.cinemaFilmId = cinemaFilmId;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
