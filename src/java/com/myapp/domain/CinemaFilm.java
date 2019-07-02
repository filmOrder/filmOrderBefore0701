/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import java.util.Date;

/**
 *
 * @author tellw
 */
public class CinemaFilm {
    private int cinemaFilmId;
    private String showCinemaId;
    private int showFilmId;
    private int showRoomId;
    private int showTime;
    private int price;
    private String showDate;
    private Date newShowDate;

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public Date getNewShowDate() {
        return newShowDate;
    }

    public void setNewShowDate(Date newShowDate) {
        this.newShowDate = newShowDate;
    }

    public int getCinemaFilmId() {
        return cinemaFilmId;
    }

    public void setCinemaFilmId(int cinemaFilmId) {
        this.cinemaFilmId = cinemaFilmId;
    }

    public String getShowCinemaId() {
        return showCinemaId;
    }

    public void setShowCinemaId(String showCinemaId) {
        this.showCinemaId = showCinemaId;
    }

    public int getShowFilmId() {
        return showFilmId;
    }

    public void setShowFilmId(int showFilmId) {
        this.showFilmId = showFilmId;
    }

    public int getShowRoomId() {
        return showRoomId;
    }

    public void setShowRoomId(int showRoomId) {
        this.showRoomId = showRoomId;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
