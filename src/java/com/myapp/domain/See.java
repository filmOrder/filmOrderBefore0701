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
public class See {
    private int seeId;
    private String seeBuyerId;
    private int seeFilmId;
    private int seeType;

    public int getSeeId() {
        return seeId;
    }

    public void setSeeId(int seeId) {
        this.seeId = seeId;
    }

    public String getSeeBuyerId() {
        return seeBuyerId;
    }

    public void setSeeBuyerId(String seeBuyerId) {
        this.seeBuyerId = seeBuyerId;
    }

    public int getSeeFilmId() {
        return seeFilmId;
    }

    public void setSeeFilmId(int seeFilmId) {
        this.seeFilmId = seeFilmId;
    }

    public int getSeeType() {
        return seeType;
    }

    public void setSeeType(int seeType) {
        this.seeType = seeType;
    }
    
}
