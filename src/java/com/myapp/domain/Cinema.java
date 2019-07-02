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
public class Cinema {
    private String cinemaId;
    private String cinemaUsrName;
    private String cinemaPwd;
    private String cinemaName;
    private String cinemaAddr;
    private String cinemaTel;
    private String cinemaService;
    private int cinemaMoney = 0;

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaUsrName() {
        return cinemaUsrName;
    }

    public void setCinemaUsrName(String cinemaUsrName) {
        this.cinemaUsrName = cinemaUsrName;
    }

    public String getCinemaPwd() {
        return cinemaPwd;
    }

    public void setCinemaPwd(String cinemaPwd) {
        this.cinemaPwd = cinemaPwd;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddr() {
        return cinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.cinemaAddr = cinemaAddr;
    }

    public String getCinemaTel() {
        return cinemaTel;
    }

    public void setCinemaTel(String cinemaTel) {
        this.cinemaTel = cinemaTel;
    }

    public String getCinemaService() {
        return cinemaService;
    }

    public void setCinemaService(String cinemaService) {
        this.cinemaService = cinemaService;
    }

    public int getCinemaMoney() {
        return cinemaMoney;
    }

    public void setCinemaMoney(int cinemaMoney) {
        this.cinemaMoney = cinemaMoney;
    }
    
}
